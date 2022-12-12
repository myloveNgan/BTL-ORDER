package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.tableController;

public class View_Order extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Order frame = new View_Order();
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
	public View_Order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1443, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image iconHD = new ImageIcon(this.getClass().getResource("/hoadon-con.png")).getImage();
		JLabel lblNewLabel = new JLabel(new ImageIcon(iconHD));
		lblNewLabel.setText("Quản Lý Bán Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(641, 10, 232, 46);
		contentPane.add(lblNewLabel);
		
		Image iconBack = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		JButton btnNewButton = new JButton(new ImageIcon(iconBack));
		btnNewButton.setText("Quay lại");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(30, 45, 151, 41);
		contentPane.add(btnNewButton);
		
		Image iconAdd = new ImageIcon(this.getClass().getResource("/add-icon.png")).getImage();
		JButton btnThm = new JButton(new ImageIcon(iconAdd));
		btnThm.setText("Thêm đồ uống");
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm.setBounds(993, 126, 185, 74);
		contentPane.add(btnThm);
		
		Image iconTT = new ImageIcon(this.getClass().getResource("/tongtien-icon.png")).getImage();
		JButton btnThanhTon = new JButton(new ImageIcon(iconTT));
		btnThanhTon.setText("Thanh toán");
		btnThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThanhTon.setBounds(1203, 126, 216, 74);
		contentPane.add(btnThanhTon);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng tiền");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(1085, 296, 83, 21);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên bàn", "Trạng thái", "Ghi chú"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 126, 484, 474);
		contentPane.add(scrollPane);
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(511, 126, 164, 46);
		contentPane.add(comboBox);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên Đồ Uống", "Giá", "Số Lượng", "Thành Tiền"
			}
		));
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(504, 228, 484, 372);
		contentPane.add(scrollPane_1);
		tableController controller = new tableController(this);
		btnNewButton.addActionListener(controller);
		this.setVisible(true);

		
		
		
		
	}
}
