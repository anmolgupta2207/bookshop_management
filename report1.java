import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

class report1 extends MouseAdapter implements ActionListener
{
    Container c1;
    JFrame rfrm;
    JPanel astock,pnbill;
    Icon mig;
    Font f1,f2,f3,f4;
    String ch;
    String str;
    JLabel ldisp,lsubmitr1;
    int i;
    JRadioButton r1,r2,r3;
    ButtonGroup bg1 ;
    JLabel lid,lname,lavailable;
    JTextField id,available;
    JComboBox name;
    JButton hb,btnRec,btnhome;
    List itemname;

    JComboBox custname;
    JTextField txtpaid,txtbal,txtTot,cphno;
    JLabel ldate,lbillno,ld,lbno,lbcustn,lbpaid,lbbal,lbTot,lline,lcphno;
    JList cname;
    JScrollPane sp;
    String s11[];
    ResultSet rs1;
    Statement s1;
    Connection con;

     public static void main(String args[])
    {
 	      report1 r1=new report1();
    }

    report1(){
         try{
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        catch(Exception ex){
             System.out.println(ex);
            }

            try
            {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   	    con=DriverManager.getConnection("jdbc:odbc:bookstore","","");
		   	   	    s1=con.createStatement();

			}
            catch(Exception e)
			{
			 System.out.println(e);
            }
            rfrm=new JFrame("Reports");
            astock= new JPanel();
            astock.setLayout(null);
            pnbill= new JPanel();
            pnbill.setLayout(null);
            JTabbedPane jtp = new JTabbedPane();
            jtp.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            jtp.addTab("Stock Dtails",astock);
            jtp.addTab("Pending Bills",pnbill);
            c1=rfrm.getContentPane();
            c1.setLayout(null);
            jtp.setBounds(190,100,650,500);
            c1.add(jtp);

            rfrm.setExtendedState(JFrame.MAXIMIZED_BOTH);
            rfrm.setSize(1024,768);
            rfrm.setVisible(true);
            rfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            f2=new Font("Times New Roman",Font.ITALIC,25);
		    f3=new Font("Times New Roman",Font.BOLD,15);

		    mig=new ImageIcon("images\\b1.jpg");

		    ldisp = new JLabel("!STOCK DETAILS!");
		    ldisp.setFont(f2);
		    ldisp.setForeground(Color.red);
		    ldisp.setBounds(200,7,300,35);

            JLabel lborder=new JLabel(mig);
		    lborder.setBounds(0,40,650,20);

            JLabel lborder1=new JLabel(mig);
		    lborder1.setBounds(0,300,650,150);

		    lid=new JLabel("ID");
		    lid.setFont(f3);
		    lid.setBounds(300,220,120,20);
		    lname=new JLabel(" Item Name");
		    lname.setFont(f3);
		    lname.setBounds(100,190,150,20);
		    lavailable=new JLabel("Available Stock");
		    lavailable.setFont(f3);
		    lavailable.setBounds(300,250,120,20);


		        bg1=new ButtonGroup();

                r1=new JRadioButton("For Book");
                r1.setBounds(150,130,70,25);
		        r2=new JRadioButton("For NoteBook");
		        r2.setBounds(250,130,100,25);
		        r3=new JRadioButton("For Stationary");
		        r3.setBounds(350,130,120,25);
                bg1.add(r1);
		        bg1.add(r2);
		        bg1.add(r3);
                astock.add(r1);
		        astock.add(r2);
		        astock.add(r3);
		        r1.addActionListener(this);
                r2.addActionListener(this);
                r3.addActionListener(this);

            id=new JTextField();
            id.setBounds(430,220,70,20);
            id.setEditable(false);

            available=new JTextField();
            available.setForeground(Color.red);
            available.setBounds(430,250,70,20);
            available.setEditable(false);

            itemname=new List();
            itemname.setBounds(80,220,160,80);
            itemname.addMouseListener(this);

            hb=new JButton("HOME");
            hb.setBounds(280,410,90,25);
            hb.addActionListener(this);

            astock.add(ldisp);
            astock.add(lborder);
            astock.add(lid); astock.add(id);
            astock.add(lname);astock.add(itemname);
            astock.add(lavailable); astock.add(available);astock.add(lborder1);
            astock.add(hb);
            astock.repaint();

        /*------------------on Pending Bill---------------------------*/

        ldisp = new JLabel("!PENDING BILLS!");
		ldisp.setFont(f2);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(225,7,500,35);

        lbillno = new JLabel("Bill No :-");
        lbillno.setFont(f3);
        lbillno.setBounds(400,70,90,20);
        lbno = new JLabel("");
        lbno.setFont(f3);
        lbno.setBounds(470,70,100,20);
        ldate = new JLabel("Date :-");
        ldate.setFont(f3);
        ldate.setBounds(400,100,90,20);
        ld = new JLabel("");
        ld.setFont(f3);
        ld.setBounds(470,100,90,20);
        lbcustn = new JLabel("Customer Name");
        lbcustn.setBounds(100,130,150,20);
        lbcustn.setFont(f3);
        lcphno=new JLabel("Phone/Mob No:");
        lcphno.setFont(f3);
        lcphno.setBounds(70,250,120,20);
        lbpaid = new JLabel("Paid :-");
        lbpaid.setFont(f3);
        lbpaid.setBounds(300,160,80,20);
        lbbal = new JLabel("Balance :-");
        lbbal.setFont(f3);
        lbbal.setBounds(300,190,80,20);
        lbTot = new JLabel("Total :-");
        lbTot.setFont(f3);
        lbTot.setBounds(300,230,80,20);

        JLabel lborder2=new JLabel(mig);
        lborder2.setBounds(0,40,650,20);
        JLabel lborder3=new JLabel(mig);
		lborder3.setBounds(0,300,650,150);

        cname=new JList();
        sp = new JScrollPane(cname);
        sp.setBounds(80,160,160,70);
        cname.addMouseListener(this);

        s11 = new String[100];

        try{
            int i=0;
            rs1 = s1.executeQuery("select * from sbill");
                while(rs1.next()){
                    if(rs1.getString(8).equals("Yes")){
                            s11[i]=rs1.getString(3);
                            i++;
                    }
                }
                cname.setListData(s11);
        }
        catch(Exception ex){
              System.out.println(ex);
        }

        cphno=new JTextField();
        cphno.setBounds(180,250,80,20);
        txtpaid = new JTextField();
        txtpaid.setBounds(390,160,100,20);
        txtpaid.setEditable(false);
        txtbal = new JTextField();
        txtbal.setBounds(390,190,100,20);
        txtbal.setEditable(false);
        lline = new JLabel("_____________________");
        lline.setBounds(380,205,200,20);
        txtTot = new JTextField();
        txtTot.setEditable(false);
        txtTot.setBounds(390,230,100,20);
        btnRec = new JButton("Recieved");
        btnRec.setBounds(350,320,100,25);
        btnhome=new JButton("HOME");
        btnhome.setBounds(280,410,90,25);
        btnhome.addActionListener(this);

        pnbill.add(ldisp);pnbill.add(lborder2);
        pnbill.add(lbillno);pnbill.add(lbno);
        pnbill.add(ldate);pnbill.add(ld);
        pnbill.add(lbcustn);pnbill.add(sp);
        pnbill.add(lcphno);pnbill.add(cphno);
        pnbill.add(lbpaid);pnbill.add(txtpaid);
        pnbill.add(lbbal);pnbill.add(txtbal);pnbill.add(lline);
        pnbill.add(lbTot);pnbill.add(txtTot);

        //pnbill.add(btnRec);
        pnbill.add(lborder3);
        pnbill.add(btnhome);

        btnRec.addActionListener(this);

        }

         public void mouseClicked(MouseEvent e)
        {
               Object obj=e.getSource();

               if(obj==itemname){
                         rs1=null;
                         try{
                     rs1 = s1.executeQuery("select * from bookdetails");
                     while(rs1.next()){
                         String s = String.valueOf(itemname.getSelectedItem());
                      if(s.equals(rs1.getString(2)))
                      {
                         id.setText(rs1.getString(1));
                         available.setText(rs1.getString(7));
                      }
                     }
                     rs1.close();
                }
                catch(Exception ex){
                    System.out.println(ex);
                    }
               }
               if(obj==itemname)
                  {
                   try{
                     rs1 = s1.executeQuery("select * from NoteBookDetails");
                     while(rs1.next()){
                         String s = String.valueOf(itemname.getSelectedItem());
                      if(s.equals(rs1.getString(2)))
                      {
                         id.setText(rs1.getString(1));
                         available.setText(rs1.getString(9));
                      }
                     }
                     rs1.close();
                }
                catch(Exception ex){
                    System.out.println(ex);
                    }
              }

              if(obj==itemname)
                  {
                   try{
                     rs1 = s1.executeQuery("select * from StationaryDetails");
                     while(rs1.next()){
                         String s = String.valueOf(itemname.getSelectedItem());
                      if(s.equals(rs1.getString(2)))
                      {
                         id.setText(rs1.getString(1));
                         available.setText(rs1.getString(6));
                      }
                     }
                     rs1.close();
                }
                catch(Exception ex){
                    System.out.println(ex);
                    }
              }

               if(obj==cname){
                   try{
                         rs1 = s1.executeQuery("select * from sbill");
                             while(rs1.next()){
                             String s = String.valueOf(cname.getSelectedValue());
                             if(s.equals(rs1.getString(3)))
                             {
                               lbno.setText(rs1.getString(1));
                               ld.setText(rs1.getString(2));
                               cphno.setText(rs1.getString(4));
                               txtpaid.setText(rs1.getString(6));
                               txtbal.setText(rs1.getString(7));
                               txtTot.setText(rs1.getString(5));

                               }
                            }
                        rs1.close();
                        }
                catch(Exception ex){
                    System.out.println(ex);
                    }
               }
         }

        public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();
              if(obj==btnRec){
                  try{
                       String b="0";
                       String n="No";
                       String q = "UPDATE sbill SET paid='"+txtTot.getText()+"',"+
                                  "bal='"+b+"',"+
                                  "bpand='"+n+"'"+
                                  "WHERE BillNo='"+lbno.getText()+"'";
                                  System.out.println(q);
                                  int a=s1.executeUpdate(q);
                                  System.out.println(a);
                    }
                    catch(Exception ex){System.out.println(ex);}
              }
               if(obj == r1){
                    try{
                        rs1 = s1.executeQuery("select * from bookdetails");
                        id.setText("");
                        available.setText("");
                        itemname.removeAll();
                        while(rs1.next())
                        {
                            itemname.add(rs1.getString(2));
                        }
                         rs1.close();
                    }
                    catch(Exception ex){System.out.println(ex);}
                  }

                if(obj == r2){
                    try{
                            rs1 = s1.executeQuery("select * from NoteBookDetails");
                            id.setText("");
                            available.setText("");
                            itemname.removeAll();
                        while(rs1.next())
                        {
                            itemname.add(rs1.getString(2));
                        }
                         rs1.close();
                    }
                    catch(Exception ex){System.out.println(ex);}
                  }

                  if(obj == r3){
                     try{
                         rs1 = s1.executeQuery("select * from StationaryDetails");
                         id.setText("");
                         available.setText("");
                         itemname.removeAll();
                         while(rs1.next())
                        {
                            itemname.add(rs1.getString(2));
                        }
                         rs1.close();
                    }
                    catch(Exception ex){System.out.println(ex);}
                  }
                  if(obj==hb)
                  {
                        rfrm.dispose();
                        newmain1 m1=new newmain1();
                  }
                  if(obj==btnhome)
                  {
                        rfrm.dispose();
                        newmain1 m1=new newmain1();
                  }
       }
}