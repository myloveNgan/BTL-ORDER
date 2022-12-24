package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.tableDao;
import Database.JDBC;
import model.tablecode;

import javax.swing.ImageIcon;

public class View_Table extends JFrame {
	int idSave = -1;
	private JPanel contentPane;
	private JTextField textField_soBan;
	private JTextField textField_ghiChu;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Table frame = new View_Table();
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
	public View_Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1189, 564);
		setTitle("Quản lý bàn");
		this.setLocationRelativeTo(null);
		Image icon = new ImageIcon(this.getClass().getResource("/table-icon.png")).getImage();
		this.setIconImage(icon);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image iconBack = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		JButton btn_back = new JButton(new ImageIcon(iconBack));
		btn_back.setText(" Quay lại");
		btn_back.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_back.setForeground(new Color(0, 0, 0));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_back.setBounds(10, 22, 151, 49);
		contentPane.add(btn_back);
		btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnHomeAction(evt);
            }

			
    });

		Image iconAddTable = new ImageIcon(this.getClass().getResource("/add-icon.png")).getImage();
		JButton btn_addTable = new JButton(new ImageIcon(iconAddTable));
		btn_addTable.setText("Thêm Bàn");
		btn_addTable.setForeground(Color.BLACK);
		btn_addTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_addTable.setBounds(24, 386, 176, 61);
		contentPane.add(btn_addTable);
		btn_addTable.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddTable(evt);
			}
		});

		Image iconDeleteTable = new ImageIcon(this.getClass().getResource("/Close-icon.png")).getImage();
		JButton btn_removeTable = new JButton(new ImageIcon(iconDeleteTable));
		btn_removeTable.setText("Xóa Bàn");
		btn_removeTable.setForeground(Color.BLACK);
		btn_removeTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_removeTable.setBounds(210, 386, 168, 61);
		contentPane.add(btn_removeTable);
		btn_removeTable.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteTable(evt);
			}
		});

		Image iconEditTable = new ImageIcon(this.getClass().getResource("/edit-icon.png")).getImage();
		JButton btn_editTable = new JButton(new ImageIcon(iconEditTable));
		btn_editTable.setText("Sửa Bàn");
		btn_editTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate(e);
			}
		});
		btn_editTable.setForeground(Color.BLACK);
		btn_editTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_editTable.setBounds(388, 386, 168, 61);
		contentPane.add(btn_editTable);

		JLabel lblNewLabel1 = new JLabel("Số bàn :");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel1.setBounds(190, 173, 94, 42);
		contentPane.add(lblNewLabel1);

		JLabel lblGhiCh = new JLabel("Ghi chú :");
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGhiCh.setBounds(190, 225, 138, 42);
		contentPane.add(lblGhiCh);

		textField_soBan = new JTextField();
		textField_soBan.setBounds(279, 182, 208, 32);
		contentPane.add(textField_soBan);
		textField_soBan.setColumns(10);

		textField_ghiChu = new JTextField();
		textField_ghiChu.setColumns(10);
		textField_ghiChu.setBounds(279, 234, 208, 32);
		contentPane.add(textField_ghiChu);

		JLabel lblQunLBn = new JLabel("Quản Lý Bàn");
		lblQunLBn.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQunLBn.setBounds(217, 105, 183, 42);
		contentPane.add(lblQunLBn);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "S\u1ED1 b\u00E0n", "Tr\u1EA1ng th\u00E1i", "Ghi ch\u00FA"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(607, 10, 558, 449);
		contentPane.add(scrollPane);
		
		Image iconBackGroup = new ImageIcon(this.getClass().getResource("/backgroup-coffee.png")).getImage();

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblDisplayMouseClicked(evt);
			}
		});
		this.addListTableRow();
		this.setVisible(true);
	}

	protected void btnHomeAction(ActionEvent evt) {
		dispose();
	}

	public void removeText() {
		this.textField_soBan.setText("");
		this.textField_ghiChu.setText("");
	}

	public void btnAddTable(java.awt.event.ActionEvent evt) {
		Connection con = JDBC.getConnection();
		try {
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("INSERT INTO tables(table_name,note,status) "
					+ "VALUES ('"+ textField_soBan.getText() + "','" + textField_ghiChu.getText() + "',0)");
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "Thêm mới thành công!!");
				addListTableRow();
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addListTableRow() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		ArrayList<tablecode> listTable = tableDao.getInstance().listTable();

		for (int i = 0; i < listTable.size(); i++) {
			tablecode tables = listTable.get(i);
			Object[] dt = { i + 1, tables.getNumberTable(), tables.getNote(), tables.getStatus() };
			tableModel.addRow(dt);
		}
	}

	private void btnDeleteTable(java.awt.event.ActionEvent evt) {
		Connection con;
		PreparedStatement pstmt;

		if (idSave >= 0) {
			con = JDBC.getConnection();
			try {
				pstmt = con.prepareStatement("Delete from tables where id=?");
				pstmt.setInt(1, idSave);
				int i = pstmt.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Xóa bàn thành công!!");
					addListTableRow();
					idSave = -1;
					removeText();

				} else {
					JOptionPane.showMessageDialog(null, "Xóa bàn thất bại!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "");
		}
	}

	private void btnUpdate(java.awt.event.ActionEvent evt) {

		if (idSave >= 0) {
			Connection con;
			PreparedStatement pstmt;

			con = JDBC.getConnection();
			try {
				pstmt = con.prepareStatement("update tables set table_name=?, note=? where ID=?");
				pstmt.setString(1, textField_soBan.getText());
				pstmt.setString(2, textField_ghiChu.getText());

				pstmt.setInt(3, idSave);

				int i = pstmt.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Sửa bàn thành công");
					addListTableRow();
				} else {
					JOptionPane.showMessageDialog(null, "Sữa bàn thất bại");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "");
		}
	}

	private void tblDisplayMouseClicked(java.awt.event.MouseEvent evt) {
        int row = table.getSelectedRow();
        ArrayList<tablecode> listTable = tableDao.getInstance().listTable();
        idSave = listTable.get(row).getTableId();
        this.textField_soBan.setText(table.getValueAt(row, 1) + "");
        this.textField_ghiChu.setText(table.getValueAt(row, 3) + "");
    }
}
