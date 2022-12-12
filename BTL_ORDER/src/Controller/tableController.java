package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.View_Contanner;
import View.View_Drinks;
import View.View_Login;
import View.View_Order;
import View.View_Register;
import View.View_Table;

public class tableController implements ActionListener {
	private View_Table vT;
	private View_Login vL;
	private View_Register vR;
	private View_Contanner vC;
	private View_Drinks vD;
	private View_Order vO;

	public tableController(View_Order vO) {
		this.vO = vO;
	}

	public tableController(View_Drinks vD) {
		this.vD = vD;
	}

	public tableController(View_Login vL) {
		this.vL = vL;
	}

	public tableController(View_Register vR) {
		this.vR = vR;
	}

	public tableController(View_Table vT) {
		this.vT = vT;
	}

	public tableController(View_Contanner vC) {
		this.vC = vC;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JOptionPane.showMessageDialog(vT, "bạn vừa nhấn : " + src);
		if (src.equals("Thêm Bàn")) {
			this.vT.addTable();
		} else if (src.equals("Xóa Bàn")) {
			int luaChon = JOptionPane.showConfirmDialog(vT, "bạn có chắc chắn xóa bàn ");
			if (luaChon == JOptionPane.YES_OPTION) {
				this.vT.removeTable();
			}

		} else if (src.equals("Sửa Bàn")) {
			this.vT.updateTable();
		} else if (src.equals("Đăng Nhập")) {
			if (vL.testLogin()) {
				new View_Contanner(vL);
				vL.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(vT, "Mật khẩu hoặc tên đăng nhập của bạn không đúng");
			}
		} else if (src.equals("Quay lại")) {
			new View_Contanner(vL);
		} else if (src.equals("Thêm tài khoản")) {
			new View_Register();
		} else if (src.equals("Login")) {
			new View_Login();
		} else if (src.equals("Oke")) {
			if (vR.register()) {
				JOptionPane.showMessageDialog(vR, "Bạn đăng kí thành công");
			} else {
				JOptionPane.showMessageDialog(vR, "bạn hãy điền lại pass");
			}
		} else if (src.equals("Bàn")) {
			new View_Table();
		} else if (src.equals("Đồ Uống")) {
			new View_Drinks();
		} else if (src.equals("Thêm đồ uống")) {
			vD.addDrink();
		} else if (src.equals("Xóa đồ uống")) {
			vD.deleteDrink();
		}

	}

}
