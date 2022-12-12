package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.tableController;
import Dao.loginDao;
import model.login;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Register extends JFrame {
	private JPanel contentPane;
	private JTextField textField_registerLogin;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnNewButton_loginBack;
	private JLabel lblHVTn;
	private JTextField textField_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Register frame = new View_Register();
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
	public View_Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Đăng Nhập :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(130, 119, 130, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu :");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhu.setBounds(130, 194, 130, 46);
		contentPane.add(lblMtKhu);
		
		JLabel lblNhpLiMt = new JLabel("Nhập Lại Mật Khẩu :");
		lblNhpLiMt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhpLiMt.setBounds(130, 247, 163, 46);
		contentPane.add(lblNhpLiMt);
		
		textField_registerLogin = new JTextField();
		textField_registerLogin.setBounds(284, 122, 147, 46);
		contentPane.add(textField_registerLogin);
		textField_registerLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(284, 178, 147, 46);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(284, 250, 147, 46);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Oke");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(407, 329, 108, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton_loginBack = new JButton("Login");
		btnNewButton_loginBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_loginBack.setBounds(46, 332, 133, 31);
		contentPane.add(btnNewButton_loginBack);
		
		JLabel lblNewLabel_1 = new JLabel("ĐĂNG KÍ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(211, 10, 108, 46);
		contentPane.add(lblNewLabel_1);
		
		lblHVTn = new JLabel("Họ Và Tên : ");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVTn.setBounds(130, 63, 130, 46);
		contentPane.add(lblHVTn);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(284, 66, 147, 46);
		contentPane.add(textField_name);
		tableController controller = new tableController(this);
		btnNewButton.addActionListener(controller);
		btnNewButton_loginBack.addActionListener(controller);
		this.setVisible(true);
	}
	
	public boolean register(){
    String name = this.textField_name.getText();
	String useName = this.textField_registerLogin.getText();
	String passWd = new String(this.passwordField.getPassword());
	String backPassWd = new String(this.passwordField_1.getPassword());
	if(passWd.equals(backPassWd)) {
		login lg = new login(useName, passWd, name);
		loginDao.getInstance().addRegiter(lg);
		return true;
	}
	return false;
}
}
