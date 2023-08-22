package homework0821;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;


public class EmpViewEvt extends MouseAdapter {
	private EmpView ev;
	
	public EmpViewEvt(EmpView ev) {
		this.ev = ev;
		
		setEmpno();
	}
	
	public void setEmpno() {
		EmpDAO eDAO = EmpDAO.getInstance();
		
		try {
			List<String> empno = eDAO.selecEmpno(); 
			for(String setEmpno : empno) {
				ev.getDlmJlEmpno().addElement(setEmpno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource() == ev.getJlEmpno()) {
			selectEmpno();
		}
	}

	
	public void selectEmpno() {
		EmpDAO eDAO = EmpDAO.getInstance();
		String empno = ev.getDlmJlEmpno().elementAt(ev.getJlEmpno().getSelectedIndex());
			
		EmpVO eVO = null;
		new EmpInfoView(ev,eVO);

		try {
				eVO = eDAO.selectOneEmpInfo(empno);
				if(eVO==null) {
					JOptionPane.showMessageDialog(ev, empno+"번 사원은 조재하지 않습니다.");
					return;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
}
