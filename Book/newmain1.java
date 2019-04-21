import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;

class newmain1 extends MouseAdapter implements ActionListener
{
      Container c1;
      JFrame fm;
      JPanel pm;
      JLabel l10,l11;
      JLabel lstock,lbil,ldist;
      JButton btnAbout;
	  JButton bstock,bsbil,bpbil,bdist,bexit,border;
      Icon mig,mig2,mig1,mign;
      Font f1,f2,f3,f4;
      Window w;
      JPanel p;
      JLabel lbla;
      JOptionPane optDialog;

       public static void main(String args[])
       {
 	          newmain1 m1=new newmain1();
       }

      newmain1()
      {
          try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception ex)
            {
               System.out.println(ex);
            }

            fm=new JFrame("Main Window");
            pm=new JPanel();
            pm.setLayout(null);
            pm.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
            pm.setBounds(190,100,650,500);

            	f1=new Font("Times New Roman",Font.BOLD,35);
		        f2=new Font("Times New Roman",Font.ITALIC,25);
		        f3=new Font("Times New Roman",Font.ITALIC,15);

        mig=new ImageIcon("images\\b1.jpg");
        JLabel lborder=new JLabel(mig);
		lborder.setBounds(0,300,650,150);

        mig2=new ImageIcon("images\\nlabel.png");
        l10=new JLabel(mig2);
        l10.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        l10.setBounds(80,10,500,90);

        mig1=new ImageIcon("images\\book.jpg");
        l11=new JLabel(mig1);
        l11.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        l11.setBounds(75,140,200,200);

        JLabel lborder1=new JLabel(mig);
		lborder1.setBounds(0,100,650,20);

        bstock=new JButton("",new ImageIcon("images\\add.png"));
        bstock.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
        bstock.setBounds(350,120,220,44);

		bdist=new JButton("",new ImageIcon("images\\newdist.png"));
		bdist.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
		bdist.setBounds(350,170,220,44);

        bsbil=new JButton("",new ImageIcon("images\\newsale.png"));
        bsbil.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
		bsbil.setBounds(350,220,220,44);

		bpbil=new JButton("",new ImageIcon("images\\newpur.png"));
		bpbil.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
		bpbil.setBounds(350,270,220,44);

        border=new JButton("",new ImageIcon("images\\report.png"));
		border.setBorder( new LineBorder(new Color(100, 100, 200), 2, true));
		border.setBounds(350,320,220,44);

		bexit=new JButton("",new ImageIcon("images\\exit.png"));
		bexit.setBounds(290,410,90,50);

		btnAbout = new JButton("DEVELOPER");
		//btnAbout.setFont(f3);
        btnAbout.setBounds(535,460,100,25);
        btnAbout.addActionListener(this);

		bstock.addActionListener(this);
        bsbil.addActionListener(this);
        bdist.addActionListener(this);
        bpbil.addActionListener(this);
        border.addActionListener(this);
		bexit.addActionListener(this);

		pm.add(l10);pm.add(l11);
        pm.add(lborder1);
        pm.add(bstock);pm.add(bdist);pm.add(bsbil);pm.add(bpbil);pm.add(border);
        pm.add(lborder);
        pm.add(btnAbout);
        pm.add(bexit);

            c1=fm.getContentPane();
            c1.setLayout(null);
            c1.add(pm,"Center");

            fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fm.setSize(1024,768);
            fm.setVisible(true);
            fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
   public void mouseClicked(MouseEvent me)
   {
          Object ob = me.getSource();
          if(ob==w)
          {
             abClose();
          }
   }
   public void abClose()
   {
          w.dispose();
   }
   public void actionPerformed(ActionEvent e1)
       {
              Object obj=e1.getSource();
              if(obj==btnAbout){
                    w=new Window(fm);

                    p = new JPanel();
                    p.setLayout(null);
                    mign=new ImageIcon("images\\About1.jpg");
                    JLabel lbla=new JLabel(mign);
                    lbla.setBounds(10,9,512,384);
                    p.add(lbla);
                    w.add(p);

                    w.setSize(530,400);
                    p.setBackground(Color.pink);
                    w.setLocation(260,180);
                    w.setVisible(true);
                    w.addMouseListener(this);
              }
              if(obj==bstock)
              {
                  fm.dispose();
                 Booktabpan book1=new Booktabpan();

               }
                if(obj==bsbil)
              {
                  fm.dispose();
                  bill1 bill=new bill1();

               }
               if(obj==bdist)
              {
                  fm.dispose();
                 dist dist1=new dist();

               }
               if(obj==bpbil)
               {
                    fm.dispose();
                    pbill p1=new pbill();
               }
               if(obj==border)
               {
                    fm.dispose();
                    report1 r1=new report1();
               }
              if(obj==bexit)
              {
                 exitframe();
			     return;
              }
      }
      public void exitframe()
      {

		int i = optDialog.showConfirmDialog(fm,"Do you want to Exit?","Exit?",JOptionPane.YES_NO_OPTION);

            if( i == JOptionPane.YES_OPTION)
            {
				System.exit(0);
			}
			else
            {
				return;
			}
	 }

}