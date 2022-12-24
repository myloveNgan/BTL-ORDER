package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.InvoicesDAO;
import Dao.drinkDao;
import Dao.loginDao;
import Dao.menuDao;
import Dao.orderDao;
import Dao.tableDao;
import Database.JDBC;
import model.drinkCode;
import model.menuCode;
import model.tablecode;

import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.Icon;

public class View_Order extends JFrame {

	private JSpinner spnAmount;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JLabel sumMoney;
	int idTable = -1;
	int totalPrice = 0;
	private JComboBox<String> comboBox;
	private JButton btnThanhTon;
	private JButton btnThm;

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
		contentPane.setForeground(new Color(0, 0, 0));
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
		btnNewButton.setBounds(10, 14, 132, 41);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHome(evt);
			}
		});
		contentPane.add(btnNewButton);

		Image iconAdd = new ImageIcon(this.getClass().getResource("/add-icon.png")).getImage();
		btnThm = new JButton(new ImageIcon(iconAdd));
		btnThm.setText("Thêm đồ uống");
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm.setBounds(1008, 126, 185, 74);
		contentPane.add(btnThm);
		btnThm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});

		Image iconTT = new ImageIcon(this.getClass().getResource("/tongtien-icon.png")).getImage();
		btnThanhTon = new JButton(new ImageIcon(iconTT));
		btnThanhTon.setText("Thanh toán");
		btnThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThanhTon.setBounds(1203, 126, 216, 74);
		btnThanhTon.setEnabled(false);
		contentPane.add(btnThanhTon);
		btnThanhTon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPayActionPerformed(evt);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Tổng tiền :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(1085, 296, 83, 21);
		contentPane.add(lblNewLabel_1);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Tên bàn", "Trạng thái", "Ghi chú" }));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 126, 484, 474);
		contentPane.add(scrollPane);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblTablesMouseClicked(evt);
			}
		});
		displayTables();

		comboBox = new JComboBox<String>();
		ArrayList<drinkCode> listDrink = drinkDao.getInstance().listDrink();
		comboBox.addItem(" ---Lựa chọn đồ uống--- ");
		for (drinkCode drinks : listDrink) {
			comboBox.addItem(drinks.getName());
		}
		comboBox.setBounds(508, 109, 171, 46);
		contentPane.add(comboBox);

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn \u0110\u1ED3 U\u1ED1ng", "Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(504, 228, 514, 372);
		contentPane.add(scrollPane_1);

		spnAmount = new JSpinner();
		spnAmount.setBounds(508, 180, 171, 38);
		contentPane.add(spnAmount);

		sumMoney = new JLabel();
		sumMoney.setBounds(1185, 296, 112, 21);
		contentPane.add(sumMoney);

		JLabel lblNewLabel_2 = new JLabel("xin chào : " + loginDao.getInstance().GetAccount().getName());
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(1202, 43, 194, 31);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int invoiceId = InvoicesDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
			InvoicesDAO.getInstance().Update(invoiceId, totalPrice);
			Connection con = JDBC.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update tables set status=0 where ID=?");
			pstmt.setInt(1, idTable);
			pstmt.executeUpdate();
			displayTables();
			displayTableDrinks();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		int invoiceId = InvoicesDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
		String drink = comboBox.getSelectedItem().toString();
		int drinks = drinkDao.getInstance().drinkID(drink);
		if (invoiceId == -1) {
			InvoicesDAO.getInstance().Insert(idTable,loginDao.getInstance().GetAccount().getId());
			orderDao.getInstance().Insert(drinks, InvoicesDAO.getInstance().GetMaxIdInvoice(),
					Integer.parseInt(spnAmount.getValue().toString()));
		} else {
			orderDao.getInstance().Insert(drinks, invoiceId, Integer.parseInt(spnAmount.getValue().toString()));
		}
		Connection con = JDBC.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("update tables set status=1 where ID=?");
			pstmt.setInt(1, idTable);
			pstmt.executeUpdate();
			displayTables();
			displayTableDrinks();
			btnThanhTon.setEnabled(true);
			comboBox.setSelectedIndex(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		spnAmount.setValue(0);
	}

	private void btnHome(java.awt.event.ActionEvent evt) {
		dispose();
	}

	
	private void displayTables() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		ArrayList<tablecode> listTable = tableDao.getInstance().listTable();
		for (int i = 0; i < listTable.size(); i++) {
			tablecode tables = listTable.get(i);
			Object[] dt = { i + 1, tables.getNumberTable(), tables.getNote(), tables.getStatus() };
			tableModel.addRow(dt);
		}
	}

	private void displayTableDrinks() {
		DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		tableModel.setRowCount(0);
		ArrayList<menuCode> listMenu = menuDao.getInstance().GetListMenuByTableId(idTable);
		totalPrice = 0 ;
		for (int i = 0; i < listMenu.size(); i++) {
			menuCode menu = listMenu.get(i);
			Object[] dt = { i + 1, menu.getDrinkName(), menu.getPrice(), menu.getCount(), menu.getTotalPrice() };
			totalPrice += menu.getTotalPrice();
			tableModel.addRow(dt);
		}
		sumMoney.setText(totalPrice + "");
	}

	private void tblTablesMouseClicked(java.awt.event.MouseEvent evt) {
		int row = table.getSelectedRow();
		btnThm.setEnabled(true);
		if ((table.getValueAt(row, 2) + "").equals("Đã đặt")) {
			btnThanhTon.setEnabled(true);
		} else {
			btnThanhTon.setEnabled(false);
		}
		ArrayList<tablecode> listTable = tableDao.getInstance().listTable();
		idTable = listTable.get(row).getTableId();
		DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		tableModel.setRowCount(0);
		ArrayList<menuCode> listMenu = menuDao.getInstance().GetListMenuByTableId(idTable);
		totalPrice = 0 ;
		for (int i = 0; i < listMenu.size(); i++) {
			menuCode menu = listMenu.get(i);
			Object[] dt = { i + 1, menu.getDrinkName(), menu.getPrice(), menu.getCount(), menu.getTotalPrice() };
			totalPrice += menu.getTotalPrice();
			tableModel.addRow(dt);
		}
		sumMoney.setText(totalPrice + "");
	}
}
