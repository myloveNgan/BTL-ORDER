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
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Dao.drinkDao;
import Database.JDBC;
import model.drinkCode;


public class View_Drinks extends JFrame {
	int idSave = -1;
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
		setBounds(100, 100, 1213, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image icon = new ImageIcon(this.getClass().getResource("/drink-icon.png")).getImage();
		setIconImage(icon);
		Image iconBackHome = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();

		Image iconDrink = new ImageIcon(this.getClass().getResource("/Coffee-icon.png")).getImage();
		JLabel lblNewLabel = new JLabel(new ImageIcon(iconDrink));
		lblNewLabel.setText("Quản Lý Đồ Uống");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(141, 93, 260, 51);
		contentPane.add(lblNewLabel);

		Image iconAddDrink = new ImageIcon(this.getClass().getResource("/add-icon.png")).getImage();
		JButton btn_addDrink = new JButton(new ImageIcon(iconAddDrink));
		btn_addDrink.setText("Thêm đồ uống");
		btn_addDrink.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_addDrink.setBounds(10, 485, 192, 67);
		contentPane.add(btn_addDrink);
		btn_addDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddDrink(e);
			}
		});

		Image iconDeleteDrink = new ImageIcon(this.getClass().getResource("/Close-icon.png")).getImage();
		JButton btn_deleteDrink = new JButton(new ImageIcon(iconDeleteDrink));
		btn_deleteDrink.setText("Xóa đồ uống");
		btn_deleteDrink.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_deleteDrink.setBounds(212, 485, 186, 67);
		contentPane.add(btn_deleteDrink);
		btn_deleteDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteDrink(e);
			}
		});

		Image iconEditDrink = new ImageIcon(this.getClass().getResource("/edit-icon.png")).getImage();

		JButton btn_updateDrink = new JButton(new ImageIcon(iconEditDrink));
		btn_updateDrink.setText("Sửa đồ uống");
		btn_updateDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate(e);
			}
		});
		btn_updateDrink.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_updateDrink.setBounds(413, 485, 189, 67);
		contentPane.add(btn_updateDrink);

		JLabel lblNewLabel_1 = new JLabel("Tên đồ uống : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(114, 174, 142, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Giá tiền :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(114, 242, 142, 31);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Ngày khuyến mãi :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(114, 312, 142, 31);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Ngày hết khuyến mãi :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(114, 379, 170, 31);
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn \u0111\u1ED3 u\u1ED1ng", "Gi\u00E1", "Ng\u00E0y khuy\u1EBFn m\u00E3i", "Ng\u00E0y h\u1EBFt h\u1EA1n khuy\u1EBFn m\u00E3i "
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(616, 54, 583, 405);
		contentPane.add(scrollPane);

		Image iconBack = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		JButton btnNewButton = new JButton(new ImageIcon(iconBack));
		btnNewButton.setText("Quay lại");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 10, 142, 45);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHome(e);
			}
		});
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				MouseClicked(evt);
			}
		});
		ListDrinks();
		
		this.setVisible(true);
	}

	private void btnAddDrink(java.awt.event.ActionEvent evt) {
		Connection con;
		Statement stmt;

		con = JDBC.getConnection();
		try {
			
			
			stmt = con.createStatement();
			
			int i = stmt.executeUpdate("INSERT INTO drinks(name, price, start_date,end_date) VALUES ('"
					+ textField_nameDrink.getText() + "'," + Float.valueOf(textField_money.getText()) + ",'"
					+ textField_date.getText() + "','" + textField_phantram.getText() + "')");
			if (i > 0) {
				ListDrinks();
				JOptionPane.showMessageDialog(null, "Insert Succesful!!");
			} else {
				JOptionPane.showMessageDialog(null, "Insert fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ListDrinks() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		ArrayList<drinkCode> listDrinks = drinkDao.getInstance().listDrink();
		for (int i = 0; i < listDrinks.size(); i++) {
			drinkCode dC = listDrinks.get(i);
			Object[] dt = { i + 1, dC.getName(), dC.getPrice(), dC.getStartDate(), dC.getEndDate() };
			tableModel.addRow(dt);
		}
	}
	
	private void removeText() {
		textField_nameDrink.setText("");
        textField_money.setText("");
        textField_date.setText("");
        textField_phantram.setText("");
	}
	
	private void btnDeleteDrink(java.awt.event.ActionEvent evt) {
        Connection con;
        PreparedStatement pstmt;

        if (idSave >= 0) {
            con = JDBC.getConnection();
            try {
                pstmt = con.prepareStatement("Delete from drinks where id=?");
                pstmt.setInt(1, idSave);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                	ListDrinks();
                    idSave = -1;
                    removeText();
                    JOptionPane.showMessageDialog(null, "Delete Succesful!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Delete fail!!");
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seletet to Delete!!");
        }
    }
	
	 private void btnUpdate(java.awt.event.ActionEvent evt) {
	        if (idSave >= 0) {
	            Connection con = JDBC.getConnection();
	            try {
	                PreparedStatement pstmt = con.prepareStatement("update drinks set name=?, price=?, start_date=?, end_date=? where id=?");
	                pstmt.setString(1, textField_nameDrink.getText());
	                pstmt.setString(2, textField_money.getText());
	                pstmt.setString(3, textField_date.getText());
	                pstmt.setString(4,textField_phantram.getText());
	                pstmt.setInt(5, idSave);
	                int i = pstmt.executeUpdate();
	                if (i > 0) {
	                    ListDrinks();
	                    JOptionPane.showMessageDialog(null, "Update Succesful!!");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Update fail!!");
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Seletet ID to update");
	        }
	    }
	
	private void MouseClicked(java.awt.event.MouseEvent evt) {
        int row = table.getSelectedRow();
        ArrayList<drinkCode> list = drinkDao.getInstance().listDrink();
        idSave = list.get(row).getId();
        textField_nameDrink.setText(table.getValueAt(row, 1) + "");
        textField_money.setText(table.getValueAt(row, 2) + "");
        textField_date.setText(table.getValueAt(row, 3) + "");
        textField_phantram.setText(table.getValueAt(row, 4) + "");
    }
	
	protected void btnHome(ActionEvent evt) {
		dispose();
	}

}
