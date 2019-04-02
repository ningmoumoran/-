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

	// 定义组件
	private JScrollPane scpDemo;
	
	private JTable tabDemo;
	private JButton btnShow;
	// 构造方法
	public database(){
	// 窗体的相关属性的定义
	super("图书信息");
	this.setSize(450,400);
	this.setLayout(null);
	this.setLocation(100,50);
	// 创建组件
	this.scpDemo = new JScrollPane();
	this.scpDemo.setBounds(10,50,420,270);
	this.btnShow = new JButton("显示数据");
	this.btnShow.setBounds(10,10,420,30);
	// 给按钮注册监听
	this.btnShow.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
	btnShow_ActionPerformed(ae);
	}
	});
	// 将组件加入到窗体中
	add(this.scpDemo);
	add(this.btnShow);
	// 显示窗体
	this.setVisible(true);
	}
	// 点击按钮时的事件处理
	public void btnShow_ActionPerformed(ActionEvent ae){
	// 以下是连接数据源和显示数据的具体处理方法，请注意下
	try{
	// 获得连接
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=ProductManager1","sa","123456");
	// 建立查询条件
	String sql = "select * from book_info";
	PreparedStatement pstm = conn.prepareStatement(sql);
	// 执行查询
	ResultSet rs = pstm.executeQuery();
	// 计算有多少条记录
	int count = 0;
	while(rs.next()){
	count++;
	}
	rs = pstm.executeQuery();
	// 将查询获得的记录数据，转换成适合生成JTable的数据形式
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
	// 定义表头
	String[] title = {"书号","书名","作者","现存量","库存量","出版社"};
	// 创建JTable
	this.tabDemo = new JTable(info,title);
	this.tabDemo.getTableHeader();
	// 将JTable加入到带滚动条的面板中
	this.scpDemo.getViewport().add(tabDemo);
	}catch(ClassNotFoundException cnfe){
	JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
	}catch(SQLException sqle){
	JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
	}
	}
}