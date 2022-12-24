package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class View_Contanner extends JFrame {

	private JPanel contentPane;

	public View_Contanner() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 537);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		Image icon = new ImageIcon(this.getClass().getResource("/coffee-bean-icon.png")).getImage();
		this.setIconImage(icon);

		JMenu mnNewMenu = new JMenu("Tài Khoản");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thêm tài khoản");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_Register();
			}
		});
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_ChangePassword();
			}
		});

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem3ActionPerformed(e);
			}
		});
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
		btnNewButtonTable.setFocusPainted(false);
		contentPane.add(btnNewButtonTable);
		btnNewButtonTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_Table();
			}
		});

		Image iconOrder = new ImageIcon(this.getClass().getResource("/order_icon.png")).getImage();
		JButton btnOrder = new JButton();
		btnOrder.setIcon(new ImageIcon(iconOrder));
		btnOrder.setText("Order");
		btnOrder.setFocusPainted(false);
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnOrder.setBounds(533, 127, 160, 106);
		contentPane.add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_Order();
			}
		});

		JButton btnThngK = new JButton("THỐNG KÊ");
		btnThngK.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThngK.setBounds(177, 282, 160, 106);
		contentPane.add(btnThngK);
		btnThngK.setFocusPainted(false);
		btnThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_Statiscal();
			}
		});

		Image iconSP = new ImageIcon(this.getClass().getResource("/coffee-sp-icon.png")).getImage();
		JButton btnUng = new JButton();
		btnUng.setIcon(new ImageIcon(iconSP));
		btnUng.setText("Đồ Uống");
		btnUng.setFocusPainted(false);
		btnUng.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUng.setBounds(533, 282, 160, 106);
		btnUng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_Drinks();
			}
		});
		contentPane.add(btnUng);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		View_Login mdn = new View_Login();
		mdn.setVisible(true);
		dispose();
	}

}
