package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.tableController;
import Dao.drinkDao;
import model.drinkCode;


public class View_Drinks extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nameDrink;
	private JTextField textField_money;
	private JTextField textField_date;
	private JTextField textField_phantram;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Drinks frame = new View_Drinks();
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
	public View_Drinks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image iconBackHome = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		JButton btnNewButton_back = new JButton(new ImageIcon(iconBackHome));
		btnNewButton_back.setText("Quay Lại");
		btnNewButton_back.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_back.setBounds(21, 27, 164, 46);
		contentPane.add(btnNewButton_back);
		
		Image iconDrink = new ImageIcon(this.getClass().getResource("/Coffee-icon.png")).getImage();
		JLabel lblNewLabel = new JLabel(new ImageIcon(iconDrink));
		lblNewLabel.setText("Quản Lý Đồ Uống");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(268, 53, 260, 51);
		contentPane.add(lblNewLabel);
		
		Image iconAddDrink = new ImageIcon(this.getClass().getResource("/add-icon.png")).getImage();
		JButton btn_addDrink = new JButton(new ImageIcon(iconAddDrink));
		btn_addDrink.setText("Thêm đồ uống");
		btn_addDrink.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_addDrink.setBounds(10, 581, 202, 67);
		contentPane.add(btn_addDrink);
		
		Image iconDeleteDrink = new ImageIcon(this.getClass().getResource("/Close-icon.png")).getImage();
		JButton btn_deleteDrink = new JButton(new ImageIcon(iconDeleteDrink));
		btn_deleteDrink.setText("Xóa đồ uống");
		btn_deleteDrink.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_deleteDrink.setBounds(236, 581, 186, 67);
		contentPane.add(btn_deleteDrink);
		
		Image iconEditDrink = new ImageIcon(this.getClass().getResource("/edit-icon.png")).getImage();
		
		JButton btn_updateDrink = new JButton(new ImageIcon(iconEditDrink));
		btn_updateDrink.setText("Sửa đồ uống");
		btn_updateDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_updateDrink.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_updateDrink.setBounds(448, 581, 189, 67);
		contentPane.add(btn_updateDrink);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đồ uống : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(124, 174, 142, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá tiền :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(124, 243, 142, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày khuyến mãi :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(124, 313, 142, 31);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Khuyến mãi % : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(124, 385, 142, 31);
		contentPane.add(lblNewLabel_1_3);
		
		textField_nameDrink = new JTextField();
		textField_nameDrink.setBounds(294, 175, 220, 36);
		contentPane.add(textField_nameDrink);
		textField_nameDrink.setColumns(10);
		
		textField_money = new JTextField();
		textField_money.setColumns(10);
		textField_money.setBounds(294, 243, 220, 36);
		contentPane.add(textField_money);
		
		textField_date = new JTextField();
		textField_date.setColumns(10);
		textField_date.setBounds(294, 313, 220, 36);
		contentPane.add(textField_date);
		
		textField_phantram = new JTextField();
		textField_phantram.setColumns(10);
		textField_phantram.setBounds(294, 380, 220, 36);
		contentPane.add(textField_phantram);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Tên đồ uống", "Giá", "Ngày khuyến mãi" , "giảm % " }));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(644, 54, 555, 631);
		contentPane.add(scrollPane);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				optionDrink(evt);
			}
		});
		this.list();
		tableController controller = new tableController(this);
		btn_addDrink.addActionListener(controller);
		btn_deleteDrink.addActionListener(controller);
		btn_updateDrink.addActionListener(controller);
		btnNewButton_back.addActionListener(controller);
		this.setVisible(true);
	}
	
	protected void optionDrink(MouseEvent evt) {
		DefaultTableModel rm = (DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		String nameDrink = rm.getValueAt(i, 1)+"";
		Float moneyDrink = Float.valueOf(rm.getValueAt(i, 2)+"");
		String date = rm.getValueAt(i, 3)+"";
		Float sale = Float.valueOf(rm.getValueAt(i, 4)+"");
		
		this.textField_nameDrink.setText(nameDrink+"");
		this.textField_money.setText(moneyDrink+"");
		this.textField_date.setText(date);
		this.textField_phantram.setText(sale+"");
		
	}

	public drinkCode addtextFied() {
		 String nameDrink = this.textField_nameDrink.getText();
         float moneyDrink = Float.valueOf(this.textField_money.getText());
         @SuppressWarnings("deprecation")
         Date saleDate = new Date(this.textField_date.getText());
         float sale = Float.valueOf(this.textField_phantram.getText()); 
         drinkCode dC = new drinkCode(nameDrink, moneyDrink, saleDate, sale);
         return dC;
	}
	
	public void addDrink() {
        drinkCode dC = this.addtextFied();
        DefaultTableModel rm = (DefaultTableModel) table.getModel();
        int i = table.getModel().getRowCount() +1;
        rm.addRow(new Object[] { 
				i, 
				dC.getNameDrink(), 
				dC.getMoneyDrink(),
				dC.getSaleDate(), 
				dC.getSale(),
				});
		drinkDao.getInstance().addDrink(dC);
	}
	
	public void list() {
		DefaultTableModel rm = (DefaultTableModel) table.getModel();
		ArrayList<drinkCode> listDrink = drinkDao.getInstance().listDrink();
	//	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (drinkCode drinkCode : listDrink) {
			int i = table.getModel().getRowCount() +1;
        	rm.addRow(new Object[] { 
    				i, 
    				drinkCode.getNameDrink(), 
    				drinkCode.getMoneyDrink(),
    				drinkCode.getSaleDate(), 
    				drinkCode.getSale(),
    				});
		}	
	}

	public void deleteDrink() {
		DefaultTableModel rm = (DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		String nameDrink = rm.getValueAt(i, 1)+"";
		drinkCode dC = new drinkCode(nameDrink);
		drinkDao.getInstance().deleteDrink(dC);
		rm.removeRow(i);
	}
	
	public void updateDrink() {
		
	}
	
	
}
