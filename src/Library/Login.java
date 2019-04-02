package Library;

import java.awt.BorderLayout;
//导入边框布局
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
// import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private  static final long seriaVersionUID=1L;
	private JLabel jlUsername;
	private JLabel jlPwd;
	private JTextField txtUsername;//用户名
	private JTextField txtPassword;//密码
	private JButton jbOK;
	private JButton jbCancel;
	//private JPasswordField jpassword = new JPasswordField("");

	
	public JLabel getJlUsername(){
		if(jlUsername==null)
		{
			jlUsername=new JLabel("账号");
			jlUsername.setForeground(Color.BLACK);
			jlUsername.setBounds(118,40,85,30);
		}
		return jlUsername;
			
	}
	
	public JLabel getjlPwd(){
		if(jlPwd==null)
		{
			jlPwd=new JLabel("密码");
			jlPwd.setForeground(Color.BLACK);
			jlPwd.setBounds(118,100,85,30);
		}
		return jlPwd;
	}
	
	public JTextField getTxtUsername(){
		if(txtUsername==null)
		{
			txtUsername=new JTextField(20);
			txtUsername.setBounds(180,40,200,30);
		}
		return txtUsername;
	}
	
	public JTextField getTxtPassword(){
		if(txtPassword==null)
		{
			txtPassword=new JTextField(20);
			txtPassword.setBounds(180,100,200,30);
		}
		return txtPassword;
	}
	
	public JButton jbOK(){
		if(jbOK==null)
		{
			jbOK=new JButton("登录");
			jbOK.setBounds(150,180,90,30);
		}
		return jbOK;
	}
	
	public JButton jbCancel(){
		if(jbCancel==null)
		{
			jbCancel=new JButton("取消");
			jbCancel.setBounds(300,180,90,30);
		}
		return jbCancel;
	}
	public Login(String title)
	{
		super("图书信息管理系统");
		this.setSize(1000, 850);
		Container cantainer=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img=new ImageIcon("C:\\Users\\dd\\Pictures\\Saved Pictures\\Screenshot_20180512_081029.jpg");//这里是背景图片。
		JLabel imgLabel=new JLabel(img);//将背景图放在标签里。
		this.getLayeredPane().add(imgLabel);
		//new Integer(Integer.MIN_VALUE);
		//注意这里是关键，将背景标签添加到 jfram的LayeredPane面板里。
		imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());//设置背景标签的位置。
		cantainer.setLayout(new BorderLayout());
		imgLabel.setLayout(null);
		imgLabel.add(getJlUsername());
		imgLabel.add(getTxtUsername());
		imgLabel.add(getjlPwd());
		imgLabel.add(getTxtPassword());
		

		imgLabel.add(jbOK());
		imgLabel.add(jbCancel());
		cantainer.add(imgLabel,BorderLayout.CENTER);//设置在框架北边
		((JPanel)cantainer).setOpaque(false);//将内容面板设为透明
		this.setSize(img.getIconWidth(),img.getIconHeight());
		myEvent();
		this.setVisible(true);
		this.setResizable(false);//让窗口和图片一样大小
	}
	
	private void myEvent() {
		jbCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Login.this.dispose();
			}
		});	
		
		jbOK.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				Connection conn=null;
				Statement stm=null;
				ResultSet st=null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=ProductManager1","sa","123456");
					stm=conn.createStatement();
					String sql="select *  from  dbo.user1 where id ='"+txtUsername.getText()+"' and paw='"+txtPassword.getText()+"'";
					st=stm.executeQuery(sql);
					if(st.next())
					{
						//if(txtUsername.getText().equals(st.getString("id"))&&txtPassword.getText().equals(st.getString("paw")))
						/*String id="小明";
						String psw="123456";		*/
						/*if(/*txtUsername.getText().equals(id)&&txtPassword.getText().equals(psw))
						{*/
							Login.this.setVisible(false);
							new Book("管理界面");}
							
						else {
							JOptionPane.showMessageDialog(null,"您输入的账号或密码不正确");
							getTxtUsername().setName("");
							getTxtPassword().setText("");
					
						}
					/*}
					else
					{
						JOptionPane.showMessageDialog(null,"用户名不存在，请重新输入！");
						getTxtUsername().setText("");
						getTxtPassword().setText("");
						
					}*/
					}
				catch(ClassNotFoundException e1)
				{
					e1.printStackTrace();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}finally {
					try {
						stm.close();
					}catch(Exception e3) {}
					try {conn.close();}catch(Exception e4) {}
				}
			}
		});
	}
			
	public static void main(String[] args)
	{

		new Login("图书管理登录界面");
	
	}


}		
				
