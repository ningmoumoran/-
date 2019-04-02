package Library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.table.JTableHeader;

public class database extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// �������
	private JScrollPane scpDemo;
	
	private JTable tabDemo;
	private JButton btnShow;
	// ���췽��
	public database(){
	// �����������ԵĶ���
	super("ͼ����Ϣ");
	this.setSize(450,400);
	this.setLayout(null);
	this.setLocation(100,50);
	// �������
	this.scpDemo = new JScrollPane();
	this.scpDemo.setBounds(10,50,420,270);
	this.btnShow = new JButton("��ʾ����");
	this.btnShow.setBounds(10,10,420,30);
	// ����ťע�����
	this.btnShow.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
	btnShow_ActionPerformed(ae);
	}
	});
	// ��������뵽������
	add(this.scpDemo);
	add(this.btnShow);
	// ��ʾ����
	this.setVisible(true);
	}
	// �����ťʱ���¼�����
	public void btnShow_ActionPerformed(ActionEvent ae){
	// ��������������Դ����ʾ���ݵľ��崦��������ע����
	try{
	// �������
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=ProductManager1","sa","123456");
	// ������ѯ����
	String sql = "select * from book_info";
	PreparedStatement pstm = conn.prepareStatement(sql);
	// ִ�в�ѯ
	ResultSet rs = pstm.executeQuery();
	// �����ж�������¼
	int count = 0;
	while(rs.next()){
	count++;
	}
	rs = pstm.executeQuery();
	// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
	Object[][] info = new Object[count][6];
	count = 0;
	while(rs.next()){
	//info[count][0] = Integer.valueOf( rs.getInt("id"));
	info[count][0] = rs.getString("Bid");
	info[count][1] = rs.getString("Bname");
	info[count][2] = rs.getString("Wname");
	//info[count][2] = Integer.valueOf( rs.getInt("age") );
	info[count][3] = rs.getString("num1");
	info[count][4] = rs.getString("num2");
	info[count][5] = rs.getString("chubs");
	count++;
	}
	// �����ͷ
	String[] title = {"���","����","����","�ִ���","�����","������"};
	// ����JTable
	this.tabDemo = new JTable(info,title);
	this.tabDemo.getTableHeader();
	// ��JTable���뵽���������������
	this.scpDemo.getViewport().add(tabDemo);
	}catch(ClassNotFoundException cnfe){
	JOptionPane.showMessageDialog(null,"����Դ����","����",JOptionPane.ERROR_MESSAGE);
	}catch(SQLException sqle){
	JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
	}
}