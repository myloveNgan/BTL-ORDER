package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.tableController;
import Dao.loginDao;
import model.login;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class View_Contanner extends JFrame {

	private JPanel contentPane;
	private View_Login vl;
	
	

	
	public View_Contanner(View_Login vl) { /*String s*/
		this.vl = vl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 537);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Tài Khoản");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thêm tài khoản");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Chung");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(345, 10, 197, 82);
		contentPane.add(lblNewLabel);
		
		Image iconTable = new ImageIcon(this.getClass().getResource("/table-icon.png")).getImage();
		JButton btnNewButtonTable = new JButton();
		btnNewButtonTable.setIcon(new ImageIcon(iconTable));
		btnNewButtonTable.setText("Bàn");
		btnNewButtonTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButtonTable.setBounds(177, 127, 160, 106);
		contentPane.add(btnNewButtonTable);

		Image iconOrder = new ImageIcon(this.getClass().getResource("/order_icon.png")).getImage();
		JButton btnOrder = new JButton();
		btnOrder.setIcon(new ImageIcon(iconOrder));
		btnOrder.setText("Order");
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnOrder.setBounds(533, 127, 160, 106);
		contentPane.add(btnOrder);

		JButton btnThngK = new JButton("THỐNG KÊ");
		btnThngK.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThngK.setBounds(177, 282, 160, 106);
		contentPane.add(btnThngK);

		
		Image iconSP = new ImageIcon(this.getClass().getResource("/coffee-sp-icon.png")).getImage();
		JButton btnUng = new JButton();
		btnUng.setIcon(new ImageIcon(iconSP));
		btnUng.setText("Đồ Uống");
		btnUng.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUng.setBounds(533, 282, 160, 106);
		contentPane.add(btnUng);
		

		JLabel lblNewLabel_Name = new JLabel(vl.getName());
		lblNewLabel_Name.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_Name.setBounds(745, 10, 297, 82);
		contentPane.add(lblNewLabel_Name);
		
		tableController controller = new tableController(this);
		mntmNewMenuItem.addActionListener(controller);
		mntmNewMenuItem_1.addActionListener(controller);
		mntmNewMenuItem_2.addActionListener(controller);
		btnNewButtonTable.addActionListener(controller);
		btnUng.addActionListener(controller);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
