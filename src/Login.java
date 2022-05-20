import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	    JTextField t1;
	    JPasswordField t2;
	    JButton b1,b2;
	    
	    Login(){
	        super("Login Page");
	        setLayout(new BorderLayout());
	        t2 = new JPasswordField(15);
	        t1 = new JTextField(15);
	        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));
	        
	        b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
	        b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
	        
	        b1.addActionListener(this);
	        b2.addActionListener(this);

	        JPanel p1,p2,p3,p4;
	        p1=new JPanel();
	        p2=new JPanel();
	     
	        add(l,BorderLayout.WEST);


	        p1.add(new JLabel("UserName  "));
	        p1.add(t1);
	        p1.add(new JLabel("Password "));
	        p1.add(t2);
	        add(p1,BorderLayout.CENTER);
	       
	        
	        p2.add(b1);
	        p2.add(b2);

	        add(p2 ,BorderLayout.SOUTH);

	      
	        setSize(400,250);
	        setLocation(600,400);	
	        setVisible(true);

	    }
	    public void actionPerformed(ActionEvent ae){
	        try
	        {
	            Conn c1=new Conn();
	            String u=t1.getText();
	            String v=t2.getUIClassID();
	            
	            String q="select * from login where username='"+u+"' and password='"+v+"'";
	            
	            ResultSet rs=c1.s.executeQuery(q); // query execute
	            if(rs.next()){
	                new MainMenu().setVisible(true);
	                setVisible(false);
	            }else{
	                JOptionPane.showMessageDialog(null, "Invalid login");
	                setVisible(false);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
	    
	    public static void main(String[] args){
	        new Login();
	    }
}
