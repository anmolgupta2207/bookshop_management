import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;

class login implements ActionListener

{
      Container c1;
      JFrame frmlog;
      JPanel panLog;

      JLabel l1,l2,l3;
	  JLabel luserid,luserpass,l;
	  JTextField uid;
	  JPasswordField upass;
	  JButton btnok,btnexit;
      Icon mig;
      Image img;
      Font f1;
	  

      public static void main(String args[])
      {
             login l1=new login();
       }

      login()
      {
            try
            {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception ex)
            {
               System.out.println(ex);
            }

            frmlog = new JFrame("Login");
            panLog = new JPanel();
            panLog.setLayout(null);
            panLog.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            panLog.setBounds(500,200,350,300);
		    f1=new Font("Times New Roman",Font.BOLD,15);
  	    mig=new ImageIcon("pralhad.jpg");
          
            Icon img=new ImageIcon("pralhad.jpg");
            l=new JLabel(img);
            luserid=new JLabel("User ID :");
		    luserid.setFont(f1);
		    luserid.setForeground(Color.black);
	     	luserid.setBounds(100,75,600,30);
		    luserpass= new JLabel("Password :");
		    luserpass.setFont(f1);
		    luserpass.setForeground(Color.black);
		    luserpass.setBounds(100,125,600,20);

            uid=new JTextField();
           uid.setText("ANMOL");
            ///uid.setEditable(false);
            uid.setBounds(200,75,100,20);
            upass=new JPasswordField();
            upass.setBounds(200,125,100,20);

            JLabel lborder=new JLabel(mig);
		    lborder.setBounds(0,10,600,750);

            btnok=new JButton("OK");
            btnok.setMnemonic('O');
            btnok.setBounds(100,225,80,25);
		    btnexit=new JButton("EXIT");
		    btnexit.setMnemonic('X');
		    btnexit.setBounds(225,225,80,25);
            
            panLog.add(luserid);
            panLog.add(uid);
		    panLog.add(luserpass);
            panLog.add(upass);
           // panLog.add(lborder);

            panLog.add(btnok);
            panLog.add(btnexit);
            panLog.add(l); 
            btnok.addActionListener(this);
            btnexit.addActionListener(this);

            c1=frmlog.getContentPane();
            c1.setLayout(null);
            c1.add(panLog,"Center");
            frmlog.add(lborder);

           frmlog.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmlog.setSize(800,900);
            frmlog.setVisible(true);
            frmlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();
              String sPassword = String.valueOf(upass.getPassword());

              if(obj==btnok)
              {
                             if(sPassword.equals("addmin")){
                             frmlog.dispose();
                             newmain1 m1=new newmain1();
                             }
                             else{
                             JOptionPane.showMessageDialog(null,"Login Failed!!!!","Failed",JOptionPane.ERROR_MESSAGE);
                             }
               }
              if(obj==btnexit)
              {
                              System.exit(0);
              }
        }
 }