package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.tableController;
import Dao.tableDao;
import model.tablecode;

import javax.swing.ImageIcon;

public class View_Table extends JFrame {

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
		setBounds(100, 100, 1189, 758);
		setTitle("Quản lý bàn");
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image iconBack = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		JButton btn_back = new JButton(new ImageIcon(iconBack));
		btn_back.setText("Quay lại");
		btn_back.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_back.setForeground(new Color(0, 0, 0));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_back.setBounds(10, 71, 186, 49);
		contentPane.add(btn_back);

		Image iconAddTable = new ImageIcon(this.getClass().getResource("/add-icon.png")).getImage();
		JButton btn_addTable = new JButton(new ImageIcon(iconAddTable));
		btn_addTable.setForeground(Color.BLACK);
		btn_addTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_addTable.setBounds(20, 617, 176, 61);
		contentPane.add(btn_addTable);

		Image iconDeleteTable = new ImageIcon(this.getClass().getResource("/Close-icon.png")).getImage();
		JButton btn_removeTable = new JButton(new ImageIcon(iconDeleteTable));
		btn_removeTable.setText("Xóa Bàn");
		btn_addTable.setText("Thêm Bàn");
		btn_removeTable.setForeground(Color.BLACK);
		btn_removeTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_removeTable.setBounds(223, 617, 168, 61);
		contentPane.add(btn_removeTable);

		Image iconEditTable = new ImageIcon(this.getClass().getResource("/edit-icon.png")).getImage();
		JButton btn_editTable = new JButton(new ImageIcon(iconEditTable));
		btn_editTable.setText("Sửa Bàn");
		btn_editTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_editTable.setForeground(Color.BLACK);
		btn_editTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_editTable.setBounds(419, 617, 168, 61);
		contentPane.add(btn_editTable);

		JLabel lblNewLabel1 = new JLabel("Số bàn :");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel1.setBounds(157, 236, 94, 42);
		contentPane.add(lblNewLabel1);

		JLabel lblGhiCh = new JLabel("Ghi chú :");
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGhiCh.setBounds(151, 343, 138, 42);
		contentPane.add(lblGhiCh);

		textField_soBan = new JTextField();
		textField_soBan.setBounds(273, 237, 183, 49);
		contentPane.add(textField_soBan);
		textField_soBan.setColumns(10);

		textField_ghiChu = new JTextField();
		textField_ghiChu.setColumns(10);
		textField_ghiChu.setBounds(273, 344, 183, 49);
		contentPane.add(textField_ghiChu);

		JLabel lblQunLBn = new JLabel("Quản Lý Bàn");
		lblQunLBn.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQunLBn.setBounds(273, 133, 183, 42);
		contentPane.add(lblQunLBn);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "S\u1ED1 b\u00E0n", "Tr\u1EA1ng th\u00E1i", "Ghi ch\u00FA" }));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(597, 86, 568, 631);
		contentPane.add(scrollPane);

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				optionTable(evt);
			}
		});

		// this.optionTable();

		this.addListTableRow();
		tableController controller = new tableController(this);
		btn_addTable.addActionListener(controller);
		btn_removeTable.addActionListener(controller);
		btn_editTable.addActionListener(controller);
		btn_back.addActionListener(controller);

		this.setVisible(true);
	}

	public void removeText() {
		this.textField_soBan.setText("");
		this.textField_ghiChu.setText("");
	}

	public void addTable() {
		int numberTable = Integer.valueOf(this.textField_soBan.getText());
		String note = this.textField_ghiChu.getText();
		String status = "Còn trống";
		tablecode tc = new tablecode(numberTable, status, note);
		tableDao.getInstance().addTable(tc);
		this.addTableRow(tc);
		this.removeText();
	}

	public void addTableRow(tablecode tc) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int i = table.getModel().getRowCount() + 1;
		tableModel.addRow(new Object[] { i, tc.getnumberTable(), (tc.getStatus()), tc.getNote(), });
	}

	public void addListTableRow() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		ArrayList<tablecode> listTable = tableDao.getInstance().listTable();
		for (tablecode tc : listTable) {
			int i = table.getModel().getRowCount() + 1;
			tableModel.addRow(new Object[] { i, tc.getnumberTable(), (tc.getStatus()), tc.getNote(), });
		}
	}

	public void removeTable() {
		DefaultTableModel rm = (DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		int soBan = Integer.valueOf(rm.getValueAt(i, 1) + "");
		String status = rm.getValueAt(i, 2) + "";
		String note = rm.getValueAt(i, 3) + "";
		tablecode tc = new tablecode(soBan, status, note);
		tableDao.getInstance().deleteTable(tc);
		rm.removeRow(i);
		this.removeText();
	}

	public void updateTable() {
		DefaultTableModel rm = (DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		int numberTable = Integer.valueOf(rm.getValueAt(i, 1) + "");
		tablecode id = new tablecode(numberTable);
		rm.removeRow(i);
		int numberTableNew = Integer.valueOf(this.textField_soBan.getText());
		String noteNew = this.textField_ghiChu.getText();
		String statusNew = "Còn trống";
		tablecode tc = new tablecode(numberTableNew, statusNew, noteNew);
		tableDao.getInstance().update(tc, id);
		this.addTableRow(tc);
		this.removeText();

	}

	public void optionTable(MouseEvent evt) {
		DefaultTableModel rm = (DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		int numberTable = Integer.valueOf(rm.getValueAt(i, 1) + "");
		String note = rm.getValueAt(i, 3) + "";
		this.textField_soBan.setText(numberTable + "");
		this.textField_ghiChu.setText(note);
	}
}
