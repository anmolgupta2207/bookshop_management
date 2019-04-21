import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import java.util.Date;
import java.util.Calendar;
import javax.swing.border.LineBorder;
import java.sql.*;

class pbill extends JPanel implements ActionListener
{
      Container c1;
      JFrame fpbill;
      JPanel pbill;
      JLabel ldisp,lsubmitr1,l4,l6,l7,ldistid,ldistname,lperti,lpcost,lquantity,lamount,lamtype,lcdno;
      JTextField distname,distid,distfor,perti,pcost,quantity,amount,cdno,tf1,tf2;
      Thread datimeThread;
	  Date date;
	  GregorianCalendar calendar;
	  String strDate, strTime, strStatus;
      Icon mig;
      Font f1,f2,f3,f4;
      JComboBox amttype;
      JButton bsave,bnew,bhome,bclear,bnext,bprev;

      PreparedStatement stat;
      ResultSet rs1;
      Statement s1;
      Connection con;

      public static void main(String args[])
       {
 	          pbill p1=new pbill();
       }

      pbill()
      {

            try
            {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception ex)
            {
               System.out.println(ex);
            }
            try
            {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   	    con=DriverManager.getConnection("jdbc:odbc:bookstore","","");
			   	    s1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			   	    rs1 = s1.executeQuery("select * from distinfo");
			}
			catch(Exception e)
			{
			 System.out.println(e);
            }
            fpbill=new JFrame("Purchase Order");
            pbill=new JPanel();
            pbill.setLayout(null);
            pbill.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            pbill.setBounds(190,100,650,500);

        f1=new Font("Times New Roman",Font.BOLD,35);
		f2=new Font("Times New Roman",Font.ITALIC,25);
		f3=new Font("Times New Roman",Font.BOLD,15);

        mig=new ImageIcon("images\\b1.jpg");

		ldisp = new JLabel("!PURCHASE ORDER!");
		ldisp.setFont(f1);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(135,15,500,35);

        JLabel lborder1=new JLabel(mig);
		lborder1.setBounds(0,50,650,20);

		date=new Date();
		calendar=new GregorianCalendar();
		calendar.setTime(date);

		strDate =
		calendar.get(Calendar.DATE)+" / "+(calendar.get(Calendar.MONTH)+1)+" / "+calendar.get(Calendar.YEAR);

		l4=new JLabel("Date :-");
		l4.setFont(f3);
        l4.setBounds(430,90,90,20);
		l6=new JLabel(strDate);
        l6.setBounds(480,90,90,20);

        ldistid= new JLabel("Distributor ID");
		ldistid.setFont(f3);
		ldistid.setBounds(150,120,120,20);
        ldistname =new JLabel("Distributor Name");
        ldistname.setFont(f3);
		ldistname.setBounds(150,150,120,20);
		JLabel ldistfor= new JLabel("Distributor for");
		ldistfor.setFont(f3);
		ldistfor.setBounds(150,180,150,20);
		l7=new JLabel("______________________________________________________________________________");
        l7.setBounds(100,200,650,20);
        lperti= new JLabel("Particulars");
		lperti.setFont(f3);
		lperti.setBounds(150,230,120,20);
		lpcost= new JLabel("Purchase Cost");
		lpcost.setFont(f3);
		lpcost.setBounds(150,260,120,20);
		lquantity= new JLabel("Quantity");
		lquantity.setFont(f3);
		lquantity.setBounds(420,260,80,20);
		lamount= new JLabel("Amount");
		lamount.setFont(f3);
		lamount.setBounds(150,320,120,20);
		lamtype= new JLabel("Amount Type");
		lamtype.setFont(f3);
		lamtype.setBounds(150,290,100,20);
		lcdno= new JLabel("Cheque/DD No");
		lcdno.setFont(f3);
		lcdno.setBounds(150,350,120,20);

		distid = new JTextField();
		distid.setBounds(300,120,50,20);
		distid.setEditable(false);
		distname= new JTextField();
		distname.setBounds(300,150,250,20);
		distname.setEditable(false);
		distfor = new JTextField();
		distfor.setBounds(300,180,100,20);
		distfor.setEditable(false);
		perti=new JTextField();
		perti.setBounds(300,230,150,20);
		pcost=new JTextField();
		pcost.setBounds(300,260,70,20);
		quantity=new JTextField();
		quantity.setBounds(500,260,50,20);

		KeyListen k2 = new KeyListen();
		quantity.addKeyListener(k2);

		amount=new JTextField();
		amount.setBounds(300,320,70,20);
		cdno=new JTextField();
		cdno.setBounds(300,350,70,20);

		amttype=new JComboBox();
		amttype.addItem("By Cash");
		amttype.addItem("By Cheqe");
		amttype.addItem("By DD");
		amttype.setBounds(300,290,80,20);
		amttype.addActionListener(this);

		JLabel lborder=new JLabel(mig);
		lborder.setBounds(0,320,650,150);

        bsave=new JButton("SAVE");
        bsave.setBounds(150,430,80,25);
        bsave.addActionListener(this);
        bnew=new JButton("NEW");
        bnew.setBounds(240,430,80,25);
        bnew.addActionListener(this);
        bclear=new JButton("CLEAR");
        bclear.setBounds(330,430,80,25);
        bclear.addActionListener(this);
        bhome=new JButton("HOME");
        bhome.setBounds(420,430,80,25);
        bhome.addActionListener(this);
        bnext=new JButton(">>");
        bnext.setBounds(470,120,50,20);
        bnext.addActionListener(this);
        bprev=new JButton("<<");
        bprev.setBounds(400,120,50,20);
        bprev.addActionListener(this);

            pbill.add(l4);
            pbill.add(l6);pbill.add(l7);
            pbill.add(ldisp);pbill.add(lborder1);
            pbill.add(ldistid);pbill.add(distid);
		    pbill.add(ldistname); pbill.add(distname);
		    pbill.add(ldistfor);pbill.add(distfor);
		    pbill.add(lperti);pbill.add(perti);
            pbill.add(lpcost);pbill.add(pcost);
            pbill.add(lquantity);pbill.add(quantity);
            pbill.add(lamount);pbill.add(amount);pbill.add(lamtype);pbill.add(amttype);
            pbill.add(lcdno);pbill.add(cdno);pbill.add(lborder);

            pbill.add(bsave);pbill.add(bnew);
            pbill.add(bclear);pbill.add(bhome);pbill.add(bprev);pbill.add(bnext);

            c1=fpbill.getContentPane();
            c1.setLayout(null);
            c1.add(pbill,"Center");

            fpbill.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fpbill.setSize(1024,768);
            fpbill.setVisible(true);
            fpbill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	
	 perti.addKeyListener(new KeyAdapter() 
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
  	
  	pcost.addKeyListener(new KeyAdapter() 
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
  	
  	
  	quantity.addKeyListener(new KeyAdapter() 
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
  		    
  		
  	amount.addKeyListener(new KeyAdapter() 
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
    class  KeyListen extends KeyAdapter
        {
               public void keyReleased(KeyEvent ke)
               {
               Object obj = ke.getSource();
               if(obj==quantity){
                    try{
                    int a=Integer.parseInt(pcost.getText())*Integer.parseInt(quantity.getText());
                    amount.setText(String.valueOf(a));
                    }
                    catch(Exception ex){System.out.println(ex);}
               }
               }
        }

     public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();

              if(obj==amttype){
                 if(amttype.getSelectedItem().equals("By Cash")){
                     cdno.setEnabled(false);
                 }
                  else if(amttype.getSelectedItem().equals("By Cheqe")){
                     cdno.setEnabled(true);
                 }
                 else if(amttype.getSelectedItem().equals("By DD")){
                     cdno.setEnabled(true);
                 }
              }
               if(obj==bsave){
                       try{
                        s1=null;
			   		    s1=con.createStatement();
			   		    String  ss1="insert into pbill values('"+strDate+"',"+
                          "'" +distid.getText()+ "',"+
                          "'" +distname.getText() + "',"+
                          "'" +perti.getText() + "',"+
                          "'" +pcost.getText() + "',"+
                          "'" +quantity.getText() + "',"+
                          "'" +amount.getText() + "',"+
                          "'" +amttype.getSelectedItem() + "',"+
                          "'" +cdno.getText() + "')";
                       s1.executeUpdate(ss1);
                       String msg= "Purchase Order Save  Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
              }
              if(obj==bhome)
              {
                 fpbill.dispose();
                 newmain1 m1= new newmain1();
              }
               if(obj==bnew)
              {
                  perti.setText("");
                  pcost.setText("");
                  quantity.setText("");
                  amount.setText("");
                  cdno.setText("");
              }
               if(obj==bclear)
              {
                  distid.setText("");
                  distname.setText("");
                  distfor.setText("");
                  perti.setText("");
                  pcost.setText("");
                  quantity.setText("");
                  amount.setText("");
                  cdno.setText("");
              }
              if(obj==bnext)
              {
                    try{
                         rs1.next();
                         rs1.refreshRow();
                         distid.setText(rs1.getString(1));
                         distname.setText(rs1.getString(2));
                         distfor.setText(rs1.getString(6));

                    }

                    catch(Exception e)
                    {
                         System.out.println(e);
                         String msg= "Record Does not exist";
                         JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                    }

              }
              if(obj==bprev)
              {
                    try{
                         rs1.previous();
                         rs1.refreshRow();
                         distid.setText(rs1.getString(1));
                         distname.setText(rs1.getString(2));
                         distfor.setText(rs1.getString(6));

                    }
                    catch(Exception e)
                    {
                         System.out.println(e);
                         String msg= "Record Does not exist";
                         JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                    }

              }

}      }