package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.loginDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class View_ChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passcu;
	private JPasswordField passnew;
	private JPasswordField passnew2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_ChangePassword frame = new View_ChangePassword();
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
	public View_ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(214, 63, 165, 42);
		contentPane.add(lblNewLabel);
		
		Image iconBack = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		JButton btnHome = new JButton(new ImageIcon(iconBack));
		btnHome.setText("Quay lại");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHome.setBounds(10, 10, 133, 42);
		contentPane.add(btnHome);
		btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Nhập mật khẩu cũ :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(158, 131, 142, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập mật khẩu mới :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(158, 179, 163, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Xác nhận mật khẩu :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(158, 225, 142, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnSave = new JButton("Xác Nhận");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSave.setBounds(225, 270, 154, 42);
		contentPane.add(btnSave);
		
		passcu = new JPasswordField();
		passcu.setBounds(310, 131, 154, 23);
		contentPane.add(passcu);
		
		passnew = new JPasswordField();
		passnew.setBounds(310, 179, 154, 24);
		contentPane.add(passnew);
		
		passnew2 = new JPasswordField();
		passnew2.setBounds(310, 225, 154, 24);
		contentPane.add(passnew2);
		btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	protected void btnHomeActionPerformed(ActionEvent evt) {
		  dispose();	
	}
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (passcu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu cũ");
            return;
        }
        if (passnew.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!");
            return;
        }
        if (passnew2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập xác nhận mật khẩu!");
            return;
        }
        if (!passcu.getText().equals(loginDao.getInstance().GetAccount().getPass())) {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ chưa chính xác!");
            return;
        }
        if (!passnew.getText().equals(passnew2.getText())) {
            JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu mới chưa chính xác!");
            return;
        }
        if (loginDao.getInstance().DoiMatKhau(loginDao.getInstance().GetAccount().getId(), passnew.getText())) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!!");
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi!!");
        }
    }
}
