package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.loginDao;
import model.login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View_Register extends JFrame {
	private JPanel contentPane;
	private JTextField textField_registerLogin;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnAdd;
	private JLabel lblHVTn;
	private JTextField textField_name;
	private JTable table;
	int idSave = -1;
	private JButton btnHome;

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
		setBounds(100, 100, 1118, 577);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Image icon = new ImageIcon(this.getClass().getResource("/login_icon.png")).getImage();
		setIconImage(icon);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tài khoản :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(62, 234, 130, 46);
		contentPane.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Mật khẩu :");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhu.setBounds(62, 290, 130, 46);
		contentPane.add(lblMtKhu);

		JLabel lblNhpLiMt = new JLabel("Xác nhận mất khẩu :");
		lblNhpLiMt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhpLiMt.setBounds(62, 339, 163, 46);
		contentPane.add(lblNhpLiMt);

		textField_registerLogin = new JTextField();
		textField_registerLogin.setBounds(250, 243, 197, 34);
		contentPane.add(textField_registerLogin);
		textField_registerLogin.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(250, 299, 197, 34);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(250, 348, 197, 34);
		contentPane.add(passwordField_1);

		Image iconDeleteTable = new ImageIcon(this.getClass().getResource("/Close-icon.png")).getImage();

		JButton btnNewButton = new JButton(new ImageIcon(iconDeleteTable));
		btnNewButton.setText(" Xóa tài khoản");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});
		btnNewButton.setBounds(191, 436, 206, 63);
		contentPane.add(btnNewButton);

		Image iconAddTable = new ImageIcon(this.getClass().getResource("/add-icon.png")).getImage();
		btnAdd = new JButton(new ImageIcon(iconAddTable));
		btnAdd.setText(" Thêm mới");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(10, 437, 149, 63);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});
		JLabel lblNewLabel_1 = new JLabel("Quản lý tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(164, 84, 197, 46);
		contentPane.add(lblNewLabel_1);

		lblHVTn = new JLabel("Họ Và Tên : ");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVTn.setBounds(62, 178, 130, 46);
		contentPane.add(lblHVTn);

		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(250, 187, 197, 34);
		contentPane.add(textField_name);

		Image iconEditTable = new ImageIcon(this.getClass().getResource("/edit-icon.png")).getImage();
		JButton btnCpNht = new JButton(new ImageIcon(iconEditTable));
		btnCpNht.setText(" Cập nhật");
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCpNht.setBounds(407, 436, 174, 63);
		contentPane.add(btnCpNht);
		btnCpNht.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Tên", "Tài khoản" }));
		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblDisplayMouseClicked(evt);
			}
		});
		scrollPane.setBounds(584, 10, 503, 400);
		contentPane.add(scrollPane);

		Image iconBack = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnHome = new JButton(new ImageIcon(iconBack));
		btnHome.setText(" Quay lại");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome.setBounds(10, 10, 133, 46);

		contentPane.add(btnHome);
		btnHome.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHome(evt);
			}
		});
		LoadTable();
		this.setVisible(true);
	}

	private void removeText() {
		textField_name.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		textField_registerLogin.setText("");
	}

	protected void btnDeleteActionPerformed(ActionEvent evt) {
		if (idSave >= 0) {
			if (loginDao.getInstance().Delete(idSave)) {
				LoadTable();
				idSave = -1;
				textField_name.setText("");
				textField_registerLogin.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công!!");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa tài khoản không thành công!!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Seletet to Delete!!");
		}

	}

	private void tblDisplayMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblDisplayMouseClicked
		int row = table.getSelectedRow();
		List<login> list = loginDao.getInstance().listAccount();
		idSave = list.get(row).getId();
		textField_name.setText(table.getValueAt(row, 1) + "");
		passwordField.setText(list.get(row).getPass());
		passwordField_1.setText("");
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
		// TODO add your handling code here:
		if (idSave >= 0) {
			if (textField_registerLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa nhập tên!");
				return;
			}
			if (passwordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!");
				return;
			}
			if (passwordField_1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa nhập xác nhận mật khẩu!");
				return;
			}
			if (!passwordField.getText().equals(passwordField_1.getText())) {
				JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu chưa chính xác!");
				return;
			}
			if (loginDao.getInstance().Update(idSave, textField_registerLogin.getText(), passwordField.getText())) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!!");
				LoadTable();
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi!!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chọn tài khoản để sửa");
		}
	}

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		// TODO add your handling code here:
		if (textField_name.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên!");
			return;
		}
		if (textField_registerLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tài khoản!");
			return;
		}
		if (passwordField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!");
			return;
		}
		if (passwordField_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập xác nhận mật khẩu!");
			return;
		}
		if (!passwordField.getText().equals(passwordField_1.getText())) {
			JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu chưa chính xác!");
			return;
		}

		if (loginDao.getInstance().Add(textField_name.getText(), textField_registerLogin.getText(),
				passwordField.getText())) {
			JOptionPane.showMessageDialog(null, "Thêm mới thành công!!");
			LoadTable();
			removeText();
		} else {
			JOptionPane.showMessageDialog(null, "Lỗi!!");
		}
	}

	private void LoadTable() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		List<login> list = loginDao.getInstance().listAccount();
		for (int i = 0; i < list.size(); i++) {
			login account = list.get(i);
			Object[] dt = { i + 1, account.getName(), account.getNameuser() };
			tableModel.addRow(dt);
		}

	}

	private void btnHome(java.awt.event.ActionEvent evt) {

		dispose();
	}
}
