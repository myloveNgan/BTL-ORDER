package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.JDBC;

public class View_Statiscal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Statiscal frame = new View_Statiscal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_Statiscal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Image icon = new ImageIcon(this.getClass().getResource("/hoadon-con.png")).getImage();
		this.setIconImage(icon);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image iconBack = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		JButton btnHome = new JButton(new ImageIcon(iconBack));
		btnHome.setText("Quay lại");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBounds(10, 10, 141, 49);
		contentPane.add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHome(e);	
			}
		});
		
		JLabel lblNewLabel = new JLabel("Thống kê hóa đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(338, 8, 345, 49);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Nhân viên", "Tên bàn", "Tổng tiền",
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 99, 853, 327);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Doanh thu : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(365, 464, 151, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(doanhThu()+"VND");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(505, 466, 211, 27);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Lưu ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(716, 464, 106, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("VND");
				reset(e);	
			}
		});
		
		loadTableThongKe();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	 private void btnHome(java.awt.event.ActionEvent evt) {    
	        dispose();
	    }
	 
	 
	 private void loadTableThongKe() {
		 DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	        tableModel.setRowCount(0);
	        Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("SELECT account.name, tables.table_name, invoice.total_price, invoice.invoice_date "
	            		+ "FROM invoice, tables,account "
	            		+ "WHERE invoice.tables_id=tables.ID AND invoice.account_ID=account.ID AND invoice.status=1");
	            ResultSet rs = pstmt.executeQuery();
	            int i = 1;
	            while (rs.next()) {
	                Object[] dt = {i++, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4)};
	                tableModel.addRow(dt);
	            }
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	    }
	 
	 private float doanhThu(){
		 float sumMoney = 0 ;
		 DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	        tableModel.setRowCount(0);
	        Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("SELECT account.name, tables.table_name, invoice.total_price, invoice.invoice_date "
	            		+ "FROM invoice,tables,account "
	            		+ "WHERE invoice.tables_id=tables.ID AND invoice.account_ID=account.ID AND invoice.status=1");
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	sumMoney += rs.getFloat(3);	     
	            }        
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
			return sumMoney;
	    }
	 
	 private void reset(ActionEvent e) {
		 table.setModel(new DefaultTableModel(null, new String[] {
					"STT", "Nhân viên", "Tên bàn", "Tổng tiền",
				}));
		 
		 Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("delete from orders");
	            PreparedStatement pstmt2 = con.prepareStatement("delete from invoice");

	            pstmt.executeUpdate();
	            pstmt2.executeUpdate();
	        } catch (Exception ex) {
	           ex.printStackTrace();
	        }
	 }
}
