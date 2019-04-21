import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.*;

class bill1 implements ActionListener
{
    Container c1;
    JFrame bfrm;
	JPanel bpan1,bpan2;
	JButton b1,b2,b3,b4,b5,b6,b7,btnAdd;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l20,l21,l23,l24;
	JTextField tf1,tf2;
	Thread datimeThread;
	Date date;
	GregorianCalendar calendar;
	String strDate, strTime, strStatus;
	Icon mig;
    Font f1,f2,f3;
    JRadioButton r1y,r2n;
    JRadioButton r1,r2,r3;
    ButtonGroup bg1,bg2 ;
    int billNo;

    int ar[];

    JComboBox bname,nbname,stat;

    JLabel lblQ,lblP,lblAmt,lblBB,lblTot,lblPaid;
    JTextField txtQB,txtQN,txtQS,txtPB,txtPN,txtPS,txtAmtB,txtAmtN,txtAmtS;
    JTextField txtTot,txtPaid,txtBal;

    List lstBB;

    JSeparator jsp;

    ResultSet rs1;
    Statement s1;
    Connection con;

      public static void main(String args[])
      {
             bill1 bill=new bill1();
       }

      bill1()
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

                    rs1 = s1.executeQuery("select * from sbill");
                    while(rs1.next()){billNo++;}
                    billNo++;
			}

            catch(Exception e)
			{
			 System.out.println(e);
            }
            f1=new Font("Times New Roman",Font.BOLD,35);
		    f2=new Font("Times New Roman",Font.ITALIC,25);
		    f3=new Font("Times New Roman",Font.BOLD,15);

            bfrm = new JFrame("Bill Window");
            bpan1 = new JPanel();
            bpan1.setLayout(null);
            bpan1.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            bpan1.setBounds(190,60,650,485);
            bpan2=new JPanel();
            bpan2.setLayout(null);
            bpan2.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            bpan2.setBounds(190,550,650,100);

		    mig=new ImageIcon("b1.jpg");

            c1=bfrm.getContentPane();
            c1.setLayout(null);
            c1.add(bpan1,"Center");
            c1.add(bpan2,"South");

            bfrm.setExtendedState(JFrame.MAXIMIZED_BOTH);
            bfrm.setSize(1024,768);
            bfrm.setVisible(true);
            bfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            date=new Date();
		    calendar=new GregorianCalendar();
		    calendar.setTime(date);

		    strDate =
		    calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);

		    tf1=new JTextField();
		    tf2=new JTextField();

		        bg1=new ButtonGroup();

                r1=new JRadioButton("Book");
                r1.setBounds(250,160,100,20);
		        r2=new JRadioButton("NoteBook");
		        r2.setBounds(360,160,100,20);
		        r3=new JRadioButton("Stationary");
		        r3.setBounds(470,160,100,20);

		        bg1.add(r1);
		        bg1.add(r2);
		        bg1.add(r3);
                bpan1.add(r1);
		        bpan1.add(r2);
		        bpan1.add(r3);

		        bname =new JComboBox();
		        bname.setBounds(230,190,100,20);
                nbname = new JComboBox();
                nbname.setBounds(340,190,100,20);
                stat = new JComboBox();
                stat.setBounds(450,190,100,20);

                lblQ = new JLabel("Quantity");
                lblQ.setFont(f3);
                lblQ.setBounds(150,220,120,20);
                lblP = new JLabel("Price");
                lblP.setFont(f3);
                lblP.setBounds(150,250,120,20);
                lblAmt = new JLabel("Amount");
                lblAmt.setFont(f3);
                lblAmt.setBounds(150,280,120,20);

                lblBB = new JLabel("Buy Item");
                lblBB.setFont(f3);
                lblBB.setBounds(230,320,120,20);
                lblTot = new JLabel("Total Amount:-");
                lblTot.setFont(f3);
                lblTot.setBounds(380,380,100,20);
                lblPaid = new JLabel("Paid :-");
                lblPaid.setFont(f3);
                lblPaid.setBounds(380,410,100,20);
                l24=new JLabel("Balance :-");
                l24.setFont(f3);
		        l24.setBounds(380,440,100,20);


                txtQB = new JTextField();
                txtQB.setBounds(230,220,100,20);
                txtQN = new JTextField();
                txtQN.setBounds(340,220,100,20);
                txtQS = new JTextField();
                txtQS.setBounds(450,220,100,20);
                txtPB = new JTextField();
                txtPB.setEditable(false);
                txtPB.setBounds(230,250,100,20);
                txtPN = new JTextField();
                txtPN.setEditable(false);
                txtPN.setBounds(340,250,100,20);
                txtPS = new JTextField();
                txtPS.setEditable(false);
                txtPS.setBounds(450,250,100,20);
                txtAmtB = new JTextField();
                txtAmtB.setEditable(false);
                txtAmtB.setBounds(230,280,100,20);
                txtAmtN = new JTextField();
                txtAmtN.setEditable(false);
                txtAmtN.setBounds(340,280,100,20);
                txtAmtS = new JTextField();
                txtAmtS.setEditable(false);
                txtAmtS.setBounds(450,280,100,20);

                jsp= new JSeparator(JSeparator.HORIZONTAL);
                jsp.setForeground(Color.black);
                jsp.setBounds(5,310,640,5);
                bpan1.add(jsp);

                lstBB=new List();
                lstBB.setBounds(180,345,160,80);

                txtTot=new JTextField();
                txtTot.setBounds(500,380,100,20);
                txtTot.setEditable(false);
                txtTot.setText("0");
                txtPaid=new JTextField();
                txtPaid.setBounds(500,410,100,20);
                txtPaid.setText("0");
                txtBal=new JTextField();
                txtBal.setBounds(500,440,100,20);
                txtBal.setText("0");
                txtBal.setEditable(false);

		l1=new JLabel("!Anmol Book Depot!");
		l2=new JLabel("Ph.No :-(0253)6992271");
		l3=new JLabel("Bill No :-");
		l4=new JLabel("Date :-");
		l5=new JLabel("_________________________________________________________________________________________________________");
		l6=new JLabel("Customer Name :-");
		l7=new JLabel("Phone No:-");
		l8=new JLabel("_________________________________________________________________________________________________________");

		l20=new JLabel("");
		l20.setText(String.valueOf(billNo));
		l21=new JLabel(strDate);
		l23=new JLabel("Bill Pending :-");

	    l1.setFont(f1);
		l1.setForeground(Color.red);
		bpan1.add(l1);
		l1.setBounds(40,20,320,40);
        l2.setFont(f3);
		bpan1.add(l2);
		l2.setBounds(120,55,200,30);
        l3.setFont(f3);
		bpan1.add(l3);
		l3.setBounds(400,60,90,20);
        l4.setFont(f3);
		bpan1.add(l4);
		l4.setBounds(400,80,90,20);
        bpan1.add(l5);
		l5.setBounds(10,90,630,20);
		l6.setFont(f3);
        bpan1.add(l6);
		l6.setBounds(15,115,150,20);
		l7.setFont(f3);
        bpan1.add(l7);
		l7.setBounds(420,115,115,20);
		bpan1.add(l8);
		l8.setBounds(10,125,630,20);

		l20.setFont(f3);
        bpan1.add(l20);
		l20.setBounds(470,60,90,20);
		l20.setForeground(Color.red);
		l21.setFont(f3);
        bpan1.add(l21);
		l21.setBounds(450,80,90,20);

		bpan1.add(l23);
        l23.setFont(f3);
		l23.setBounds(100,440,100,20);



        tf1.setBounds(140,115,250,20);
		tf1.setForeground(Color.red);
        bpan1.add(tf1);
        tf2.setBounds(500,115,100,20);
		bpan1.add(tf2);

		bg2=new ButtonGroup();
        r1y=new JRadioButton("Yes");
		r1y.setBounds(200,440,50,25);
		r2n=new JRadioButton("No");
		r2n.setBounds(250,440,50,25);
		bg2.add(r1y);
		bg2.add(r2n);
        bpan1.add(r1y);
		bpan1.add(r2n);
        r1y.addActionListener(this);
		r2n.addActionListener(this);

		b1=new JButton("PRINT");
        b2=new JButton("SAVE");
        b5=new JButton("CLEAR");
        b6=new JButton("HOME");
        btnAdd = new JButton("Add Item");
        btnAdd.setBounds(90,365,80,25);

        bpan2.add(b1);
        b1.setBounds(150,35,80,25);
        bpan2.add(b2);
        b2.setBounds(240,35,80,25);

        bpan2.add(b5);
        b5.setBounds(330,35,80,25);
        b5.addActionListener(this);
        bpan2.add(b6);
        b6.setBounds(420,35,80,25);
        b6.addActionListener(this);

            bpan1.add(stat);
            bpan1.add(bname);
            bpan1.add(nbname);

             bpan1.add(lblQ);
             bpan1.add(lblP);
             bpan1.add(lblAmt);

             bpan1.add(lblBB);
             bpan1.add(lblTot);
             bpan1.add(lblPaid);
             bpan1.add(btnAdd);
             bpan1.add(lstBB);
             bpan1.add(l24);
             bpan1.add(txtTot);
             bpan1.add(txtPaid);
             bpan1.add(txtBal);
             bpan1.add(txtQB);
             bpan1.add(txtQN);
             bpan1.add(txtQS);
             bpan1.add(txtPB);
             bpan1.add(txtPN);
             bpan1.add(txtPS);
             bpan1.add(txtAmtB);
             bpan1.add(txtAmtN);
             bpan1.add(txtAmtS);
             bpan1.repaint();

            KeyListen kl = new KeyListen();
                txtQB.addKeyListener(kl);
                txtQN.addKeyListener(kl);
                txtQS.addKeyListener(kl);

            txtPaid.addKeyListener(kl);

            r1.addActionListener(this);
            r2.addActionListener(this);
            r3.addActionListener(this);

            btnAdd.addActionListener(this);
            b2.addActionListener(this);
        }

        public void chBal()
        {
                    int tot = Integer.parseInt(txtTot.getText());
                    int paid = Integer.parseInt(txtPaid.getText());
                    int bal = tot-paid;
                    txtBal.setText(String.valueOf(bal));
        }
        class  KeyListen extends KeyAdapter
        {
               public void keyReleased(KeyEvent ke)
               {
               Object obj = ke.getSource();
               if(obj==txtPaid){
                    if(txtPaid.getText().equals("")){
                          txtPaid.setText("0");
                    }
                    else{chBal();}
               }
               if(obj==txtQB){
               try{
                     rs1 = s1.executeQuery("select * from bookdetails");
                     while(rs1.next()){
                     if(bname.getSelectedItem().equals(rs1.getString(2))){
                          if(Integer.parseInt(txtQB.getText())> Integer.parseInt(rs1.getString(7)))
                            {
                             String msg= "Quantity is Greater than Available Stock ";
                             txtQB.setText("");
                             txtPB.setText("");
                             txtAmtB.setText("");
                             JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                             break;
                             }
                            else{
                            txtPB.setText(rs1.getString(5));
                            int a = Integer.parseInt(txtPB.getText())*Integer.parseInt(txtQB.getText());
                            txtAmtB.setText(String.valueOf(a));
                            }
                        }
                     }
                }
                catch(Exception ex){System.out.println(ex);}
               }
               if(obj==txtQN){
               try{
                     rs1 = s1.executeQuery("select * from NoteBookDetails");
                     while(rs1.next()){
                     if(nbname.getSelectedItem().equals(rs1.getString(2))){
                          if(Integer.parseInt(txtQN.getText())> Integer.parseInt(rs1.getString(9)))
                            {
                             String msg= "Quantity is Greater than Available Stock ";
                             txtQN.setText("");
                             txtPN.setText("");
                             txtAmtN.setText("");
                             JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                             break;
                             }
                            else{
                            txtPN.setText(rs1.getString(7));
                            int a = Integer.parseInt(txtPN.getText())*Integer.parseInt(txtQN.getText());
                            txtAmtN.setText(String.valueOf(a));
                            }
                        }
                     }
                }
                catch(Exception ex){System.out.println(ex);}
               }
               if(obj==txtQS){
               try{
                     rs1 = s1.executeQuery("select * from StationaryDetails");
                     while(rs1.next()){
                     if(stat.getSelectedItem().equals(rs1.getString(2))){
                          if(Integer.parseInt(txtQS.getText())> Integer.parseInt(rs1.getString(6)))
                            {
                             String msg= "Quantity is Greater than Available Stock ";
                             txtQS.setText("");
                             txtPS.setText("");
                             txtAmtS.setText("");
                             JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                             break;
                             }
                            else{
                            txtPS.setText(rs1.getString(4));
                            int a = Integer.parseInt(txtPS.getText())*Integer.parseInt(txtQS.getText());
                            txtAmtS.setText(String.valueOf(a));
                            }
                        }
                     }
                }
                catch(Exception ex){System.out.println(ex);}
               }
            }
        }
        public void chAmount()
        {
                    if(bname.isEnabled()){
                    int a =Integer.parseInt(txtAmtB.getText());
                    int b;
                    b = Integer.parseInt(txtTot.getText());
                    int c =a+b;
                    txtTot.setText(String.valueOf(c));
                    int d = Integer.parseInt(txtPaid.getText());
                    int bal =  c-d;
                    txtBal.setText(String.valueOf(bal));
                    }
                    else
                    if(nbname.isEnabled()){
                    int a =Integer.parseInt(txtAmtN.getText());
                    int b;
                    b = Integer.parseInt(txtTot.getText());
                    int c =a+b;
                    txtTot.setText(String.valueOf(c));
                    int d = Integer.parseInt(txtPaid.getText());
                    int bal =  c-d;
                    txtBal.setText(String.valueOf(bal));
                    }
                    else
                    if(stat.isEnabled()){
                    int a =Integer.parseInt(txtAmtS.getText());
                    int b;
                    b = Integer.parseInt(txtTot.getText());
                    int c =a+b;
                    txtTot.setText(String.valueOf(c));
                    int d = Integer.parseInt(txtPaid.getText());
                    int bal =  c-d;
                    txtBal.setText(String.valueOf(bal));
                    }
        }
        public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();
               if(obj==r1y){
                   txtPaid.setEditable(false);
               }
               if(obj==r2n){
                            int x;
                            x = Integer.parseInt(txtBal.getText());
                            if(x>0){
                            String msg= "Balance must be Zero ";
                             JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);

                        }
                   txtPaid.setEditable(true);
               }
               if(obj == b2){
               if(tf1.getText().equals(""))
               {
                       String msg= "Please Enter the Customer Name";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                       return;
               }
               else{
                   String sYN="No";
                    if(r1y.isSelected()){
                       sYN="Yes";
                    }
                    else
                    {
                        sYN="No";
                     }
                     try
                    {
                       s1=null;
			   		   s1=con.createStatement();
			   		   String  ss1="insert into sbill values('"+billNo+"',"+
                          "'"+strDate+"',"+
                          "'" +tf1.getText()+ "',"+
                          "'" +tf2.getText() + "',"+
                          "'" +txtTot.getText() + "',"+
                          "'" +txtPaid.getText() + "',"+
                          "'" +txtBal.getText() + "',"+
                          "'" +sYN+ "')";
                       s1.executeUpdate(ss1);
                       String msg= "Bill Save  Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                  }
               }
               if(obj==btnAdd)
               {
                     if(bname.isEnabled()){
                           int i=0;
                           int j=0;
                           try{
                                rs1=null;
                                s1=null;
                                s1 = con.createStatement();
                                rs1 = s1.executeQuery("select * from bookdetails");
                                while(rs1.next()){
                                     if(bname.getSelectedItem().equals(rs1.getString(2))){
                                        i=Integer.parseInt(rs1.getString(7));
                                     }
                                }
                           }
                           catch(Exception ex){
                               System.out.println(ex);
                           }
                           if(txtQB.getText().equals("")){
                              String msg= "Please Enter the Quantity?";
                              JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                           }
                           else{j=Integer.parseInt(txtQB.getText());}
                           i=i-j;
                           try{
                               s1=null;
                                 rs1=null;
                                 s1 = con.createStatement();
                                 String s = String.valueOf(i);
                                 String q = "UPDATE bookdetails SET quantity='"+s+"'"+
                                  "WHERE book_name='"+bname.getSelectedItem()+"'";
                                  s1.executeUpdate(q);
                           }
                           catch(Exception ex){
                               System.out.println(ex);
                           }
                           chAmount();
                           lstBB.add(String.valueOf(bname.getSelectedItem()));
                     }
                    if(nbname.isEnabled()){
                          int i=0;
                          int j=0;
                           try{
                                rs1=null;
                                s1=null;
                                s1 = con.createStatement();
                                rs1 = s1.executeQuery("select * from NoteBookDetails");
                                while(rs1.next()){
                                     if(nbname.getSelectedItem().equals(rs1.getString(2))){
                                        i=Integer.parseInt(rs1.getString(9));
                                     }
                                }
                           }
                           catch(Exception ex){
                               System.out.println(ex);
                           }
                           if(txtQN.getText().equals("")){
                              String msg= "Please Enter the Quantity?";
                              JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                           }
                           else{j=Integer.parseInt(txtQN.getText());}
                           i=i-j;
                           try{
                                 s1=null;
                                 rs1=null;
                                 s1 = con.createStatement();
                                 String s = String.valueOf(i);
                                 String q = "UPDATE NoteBookDetails SET quantity='"+s+"'"+
                                  "WHERE nbookname='"+nbname.getSelectedItem()+"'";
                                  s1.executeUpdate(q);
                           }
                           catch(Exception ex){
                               System.out.println(ex);
                           }
                           chAmount();
                           lstBB.add(String.valueOf(nbname.getSelectedItem()));

                     }
                     else if(stat.isEnabled()){
                          int i=0;
                          int j=0;
                           try{
                                rs1=null;
                                s1=null;
                                s1 = con.createStatement();
                                rs1 = s1.executeQuery("select * from StationaryDetails");
                                while(rs1.next()){
                                     if(stat.getSelectedItem().equals(rs1.getString(2))){
                                        i=Integer.parseInt(rs1.getString(6));
                                     }
                                }
                           }
                           catch(Exception ex){
                               System.out.println(ex);
                           }
                           if(txtQS.getText().equals("")){
                              String msg= "Please Enter the Quantity?";
                              JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                           }
                           else{j=Integer.parseInt(txtQS.getText());}
                           i=i-j;
                           try{
                                 s1=null;
                                 rs1=null;
                                 s1 = con.createStatement();
                                 String s = String.valueOf(i);
                                 String q = "UPDATE StationaryDetails SET Quantity='"+s+"'"+
                                  "WHERE stname='"+stat.getSelectedItem()+"'";
                                  s1.executeUpdate(q);
                           }
                           catch(Exception ex){
                               System.out.println(ex);
                           }
                           chAmount();
                          lstBB.add(String.valueOf(stat.getSelectedItem()));
                     }
               }
               if(obj == r1){

                    try{ rs1=null;
                         bname.setEnabled(true);
                         txtQB.setEnabled(true);

                        rs1 = s1.executeQuery("select * from bookdetails");
                        bname.removeAllItems();
                        while(rs1.next())
                        {
                            bname.addItem(rs1.getString(2));
                        }
                         txtQS.setEnabled(false);

                         txtQN.setEnabled(false);
                         nbname.setEnabled(false);
                         stat.setEnabled(false);
                    }
                    catch(Exception ex){System.out.println(ex);}
                  }
                  if(obj == r2){
                    try{   rs1=null;
                           nbname.setEnabled(true);
                           txtQN.setEnabled(true);
                            rs1 = s1.executeQuery("select * from NoteBookDetails");
                            nbname.removeAllItems();
                        while(rs1.next())
                        {
                            nbname.addItem(rs1.getString(2));
                         }
                         txtQS.setEnabled(false);
                         txtQB.setEnabled(false);

                         bname.setEnabled(false);
                        stat.setEnabled(false);


                    }
                    catch(Exception ex){System.out.println(ex);}
                  }

                  if(obj == r3){
                    try{  rs1=null;
                       stat.setEnabled(true);
                         txtQS.setEnabled(true);
                         rs1 = s1.executeQuery("select * from StationaryDetails");
                         stat.removeAllItems();
                        while(rs1.next())
                        {
                            stat.addItem(rs1.getString(2));
                         }
                         bname.setEnabled(false);
                        nbname.setEnabled(false);

                         txtQB.setEnabled(false);
                         txtQN.setEnabled(false);

                    }
                    catch(Exception ex){System.out.println(ex);}
                  }
              if(obj==b6)
              {
                 bfrm.dispose();
                 newmain1 m1=new newmain1();
              }
              if(obj==b5)
              {
                  try{
                  tf1.setText("");tf2.setText("");
                  txtQB.setText("");txtQN.setText("");txtQS.setText("");
                  txtPB.setText("");txtPN.setText("");txtPS.setText("");
                  txtAmtB.setText("");txtAmtN.setText("");txtAmtS.setText("");
                  txtTot.setText("0");txtPaid.setText("0");txtBal.setText("0");

                  lstBB.removeAll();

                  }
                  catch(Exception ex)
                  {
                   System.out.println(ex);
                  }
              }

       }
 }