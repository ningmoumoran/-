package Library;

import java.awt.BorderLayout;
//����߿򲼾�
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
	private JTextField txtUsername;//�û���
	private JTextField txtPassword;//����
	private JButton jbOK;
	private JButton jbCancel;
	//private JPasswordField jpassword = new JPasswordField("");

	
	public JLabel getJlUsername(){
		if(jlUsername==null)
		{
			jlUsername=new JLabel("�˺�");
			jlUsername.setForeground(Color.BLACK);
			jlUsername.setBounds(118,40,85,30);
		}
		return jlUsername;
			
	}
	
	public JLabel getjlPwd(){
		if(jlPwd==null)
		{
			jlPwd=new JLabel("����");
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
			jbOK=new JButton("��¼");
			jbOK.setBounds(150,180,90,30);
		}
		return jbOK;
	}
	
	public JButton jbCancel(){
		if(jbCancel==null)
		{
			jbCancel=new JButton("ȡ��");
			jbCancel.setBounds(300,180,90,30);
		}
		return jbCancel;
	}
	public Login(String title)
	{
		super("ͼ����Ϣ����ϵͳ");
		this.setSize(1000, 850);
		Container cantainer=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img=new ImageIcon("C:\\Users\\dd\\Pictures\\Saved Pictures\\Screenshot_20180512_081029.jpg");//�����Ǳ���ͼƬ��
		JLabel imgLabel=new JLabel(img);//������ͼ���ڱ�ǩ�
		this.getLayeredPane().add(imgLabel);
		//new Integer(Integer.MIN_VALUE);
		//ע�������ǹؼ�����������ǩ��ӵ� jfram��LayeredPane����
		imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());//���ñ�����ǩ��λ�á�
		cantainer.setLayout(new BorderLayout());
		imgLabel.setLayout(null);
		imgLabel.add(getJlUsername());
		imgLabel.add(getTxtUsername());
		imgLabel.add(getjlPwd());
		imgLabel.add(getTxtPassword());
		

		imgLabel.add(jbOK());
		imgLabel.add(jbCancel());
		cantainer.add(imgLabel,BorderLayout.CENTER);//�����ڿ�ܱ���
		((JPanel)cantainer).setOpaque(false);//�����������Ϊ͸��
		this.setSize(img.getIconWidth(),img.getIconHeight());
		myEvent();
		this.setVisible(true);
		this.setResizable(false);//�ô��ں�ͼƬһ����С
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
						/*String id="С��";
						String psw="123456";		*/
						/*if(/*txtUsername.getText().equals(id)&&txtPassword.getText().equals(psw))
						{*/
							Login.this.setVisible(false);
							new Book("�������");}
							
						else {
							JOptionPane.showMessageDialog(null,"��������˺Ż����벻��ȷ");
							getTxtUsername().setName("");
							getTxtPassword().setText("");
					
						}
					/*}
					else
					{
						JOptionPane.showMessageDialog(null,"�û��������ڣ����������룡");
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

		new Login("ͼ������¼����");
	
	}


}		
				
