package Library;

import java.awt.BorderLayout;//����߿򲼾�
//import java.awt.Color;
//import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.table.TableCellRenderer;



public class Book extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long seriaLVersionUID=1L;//������һ����ΪserialVersionUID��˽�г����γ�������ֵΪ1��
	private JLabel lblId;
	private JLabel lblBname;
	private JLabel lblWname;
	private JLabel lblCbs;
	private JLabel lblnum1;
	private JLabel lblnum2;
	private JTextField bid;//ͼ����
	private JTextField bname;//����
	private JTextField wname;//������
	private JTextField cbs;//������
	private JTextField num1;//�ִ���
	private JTextField num2;//�����
	private JButton jrefresh;
	private JButton jrereturn;
	private JButton jbDel;
	private JTextField jDel;
	private JButton jbAdd;
	private JButton jbSearch;
	private JButton jbUpdate;
	private JTable table;//���ݿ��
	private JLabel jabel;//����Ҫ���ҵ����
	//private JScrollPane scpDemo;
	//private Object btnShow;
	
	//private Object jth;/*����java�����е�һЩ������Ϣ��
	/*unused������������Σ�����ı����ڴ����в�δʹ�����޷����ʡ�
	java�ڱ����ʱ�����������ľ��棬�������ע��֮����Ǹ��߱�������
	������Щ���棬����Ĺ����н���������������͵ľ���*/
	public JButton getreturn() {
		if(jrereturn==null)
		{
			jrereturn=new JButton("����");
			jrereturn.setBounds(280, 500, 60, 30);
		}
		return jrereturn;
		}	
	
public JButton getJrefresh() {
if(jrefresh==null)
{
jrefresh=new JButton("ˢ��");
jrefresh.setBounds(200, 500, 60, 30);
}
return jrefresh;
}	
	
public JLabel getJabel() {
if(jabel==null)
{
jabel=new JLabel("��ɾ���");
jabel.setBounds(150, 350, 50, 30);
}
return jabel;
}

public JButton getJbDel() {
if(jbDel==null)
{
jbDel=new JButton("ɾ��");
jbDel.setBounds(280, 400, 60, 30);
}
return jbDel;
}

public JTextField getjDel() {
if(jDel==null)
{
jDel=new JTextField(20);
jDel.setBounds(200, 350, 150, 30);
}
return jDel;
}

public JButton getJbAdd() {
if(jbAdd==null)
{
jbAdd=new JButton("���");
jbAdd.setBounds(200,400,60,30);
}
return jbAdd;
}

public JButton getJbSearch() {
if(jbSearch==null)
{
jbSearch=new JButton("����");
jbSearch.setBounds(200, 450, 60, 30);
}
return jbSearch;
}
public JButton getJbUpdate() {
if(jbUpdate==null)
{
jbUpdate=new JButton("�޸�");
jbUpdate.setBounds(280, 450, 60, 30);
}
return jbUpdate;
}
public JTable getTable() {
if(table==null)
{
table=new JTable(100,6);
table.setBounds(270, 50, 500, 600);
}
return table;
}
public JLabel getLblId() {
if(lblId==null)
{
lblId=new JLabel("���");
lblId.setBounds(150, 50, 50, 30);
}
return lblId;
}
public JLabel getLblBname() {
if(lblBname==null)
{
lblBname=new JLabel("����");
lblBname.setBounds(150, 100, 50, 30);
}
return lblBname;
}
public JLabel getLblWname() {
if(lblWname==null)
{
lblWname=new JLabel("����");
lblWname.setBounds(150,150,50,30);
}
return lblWname;
}
public JLabel getLblnum1() {
if(lblnum1==null)
{
lblnum1=new JLabel("�ִ���");
lblnum1.setBounds(150,200,50,30);
}
return lblnum1;
}
public JLabel getLblnum2() {
if(lblnum2==null)
{
lblnum2=new JLabel("�����");
lblnum2.setBounds(150,250, 50, 30);
}
return lblnum2;
}
public JTextField getbId() {
if(bid==null)
{
bid=new JTextField(20);
bid.setBounds(200, 50,150, 30);
}
return bid;
}
public JTextField getBname() {
if(bname==null)
{
bname=new JTextField(20);
bname.setBounds(200, 100, 150, 30);
}
return bname;
}
public JTextField getWname() {
if(wname==null)
{
wname=new JTextField(20);
wname.setBounds(200, 150, 150, 30);
}
return wname;
}
public JTextField getNum1() {
if(num1==null)
{
num1=new JTextField(20);
num1.setBounds(200, 200, 150, 30);
}
return num1;
}
public JTextField getNum2() {
if(num2==null)
{
num2=new JTextField(20);
num2.setBounds(200, 250, 150, 30);
}
return num2;
}
public JLabel getLblCbs() {
if(lblCbs==null)
{
lblCbs=new JLabel("������");
lblCbs.setBounds(150,300, 50, 30);
}
return lblCbs;
}
public JTextField getCbs() {
if(cbs==null)
{
cbs=new JTextField(20);
cbs.setBounds(200, 300, 150, 30);
}
return cbs;
}
public Book(String title)
{
	super("ͼ����Ϣ����ϵͳ");//JFfame frame=new Jframe();
	
	Container cantainer=this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ImageIcon img=new ImageIcon("C:\\Users\\dd\\Pictures\\Saved Pictures\\Screenshot_20180517_122212.jpg");//�����Ǳ���ͼƬ��
	JLabel imgLabel=new JLabel(img);//������ͼ���ڱ�ǩ�
	this.getLayeredPane().add(imgLabel);
	//new Integer(Integer.MIN_VALUE);
	//ע�������ǹؼ�����������ǩ��ӵ� jframe��LayeredPane����
	imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());//���ñ�����ǩ��λ�á�
	cantainer.setLayout(new BorderLayout());

imgLabel.setLayout(null);
imgLabel.add(getLblId());
imgLabel.add(getbId());
imgLabel.add(getLblBname());
imgLabel.add(getBname());   
imgLabel.add(getLblWname());
imgLabel.add(getWname());
imgLabel.add(getLblnum1());
imgLabel.add(getNum1());
imgLabel.add(getLblnum2());
imgLabel.add(getNum2());
imgLabel.add(getLblCbs());
imgLabel.add(getCbs());

imgLabel.add(getJrefresh());
imgLabel.add(getreturn());

//imgLabel.add(getTable());


imgLabel.add(getJbDel());
imgLabel.add(getjDel());
imgLabel.add(getJbAdd());
imgLabel.add(getJbSearch());
imgLabel.add(getJbUpdate());
imgLabel.add(getJabel());

cantainer.add(imgLabel,BorderLayout.NORTH);
((JPanel)cantainer).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������
this.setSize(img.getIconWidth(),img.getIconHeight());
myEvent();
this.setVisible(true);
this.setResizable(true);
} 
private void myEvent() {
// TODO Auto-generated method stub
jbAdd.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
Connection conn=null;
Statement stm=null;
String id1=bid.getText();
String name1=bname.getText();
String name2=wname.getText();
String n1=num1.getText();
String n2=num2.getText();
String chubs=cbs.getText();
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ProductManager1","sa","123456");
stm=conn.createStatement();
String sql="insert into book_info values('"+id1+"','"+name1+"','"+name2+"','"+n1+"','"+n2+"','"+chubs+"')";
stm.executeUpdate(sql);
getbId().setText("");
getBname().setText("");
getWname().setText("");
getNum1().setText("");
getNum2().setText("");
getCbs().setText("");
JOptionPane.showMessageDialog(null,"��ӳɹ�!");
}catch(ClassNotFoundException e)
{
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}finally { // �ر�Statement
try { stm.close();
} catch (Exception e) {}
// �ر�Connection
try { conn.close();
} catch (Exception e) {}
}
}
});
jbDel.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
String id=jDel.getText();
Connection conn=null;
Statement stm=null;
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ProductManager1","sa","123456");
//String sql="select * from book";
String sql="delete from book_info where Bid='"+id+"'";
stm=conn.createStatement();
stm.executeUpdate(sql);
getjDel().setText("");
}catch(ClassNotFoundException e)
{
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}finally { // �ر�Statement
try { stm.close();
} catch (Exception e) {}
// �ر�Connection
try { conn.close();
} catch (Exception e) {}
}
}
});
jbSearch.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
String id=jDel.getText();
Connection conn=null;
Statement stm=null;
ResultSet rst=null;
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ProductManager1","sa","123456");
//String sql="select * from book";
String sql="select * from book_info where  Bid='"+id+"'";
stm=conn.createStatement();
rst=stm.executeQuery(sql);
if(rst.next())
{
getbId().setText(rst.getString("Bid"));
getBname().setText(rst.getString("Bname"));
getWname().setText(rst.getString("Wname"));
getNum1().setText(rst.getString("num1"));
getNum2().setText(rst.getString("num2"));
getCbs().setText(rst.getString("chubs"));
getjDel().setText("");
}
}catch(ClassNotFoundException e)
{
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}finally { // �ر�Statement
try { stm.close();
} catch (Exception e) {}
// �ر�Connection
try { conn.close();
} catch (Exception e) {}
}
}
});


jbUpdate.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
String id1=bid.getText();
String name1=bname.getText();
String name2=wname.getText();
String n1=num1.getText();
String n2=num2.getText();
String chubs=cbs.getText();
Connection conn=null;
Statement stm=null;
try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ProductManager1","sa","123456");
String sql="update book_info set Bname='"+name1+"',Wname='"+name2+"',num1='"+n1+"',num2='"+n2+"',chubs='"+chubs+"'  where Bid='"+id1+"'";
stm=conn.createStatement();
stm.executeUpdate(sql);
}catch(ClassNotFoundException e)
{
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}finally { // �ر�Statement
try { stm.close();
} catch (Exception e) {}
// �ر�Connection
try { conn.close();
} catch (Exception e) {}
}
}
});

jrefresh.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
	try
	{
		new database();
	}
	finally {
		
	}

}
});
jrereturn.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
	try
	{
		Book.this.setVisible(false);
		new Login("��¼����");
	}
	finally {
		
	}

}
});


}
}







			
			