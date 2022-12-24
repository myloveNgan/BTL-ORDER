package View;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Dao.loginDao;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class View_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtDfds;
	private JPasswordField passwordField;
	private JLabel mess;

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
		lblNewLabel.setText(" Đăng Nhập :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(79, 75, 190, 31);
		contentPane.add(lblNewLabel);

		Image icon_pass = new ImageIcon(this.getClass().getResource("/pass_icon.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(icon_pass));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setText(" Mật Khẩu :");
		lblNewLabel_1.setBounds(79, 146, 171, 51);
		contentPane.add(lblNewLabel_1);

		txtDfds = new JTextField();
		txtDfds.setToolTipText("");
		txtDfds.setBounds(260, 79, 190, 31);
		contentPane.add(txtDfds);
		txtDfds.setColumns(10);
		txtDfds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });
		
		JButton btn_login = new JButton("Đăng Nhập");
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_login.setIcon(null);
		btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
		btn_login.setBounds(160, 255, 160, 42);
		contentPane.add(btn_login);

		passwordField = new JPasswordField();
		passwordField.setBounds(260, 160, 190, 31);
		contentPane.add(passwordField);
		
	    mess = new JLabel("");
		mess.setForeground(new Color(255, 0, 0));
		mess.setFont(new Font("Tahoma", Font.ITALIC, 15));
		mess.setBounds(132, 207, 247, 38);
		contentPane.add(mess);
		this.setVisible(true);

	}

	protected void txtUsernameKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AuthenticateAndLogin();
        }
	}


	protected void btnLoginActionPerformed(ActionEvent evt) {
		 AuthenticateAndLogin();
		
	}

	private void AuthenticateAndLogin() {
        if (txtDfds.getText().isEmpty()) {
            mess.setText("Bạn chưa nhập tên tài khoản!");
            return;
        }
        if (passwordField.getText().isEmpty()) {
        	mess.setText("Bạn chưa nhập mật khẩu!");
            return;
        }

        if (loginDao.getInstance().Login(txtDfds.getText(), passwordField.getText())) {
        	View_Contanner vC = new View_Contanner();
            vC.setVisible(true);
        }else {
        	mess.setText("Sai tên đăng nhập hoặc mật khẩu!!");
        }
    }
}
