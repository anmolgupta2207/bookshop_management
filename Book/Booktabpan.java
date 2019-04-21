
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

class Booktabpan extends JFrame implements ActionListener
{
    Container c1;
    JFrame sfrm;
    JPanel pbook;
    JPanel pnbook;
    JPanel pstat;
    Icon mig;
    Font f1,f2,f3,f4;
    String ch;
    String str;
    JLabel ldisp,lsubmitr1;

    PreparedStatement stat;
    ResultSet rs1;
    Statement s1;
    Connection con;

    //PreparedStatement ps3;
    /*----------------for book details-----------------------*/
    JTextField bookname,bookid,bauther,bpubl,bscost,bpcost,bquantity;
	JButton ab,eb,sb,cb,hb;
	/*----------------for notebook details-----------------------*/
     JTextField nbookname,nbookid,nbtype,nbscost,nbpcost,nbquantity;
	JComboBox nbpagesjcb,nbsizejcb,nbcomjcb;
	JButton ab1,eb1,sb1,cb1,hb1;
	 /*----------------for stationary details-----------------------*/
	JTextField stname,stid,stscost,stmanuf,stpcost,stquantity;
	JButton ab2,eb2,sb2,cb2,hb2;



    public static void main(String args[])
    {
 	       Booktabpan book1=new Booktabpan();
    }

    Booktabpan(){
         try{
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              con=DriverManager.getConnection("jdbc:odbc:bookstore");
            }
        catch(Exception ex){
             System.out.println(ex);
            }
            sfrm=new JFrame("Stock Details");
            pbook= new JPanel();
            pbook.setLayout(null);
            pnbook= new JPanel();
            pnbook.setLayout(null);
            pstat= new JPanel();
            pstat.setLayout(null);
            JTabbedPane jtp = new JTabbedPane();
            jtp.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            jtp.addTab("Book Details",pbook);
            jtp.addTab("NoteBook Details",pnbook);
            jtp.addTab("Stationary Details",pstat);
            c1=sfrm.getContentPane();
            c1.setLayout(null);
            jtp.setBounds(190,100,650,500);
            c1.add(jtp);


		    f1=new Font("Times New Roman",Font.BOLD,35);
		    f2=new Font("Times New Roman",Font.ITALIC,25);
		    f3=new Font("Times New Roman",Font.BOLD,15);

		    mig=new ImageIcon("images\\b1.jpg");

            /*-----------------------Book details start-----------------*/
            ldisp = new JLabel("!BOOK DETAILS!");
		    ldisp.setFont(f1);
		    ldisp.setForeground(Color.red);
		    ldisp.setBounds(200,7,300,35);

            JLabel lborder1=new JLabel(mig);
		    lborder1.setBounds(0,40,650,20);

		    lsubmitr1=new JLabel("Book Record ");
		    lsubmitr1.setFont(f2);
		    lsubmitr1.setForeground(Color.blue);
		    lsubmitr1.setBounds(260,60,450,20);

            JLabel lbookid= new JLabel("Book ID ");
		    lbookid.setFont(f3);
		    lbookid.setBounds(150,100,120,20);
            JLabel lbookname =new JLabel("Book Name");
            lbookname.setFont(f3);
		    lbookname.setBounds(150,130,120,20);
		    JLabel lauther= new JLabel("Book Auther");
		    lauther.setFont(f3);
		    lauther.setBounds(150,160,120,20);
		    JLabel lpubl= new JLabel("Publication");
		    lpubl.setFont(f3);
		    lpubl.setBounds(150,190,100,20);
		    JLabel lscost  = new JLabel("Book Sale Cost");
		    lscost.setFont(f3);
		    lscost.setBounds(150,220,150,20);
		    JLabel lpcost= new JLabel("Book Purchase Cost");
		    lpcost.setFont(f3);
		    lpcost.setBounds(150,250,150,20);
	        JLabel lbquantity =new JLabel("Quantity");
		    lbquantity.setFont(f3);
		    lbquantity.setBounds(150,280,150,20);

            JLabel lborder=new JLabel(mig);
            lborder.setBounds(0,280,650,150);

            bookid = new JTextField();
		    bookid.setBounds(300,100,50,20);
		    bookname= new JTextField();
		    bookname.setBounds(300,130,200,20);
		    bauther= new JTextField();
		    bauther.setBounds(300,160,150,20);
		    bpubl= new JTextField();
		    bpubl.setBounds(300,190,150,20);
		    bscost= new JTextField();
		    bscost.setBounds(300,220,50,20);
		    bpcost= new JTextField();
		    bpcost.setBounds(300,250,50,20);
		    bquantity= new JTextField();
		    bquantity.setBounds(300,280,50,20);

            ab=new JButton("ADD");
            ab.setBounds(80,400,90,25);
            ab.addActionListener(this);
		    eb=new JButton("UPDATE");
		    eb.setBounds(180,400,90,25);
		    eb.addActionListener(this);
		    sb=new JButton("SEARCH");
		    sb.setBounds(280,400,90,25);
		    sb.addActionListener(this);
		    cb=new JButton("CLEAR");
		    cb.setBounds(380,400,90,25);
		    cb.addActionListener(this);
		    hb=new JButton("HOME");
		    hb.setBounds(480,400,90,25);
		    hb.addActionListener(this);


            pbook.add(ldisp);pbook.add(lborder1);pbook.add(lsubmitr1);
            pbook.add(lbookid);pbook.add(bookid);
		    pbook.add(lbookname); pbook.add(bookname);
            pbook.add(lauther);pbook.add(bauther);
		    pbook.add(lpubl);pbook.add(bpubl);
            pbook.add(lscost); pbook.add(bscost);
            pbook.add(lpcost); pbook.add(bpcost);
            pbook.add(lbquantity);pbook.add(bquantity); pbook.add(lborder);

            pbook.add(ab);pbook.add(eb);
            pbook.add(sb);pbook.add(cb);pbook.add(hb);

          /*---------------------Note book Details start------------------*/
        ldisp = new JLabel("!NOTEBOOK DETAILS!");
		ldisp.setFont(f1);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(150,7,500,35);

        JLabel lborder2=new JLabel(mig);
        lborder2.setBounds(0,40,650,20);

		lsubmitr1=new JLabel("NoteBook Record");
		lsubmitr1.setFont(f2);
		lsubmitr1.setForeground(Color.magenta);
		lsubmitr1.setBounds(250,60,450,20);
		JLabel lnbookid= new JLabel("NoteBook ID");
		lnbookid.setFont(f3);
		lnbookid.setBounds(150,100,120,20);
        JLabel lnbookname =new JLabel("NoteBook Name");
        lnbookname.setFont(f3);
		lnbookname.setBounds(150,130,120,20);
		JLabel lnbcompany= new JLabel("Company");
		lnbcompany.setFont(f3);
		lnbcompany.setBounds(150,160,100,20);
		JLabel lnbsize  = new JLabel("NoteBook Size");
		lnbsize.setFont(f3);
		lnbsize.setBounds(150,190,150,20);
		JLabel lnbtype= new JLabel("NoteBook Type");
		lnbtype.setFont(f3);
		lnbtype.setBounds(150,220,150,20);
		JLabel lnbpages= new JLabel("Pages");
		lnbpages.setFont(f3);
		lnbpages.setBounds(150,250,150,20);
		JLabel lnbscost =new JLabel("Sale Cost");
		lnbscost.setFont(f3);
		lnbscost.setBounds(150,280,150,20);
		JLabel lnbpcost =new JLabel("Purchase Cost");
		lnbpcost.setFont(f3);
		lnbpcost.setBounds(380,280,100,20);
		JLabel lnbquantity =new JLabel("Quantity");
		lnbquantity.setFont(f3);
		lnbquantity.setBounds(150,310,150,20);

        nbookid = new JTextField();
		nbookid.setBounds(300,100,50,20);
		nbookname= new JTextField();
		nbookname.setBounds(300,130,200,20);
		nbcomjcb = new JComboBox();
                 nbcomjcb.addItem(" Jyoti");
                 nbcomjcb.addItem(" Sundaram");
                 nbcomjcb.addItem(" Shree");
                 nbcomjcb.addItem(" Navneet");
                 nbcomjcb.addItem(" ClassMate");
                 nbcomjcb.addItem(" Gemini");

        nbcomjcb.setBounds(300,160,100,20);
        nbsizejcb = new JComboBox();
                  nbsizejcb.addItem(" A1");
                  nbsizejcb.addItem(" A2");
                  nbsizejcb.addItem(" A3");
                  nbsizejcb.addItem(" A4");
        nbsizejcb.setBounds(300,190,50,20);
		nbtype= new JTextField();
		nbtype.setBounds(300,220,150,20);
		String pages[]={"100","200","300","400"};
        nbpagesjcb = new JComboBox(pages);
        nbpagesjcb.setBounds(300,250,50,20);
		nbscost= new JTextField();
		nbscost.setBounds(300,280,50,20);
		nbpcost= new JTextField();
		nbpcost.setBounds(500,280,50,20);
		nbquantity= new JTextField();
		nbquantity.setBounds(300,310,50,20);

        JLabel lborder3=new JLabel(mig);
		lborder3.setBounds(0,280,650,150);

        ab1=new JButton("ADD");
        ab1.setBounds(80,400,90,25);
        ab1.addActionListener(this);
		eb1=new JButton("UPDATE");
		eb1.setBounds(180,400,90,25);
		eb1.addActionListener(this);
		sb1=new JButton("SEARCH");
		sb1.setBounds(280,400,90,25);
		sb1.addActionListener(this);
		cb1=new JButton("CLEAR");
		cb1.setBounds(380,400,90,25);
		cb1.addActionListener(this);
		hb1=new JButton("HOME");
		hb1.setBounds(480,400,90,25);
        hb1.addActionListener(this);

		pnbook.add(ldisp);	pnbook.add(lsubmitr1);

        pnbook.add(lnbookid);pnbook.add(lborder2);pnbook.add(nbookid);
		pnbook.add(lnbookname); pnbook.add(nbookname);
        pnbook.add(lnbcompany); pnbook.add(nbcomjcb);
        pnbook.add(lnbsize);pnbook.add(nbsizejcb);
        pnbook.add(lnbtype); pnbook.add(nbtype);
        pnbook.add(lnbpages); pnbook.add(nbpagesjcb);
        pnbook.add(lnbscost); pnbook.add(nbscost);
        pnbook.add(lnbpcost); pnbook.add(nbpcost);
        pnbook.add(lnbquantity);pnbook.add(nbquantity);pnbook.add(lborder3);

        pnbook.add(ab1); pnbook.add(eb1);
        pnbook.add(sb1);pnbook.add(cb1);pnbook.add(hb1);

         /*-----------------------Stationary details start----------------------*/

         ldisp = new JLabel("!STATIONARY DETAILS!");
		ldisp.setFont(f1);
		ldisp.setForeground(Color.red);
		ldisp.setBounds(140,7,500,35);

        JLabel lborder4=new JLabel(mig);
		lborder4.setBounds(0,40,650,20);

		lsubmitr1=new JLabel("Stationary Record ");
		lsubmitr1.setFont(f2);
		lsubmitr1.setForeground(Color.magenta);
		lsubmitr1.setBounds(250,60,450,25);

        JLabel lstid= new JLabel("Stationary ID ");
		lstid.setFont(f3);
		lstid.setBounds(150,100,120,20);
        JLabel lstname =new JLabel("Stationary Name");
        lstname.setFont(f3);
		lstname.setBounds(150,130,120,20);
		JLabel lstmanuf= new JLabel("Manufacturer");
		lstmanuf.setFont(f3);
		lstmanuf.setBounds(150,160,150,20);
        JLabel lstscost= new JLabel("Sale Cost");
		lstscost.setFont(f3);
		lstscost.setBounds(150,190,120,20);
		JLabel lstpcost= new JLabel("Purchase Cost");
		lstpcost.setFont(f3);
		lstpcost.setBounds(150,220,100,20);
		JLabel lstquantity = new JLabel("Quantity");
		lstquantity.setFont(f3);
		lstquantity.setBounds(150,250,150,20);

	    JLabel lborder5=new JLabel(mig);
        lborder5.setBounds(0,280,650,150);

        stid = new JTextField();
		stid.setBounds(300,100,50,20);
		stname= new JTextField();
		stname.setBounds(300,130,200,20);
		stmanuf= new JTextField();
		stmanuf.setBounds(300,160,75,20);
		stscost= new JTextField();
		stscost.setBounds(300,190,50,20);
		stpcost= new JTextField();
		stpcost.setBounds(300,220,50,20);
		stquantity= new JTextField();
		stquantity.setBounds(300,250,50,20);

        ab2=new JButton("ADD");
        ab2.setBounds(80,400,90,25);
        ab2.addActionListener(this);
		eb2=new JButton("UPDATE");
		eb2.setBounds(180,400,90,25);
		eb2.addActionListener(this);
		sb2=new JButton("SEARCH");
		sb2.setBounds(280,400,90,25);
		sb2.addActionListener(this);
		cb2=new JButton("CLEAR");
		cb2.setBounds(380,400,90,25);
		cb2.addActionListener(this);
		hb2=new JButton("HOME");
		hb2.setBounds(480,400,90,25);
		hb2.addActionListener(this);


		pstat.add(ldisp); pstat.add(lborder4); pstat.add(lsubmitr1);

        pstat.add(lstid);pstat.add(stid);
		pstat.add(lstname); pstat.add(stname);
		pstat.add(lstmanuf);pstat.add(stmanuf);
        pstat.add(lstscost); pstat.add(stscost);
		pstat.add(lstpcost);pstat.add(stpcost);
        pstat.add(lstquantity);pstat.add(stquantity); pstat.add(lborder5);

        pstat.add(ab2); pstat.add(eb2);
        pstat.add(sb2);pstat.add(cb2); pstat.add(hb2);

             sfrm.setExtendedState(JFrame.MAXIMIZED_BOTH);
             sfrm.setSize(1024,768);
             sfrm.setVisible(true);
             sfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      }

    public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();
              /*------------Buttons on Book Details--------------*/
              if(obj==hb)
              {
                 sfrm.dispose();
                 newmain1 m1=new newmain1();
              }
              if(obj==cb)
              {
                  bookname.setText("");
                  bookid.setText("");
                  bauther.setText("");
                  bpubl.setText("");
                  bscost.setText("");
                  bpcost.setText("");
                  bquantity.setText("");
                  ab.setEnabled(true);
                  eb.setEnabled(false);
              }
              if(obj==ab) //book add
              {

				 try
			  	 {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection con=DriverManager.getConnection("jdbc:odbc:bookstore");
			   		Statement s1=con.createStatement();
                    String  ss1=("insert into bookdetails values('"+bookid.getText()+"','"+bookname.getText()+"','" +bauther.getText() + "','" +bpubl.getText()+ "','" +bscost.getText()+ "','" +bpcost.getText() + "','"+bquantity.getText()+ "')");
                    s1.executeUpdate(ss1);
                    String msg= " Book Record Save Successfully";
                    JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);


                    con.close();
                 }
                 catch(Exception ex)
			  	 {
			    		System.out.println(ex);
			    		String msg= "Record of this Id is already present. Please Change The bookid";
                        JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
			   	 }

			 }
			 if(obj==sb) //book search
             {
			      try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore");
			   		   stat = con.prepareStatement("select * from bookdetails where book_id=?");
			   		   stat.setString(1,bookid.getText());
			   		   rs1=stat.executeQuery();
			   		   if(rs1.next())
                        {
                         bookid.setText(rs1.getString(1));
			             bookname.setText(rs1.getString(2));
			             bauther.setText(rs1.getString(3));
			             bpubl.setText(rs1.getString(4));
			             bscost.setText(rs1.getString(5));
			             bpcost.setText(rs1.getString(6));
			             bquantity.setText(rs1.getString(7));

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
               if(obj==eb) //book update
              {
                   try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore","","");
                       s1 = con.createStatement();
                       String q = "update bookdetails set book_name='"+bookname.getText()+"',auther='" +bauther.getText()+ "',publication='" +bpubl.getText()+ "',sale_cost='" +bscost.getText()+ "',purchase_cost='" +bpcost.getText() + "',quantity='"+bquantity.getText()+ "'where book_id='" +bookid.getText() + "'";
                       s1.executeUpdate(q);
                       System.out.println(q);
                       String msg= " Book Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

              }

		      /*------------Buttons on NoteBook Details--------------*/
              if(obj==hb1)
              {
                 sfrm.dispose();
                 newmain1 m1=new newmain1();
              }
              if(obj==cb1)
              {
                  nbookname.setText("");
                  nbookid.setText("");
                  nbscost.setText("");
                  nbpcost.setText("");
                  nbtype.setText("");
                  nbquantity.setText("");
                  ab1.setEnabled(true);
                  eb1.setEnabled(false);
              }
              if(obj==ab1) //notebook add
              {
                    try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore");
			   		   Statement s1=con.createStatement();
			   		   String  ss1=("insert into NoteBookDetails values('"+nbookid.getText()+"','"+nbookname.getText()+"','" +nbcomjcb.getSelectedItem() + "','" +nbsizejcb.getSelectedItem() + "','" +nbtype.getText() + "','" +nbpagesjcb.getSelectedItem() + "','"+nbscost.getText()+"','"+nbpcost.getText()+"','"+nbquantity.getText()+"')");
                       s1.executeUpdate(ss1);
                       String msg= " NoteBook Record Save Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);


                    con.close();

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                        String msg= "Record of this Id is already present. Please Change The nbookid";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                    }

              }
              if(obj==sb1) //notebook search
             {
			      try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore");
			   		   stat = con.prepareStatement("select * from NoteBookDetails where nbookid=?");
			   		   stat.setString(1,nbookid.getText());
			   		   rs1=stat.executeQuery();
			   		   if(rs1.next())
                        {
			   		     nbookid.setText(rs1.getString(1));
			             nbookname.setText(rs1.getString(2));
			             nbcomjcb.setSelectedItem(rs1.getString(3));
			             nbsizejcb.setSelectedItem(rs1.getString(4));
			             nbtype.setText(rs1.getString(5));
			             nbpagesjcb.setSelectedItem(rs1.getString(6));
			             nbscost.setText(rs1.getString(7));
			             nbpcost.setText(rs1.getString(8));
			             nbquantity.setText(rs1.getString(9));

			             eb1.setEnabled(true);
                         ab1.setEnabled(false);
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
                     if(obj==eb1) //NoteBook update
              {
                   try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore","","");
                       s1 = con.createStatement();
                       String q = "update NoteBookDetails set nbookname='"+nbookname.getText()+"',company='" +nbcomjcb.getSelectedItem() + "',size='" +nbsizejcb.getSelectedItem() + "',type='" +nbtype.getText() + "',pages='" +nbpagesjcb.getSelectedItem() + "',nbsale_cost='"+nbscost.getText()+"',nbpurchase_cost='"+nbpcost.getText()+"',quantity='"+nbquantity.getText()+"'where nbookid='" +nbookid.getText() + "'";
                       s1.executeUpdate(q);
                       System.out.println(q);
                       String msg= " NoteBook Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

              }
               /*------------Buttons on Stationary Details--------------*/
              if(obj==hb2)
              {
                 sfrm.dispose();
                 newmain1 m1=new newmain1();
              }
              if(obj==cb2)
              {
                  stname.setText("");
                  stid.setText("");
                  stmanuf.setText("");
                  stscost.setText("");
                  stpcost.setText("");
                  stquantity.setText("");
                  ab2.setEnabled(true);
                  eb2.setEnabled(false);
              }
              if(obj==ab2)  //stationary add
              {
                    try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore");
			   		   Statement s1=con.createStatement();
			   		   String  ss1=("insert into StationaryDetails values('"+stid.getText()+"','"+stname.getText()+"','" +stmanuf.getText() + "','" +stscost.getText() + "','" +stpcost.getText() + "','" +stquantity.getText() +"')");
                       s1.executeUpdate(ss1);
                       String msg= " Stationary Record Save Successfully";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);


                    con.close();

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                        String msg= "Record of this Id is already present. Please Change The stid";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);
                    }

              }
              if(obj==sb2) //stationary search
             {
			      try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore");
			   		   stat = con.prepareStatement("select * from StationaryDetails where stid=?");
			   		   stat.setString(1,stid.getText());
			   		   rs1=stat.executeQuery();
			   		   if(rs1.next())
                          {
			   		       stid.setText(rs1.getString(1));
			               stname.setText(rs1.getString(2));
			               stmanuf.setText(rs1.getString(3));
			               stscost.setText(rs1.getString(4));
			               stpcost.setText(rs1.getString(5));
			               stquantity.setText(rs1.getString(6));

			               eb2.setEnabled(true);
                           ab2.setEnabled(false);
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
              if(obj==eb2) //Stationary update
              {
                   try
                    {
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		   Connection con=DriverManager.getConnection("jdbc:odbc:bookstore","","");
                       s1 = con.createStatement();
                       String q = "update StationaryDetails set stname='"+stname.getText()+"',manufacturar='" +stmanuf.getText() + "',Sale_cost='" +stscost.getText() + "',Purchase_cost='" +stpcost.getText() + "',Quantity='" +stquantity.getText() +"'where stid='" +stid.getText() + "'";
                       s1.executeUpdate(q);
                       System.out.println(q);
                       String msg= " Stationary Record Updated Successfully!!!";
                       JOptionPane.showMessageDialog((Component)null,msg,"bookstore",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

              }

       }
 }