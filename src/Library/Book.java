package Library;

import java.awt.BorderLayout;//导入边框布局
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
	//private static final long seriaLVersionUID=1L;//定义了一个名为serialVersionUID的私有长整形常量：其值为1。
	private JLabel lblId;
	private JLabel lblBname;
	private JLabel lblWname;
	private JLabel lblCbs;
	private JLabel lblnum1;
	private JLabel lblnum2;
	private JTextField bid;//图书编号
	private JTextField bname;//书名
	private JTextField wname;//作者名
	private JTextField cbs;//出版社
	private JTextField num1;//现存量
	private JTextField num2;//库存量
	private JButton jrefresh;
	private JButton jrereturn;
	private JButton jbDel;
	private JTextField jDel;
	private JButton jbAdd;
	private JButton jbSearch;
	private JButton jbUpdate;
	private JTable table;//数据库表
	private JLabel jabel;//输入要查找的书号
	//private JScrollPane scpDemo;
	//private Object btnShow;
	
	//private Object jth;/*屏蔽java编译中的一些警告信息。
	/*unused这个参数是屏蔽：定义的变量在代码中并未使用且无法访问。
	java在编译的时候会出现这样的警告，加上这个注解之后就是告诉编译器，
	忽略这些警告，编译的过程中将不会出现这种类型的警告*/
	public JButton getreturn() {
		if(jrereturn==null)
		{
			jrereturn=new JButton("返回");
			jrereturn.setBounds(280, 500, 60, 30);
		}
		return jrereturn;
		}	
	
public JButton getJrefresh() {
if(jrefresh==null)
{
jrefresh=new JButton("刷新");
jrefresh.setBounds(200, 500, 60, 30);
}
return jrefresh;
}	
	
public JLabel getJabel() {
if(jabel==null)
{
jabel=new JLabel("查删编号");
jabel.setBounds(150, 350, 50, 30);
}
return jabel;
}

public JButton getJbDel() {
if(jbDel==null)
{
jbDel=new JButton("删除");
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
jbAdd=new JButton("添加");
jbAdd.setBounds(200,400,60,30);
}
return jbAdd;
}

public JButton getJbSearch() {
if(jbSearch==null)
{
jbSearch=new JButton("查找");
jbSearch.setBounds(200, 450, 60, 30);
}
return jbSearch;
}
public JButton getJbUpdate() {
if(jbUpdate==null)
{
jbUpdate=new JButton("修改");
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
lblId=new JLabel("编号");
lblId.setBounds(150, 50, 50, 30);
}
return lblId;
}
public JLabel getLblBname() {
if(lblBname==null)
{
lblBname=new JLabel("书名");
lblBname.setBounds(150, 100, 50, 30);
}
return lblBname;
}
public JLabel getLblWname() {
if(lblWname==null)
{
lblWname=new JLabel("作者");
lblWname.setBounds(150,150,50,30);
}
return lblWname;
}
public JLabel getLblnum1() {
if(lblnum1==null)
{
lblnum1=new JLabel("现存量");
lblnum1.setBounds(150,200,50,30);
}
return lblnum1;
}
public JLabel getLblnum2() {
if(lblnum2==null)
{
lblnum2=new JLabel("库存量");
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
lblCbs=new JLabel("出版社");
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
	super("图书信息管理系统");//JFfame frame=new Jframe();
	
	Container cantainer=this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ImageIcon img=new ImageIcon("C:\\Users\\dd\\Pictures\\Saved Pictures\\Screenshot_20180517_122212.jpg");//这里是背景图片。
	JLabel imgLabel=new JLabel(img);//将背景图放在标签里。
	this.getLayeredPane().add(imgLabel);
	//new Integer(Integer.MIN_VALUE);
	//注意这里是关键，将背景标签添加到 jframe的LayeredPane面板里。
	imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());//设置背景标签的位置。
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
((JPanel)cantainer).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
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
JOptionPane.showMessageDialog(null,"添加成功!");
}catch(ClassNotFoundException e)
{
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}finally { // 关闭Statement
try { stm.close();
} catch (Exception e) {}
// 关闭Connection
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
}finally { // 关闭Statement
try { stm.close();
} catch (Exception e) {}
// 关闭Connection
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
}finally { // 关闭Statement
try { stm.close();
} catch (Exception e) {}
// 关闭Connection
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
}finally { // 关闭Statement
try { stm.close();
} catch (Exception e) {}
// 关闭Connection
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
		new Login("登录界面");
	}
	finally {
		
	}

}
});


}
}







			
			