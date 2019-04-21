import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;

class dist implements ActionListener
{
      Container c1;
      JFrame fdist;
      JPanel pdist;
      JScrollPane sp;

      JTextField distname,distid,distph,distmob;
	  JLabel ldisp,lsubmitr1;
	  JComboBox distfor;
	  JTextArea distaddr;
      JButton ab,eb,sb,cb,hb;
      Icon mig;
      Font f1,f2,f3,f4;

      PreparedStatement stat;
      ResultSet rs1;
      Statement s1;
      Connection con;

       public static void main(String args[])
       {
 	          dist dist1=new dist();
       }

      dist()
      {
            try
            {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               con=DriverManager.getConnection("jdbc:odbc:bookstore");
            }
            catch(Exception ex)
            {
               System.out.println(ex);
            }

            fdist=new JFrame("Distributor");
            pdist=new JPanel();
            pdist.setLayout(null);
            pdist.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            pdist.setBounds(190,100,650,500);

		f1=new Font("Times New Roman",Font.BOLD,35);
		f2=new Font("Times New Roman",Font.ITALIC,25);
		f3=new Font("Times New Roman",Font.BOLD,15);

        mig=new ImageIcon("images\\b1.jpg");

		ldisp = new JLabel("!DISTRIBUTOR DETAILS!");
		ldisp.setFont(f1);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(125,15,500,35);

        JLabel lborder1=new JLabel(mig);
		lborder1.setBounds(0,50,650,20);

		lsubmitr1=new JLabel("Add Distributor");
		lsubmitr1.setFont(f2);
		lsubmitr1.setForeground(Color.magenta);
		lsubmitr1.setBounds(250,75,500,30);
		JLabel ldistid= new JLabel("Distributor ID");
		ldistid.setFont(f3);
		ldistid.setBounds(150,120,120,20);
        JLabel ldistname =new JLabel("Distributor Name");
        ldistname.setFont(f3);
		ldistname.setBounds(150,150,120,20);
		JLabel ldistaddr= new JLabel("Address");
		ldistaddr.setFont(f3);
		ldistaddr.setBounds(150,180,100,20);
		JLabel ldistph = new JLabel("Phone No.");
		ldistph.setFont(f3);
		ldistph.setBounds(150,270,150,20);
		JLabel ldistmob= new JLabel("Mobile No.");
		ldistmob.setFont(f3);
		ldistmob.setBounds(150,300,150,20);
		JLabel ldistfor= new JLabel("Distributor for");
		ldistfor.setFont(f3);
		ldistfor.setBounds(150,330,150,20);

		distid = new JTextField();
		distid.setBounds(300,120,50,20);
		distname= new JTextField();
		distname.setBounds(300,150,250,20);
		distaddr = new JTextArea();
		distaddr.setLineWrap(true);
        sp = new JScrollPane(distaddr);
		sp.setBounds(300,180,175,70);

		distph= new JTextField();
		distph.setBounds(300,270,100,20);
		distmob= new JTextField();
		distmob.setBounds(300,300,100,20);
        distfor = new JComboBox();
                 distfor.addItem(" Books");
                 distfor.addItem(" NoteBooks");
                 distfor.addItem(" Stationary");
		distfor.setBounds(300,330,100,20);

        JLabel lborder=new JLabel(mig);
		lborder.setBounds(0,300,650,150);

        ab=new JButton("ADD");
        ab.setBounds(80,420,90,25);
        ab.addActionListener(this);
		eb=new JButton("UPDATE");
		eb.setEnabled(false);
		eb.setBounds(180,420,90,25);
		eb.addActionListener(this);
		sb=new JButton("SEARCH");
		sb.setBounds(280,420,90,25);
		sb.addActionListener(this);
		cb=new JButton("CLEAR");
		cb.setBounds(380,420,90,25);
		cb.addActionListener(this);
		hb=new JButton("HOME");
		hb.setBounds(480,420,90,25);
		hb.addActionListener(this);

		pdist.add(ldisp);pdist.add(lsubmitr1);

        pdist.add(ldistid);pdist.add(lborder1);pdist.add(distid);
		pdist.add(ldistname); pdist.add(distname);
        pdist.add(ldistaddr); pdist.add(sp);
        pdist.add(ldistph); pdist.add(distph);
        pdist.add(ldistmob); pdist.add(distmob);
        pdist.add(ldistfor); pdist.add(distfor);
        pdist.add(lborder);

        pdist.add(ab); pdist.add(eb);
        pdist.add(sb);pdist.add(cb);pdist.add(hb);

            c1=fdist.getContentPane();
            c1.setLayout(null);
            c1.add(pdist,"Center");

            fdist.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fdist.setSize(1024,768);
            fdist.setVisible(true);
            fdist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
      
       distname.addKeyListener(new KeyAdapter() 
    {
        public void keyTyped(KeyEvent e) {
    	char c = e.getKeyChar();      
      		if (((Character.isDigit(c)))) 
      	//if(!((c>=65 && c<=90) || (c>=97 && c<=122)))
      		{
        	 JOptionPane.showMessageDialog(null, "Please enter Alphabets");
           	 e.consume();
      		}
    		}
  		    });
  		    
  		    
  	   distph.addKeyListener(new KeyAdapter() 
    {
        public void keyTyped(KeyEvent e) {
    	char c = e.getKeyChar();      
      		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) 
      		{
        	 JOptionPane.showMessageDialog(null, "Please enter a numerical value");
           	 e.consume();
      		}
    		}
  		    });
  		    
		distmob.addKeyListener(new KeyAdapter() 
    {
        public void keyTyped(KeyEvent e) {
    	char c = e.getKeyChar();      
      		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) 
      		{
        	 JOptionPane.showMessageDialog(null, "Please enter a numerical value");
           	 e.consume();
      		}
    		}
  		    });  		    
  		    
}
      public void clrAll()
      {
                  distname.setText("");
                  distid.setText("");
                  distaddr.setText("");
                  distph.setText("");
                  distmob.setText("");
                  ab.setEnabled(true);
                  eb.setEnabled(false);
      }

       public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();

              if(obj==hb)
              {
                 fdist.dispose();
                 newmain1 m1=new newmain1();
              }
               if(obj==cb)
              {
                  clrAll();
              }
              if(obj==ab)
              {
                    try
                    {
			   		   s1=con.createStatement();
			   		   String  ss1="insert into distinfo values('"+distid.getText()+"','"+distname.getText()+"','" +distaddr.getText() + "','" +distph.getText() + "','" +distmob.getText() + "','" +distfor.getSelectedItem() + "')";
                       s1.executeUpdate(ss1);
                       String msg= " Distributor Record Save Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                    s1.close();
                    con.close();

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

              }
              if(obj==sb)
              {
                    try
                    {
                       String s;
                       s=distid.getText();
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore","","");
			   		   stat = con.prepareStatement("select * from distinfo where distid=?");
			   		   stat.setString(1,distid.getText());
			   		   rs1=stat.executeQuery();

                      if(rs1.next()){
			   		  distid.setText(rs1.getString(1));
			          distname.setText(rs1.getString(2));
			          distaddr.setText(rs1.getString(3));
			          distph.setText(rs1.getString(4));
			          distmob.setText(rs1.getString(5));

			          distfor.setSelectedItem(rs1.getString(6));
                      eb.setEnabled(true);
                      ab.setEnabled(false);
                      }
                      else{
                        String msg= "Record Does not exist";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                      }
                      stat.close();
                      con.close();

                    }
                    catch(SQLException se)
                    {
                        System.err.println(se);

                    }
                    catch(Exception e)
                    {
                        System.err.println(e);
                    }

              }
               if(obj==eb)
              {
                   try
                    {   s1=null;
                     int i = JOptionPane.showConfirmDialog(fdist,"Do you want to Update","Update?",JOptionPane.YES_NO_OPTION);
                     if(i== JOptionPane.YES_OPTION){
                       String sdistid = distid.getText();
                       s1 = con.createStatement();

                       String q = "UPDATE distinfo SET distname='"+distname.getText()+"',"+
                                  "distaddr='"+distaddr.getText()+"',"+
                                  "distph='"+distph.getText()+"',"+
                                  "distmob='"+distmob.getText()+"',"+
                                  "distfor='"+distfor.getSelectedItem()+"'"+
                                  "WHERE distid='"+sdistid+"'";

                        System.out.println(q);
                       int a = s1.executeUpdate(q);
                        clrAll();
			   		   System.out.println(a);
			   		   String msg= " Distributor Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog(fdist,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
			   		}
			   		else{return;}

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

              }
        }
}