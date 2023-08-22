package homework0821;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EmpView extends JFrame {

	private JList<String> jlEmpno;
	private DefaultListModel<String> dlmJlEmpno;
	
	
	public EmpView() {
		
		super("사원번호 조회");
		
		dlmJlEmpno = new DefaultListModel<String>();
		jlEmpno = new JList<String>(dlmJlEmpno);
		JPanel jpNorth = new JPanel();
		
		EmpViewEvt eve = new EmpViewEvt(this);
		jlEmpno.addMouseListener(eve);
		
		jpNorth.add(jlEmpno);
		
		add("North",jpNorth);
		
		setBounds(100,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}


	public JList<String> getJlEmpno() {
		return jlEmpno;
	}


	public DefaultListModel<String> getDlmJlEmpno() {
		return dlmJlEmpno;
	}


	public void setJlEmpno(JList<String> jlEmpno) {
		this.jlEmpno = jlEmpno;
	}


	public void setDlmJlEmpno(DefaultListModel<String> dlmJlEmpno) {
		this.dlmJlEmpno = dlmJlEmpno;
	}
	
	
}
