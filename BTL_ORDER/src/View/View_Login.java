package View;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.tableController;
import Dao.loginDao;
import Database.JDBC;
import model.login;

import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class View_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtDfds;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Login frame = new View_Login();
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
	public View_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Đăng Nhập");
		Image icon = new ImageIcon(this.getClass().getResource("/login_icon.png")).getImage();
		this.setIconImage(icon);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image icon_login = new ImageIcon(this.getClass().getResource("/user_icon.png")).getImage();
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(icon_login));
		lblNewLabel.setText("   Đăng Nhập :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 76, 190, 31);
		contentPane.add(lblNewLabel);

		Image icon_pass = new ImageIcon(this.getClass().getResource("/pass_icon.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(icon_pass));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setText("   Mật Khẩu :");
		lblNewLabel_1.setBounds(24, 137, 171, 51);
		contentPane.add(lblNewLabel_1);

		txtDfds = new JTextField();
		txtDfds.setToolTipText("");
		txtDfds.setBounds(279, 64, 163, 42);
		contentPane.add(txtDfds);
		txtDfds.setColumns(10);
		JButton btn_login = new JButton("Đăng Nhập");
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_login.setIcon(null);
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tableController tC = new tableController(this);
		btn_login.addActionListener(tC);
		btn_login.setBounds(188, 255, 160, 42);
		contentPane.add(btn_login);

		passwordField = new JPasswordField();
		passwordField.setBounds(279, 146, 163, 42);
		contentPane.add(passwordField);
		this.setVisible(true);
		
	}

	public boolean testLogin() {
		String nameUser = this.txtDfds.getText();
		String passUser = new String(this.passwordField.getPassword());
		login lg = new login(nameUser, passUser);

		ArrayList<login> listLogin = loginDao.getInstance().selectALL();

		for (login login : listLogin) {
			if ((login.getNameuser().equals(lg.getNameuser())) && (login.getPass().equals(lg.getPass()))) {
				return true;
			}
		}
		return false;
	}	
	public String getName() {
		String nameUser = this.txtDfds.getText();
		String passUser = new String(this.passwordField.getPassword());
		login lg = new login(nameUser, passUser);	
		return loginDao.getInstance().selectById(lg);
	}
	
	/*public String testNameUser() {
		String nameUser = this.txtDfds.getText();
		String passUser = new String(this.passwordField.getPassword());
		login lg = new login(nameUser, passUser);

		ArrayList<login> listLogin = loginDao.getInstance().selectALL();

		for (login login : listLogin) {
			if ((login.getNameuser().equals(lg.getNameuser())) && (login.getPass().equals(lg.getPass()))) {
				return lg.getNameuser();
			}
		}
		return null;
	}*/
}
