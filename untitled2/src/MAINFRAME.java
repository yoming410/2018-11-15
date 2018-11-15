import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class MAINFRAME extends JFrame {
    private Container cp;
    private JLabel jlb1=new JLabel();
//    private JLabel jlb2=new JLabel();
//    private JLabel jlb3=new JLabel();
    private  Timer t1;
    private ImageIcon imgplan =new ImageIcon("1.png");
    private ImageIcon imgpocket=new ImageIcon("2.png");
    private ImageIcon imgplan1=new ImageIcon("1-1.png");
    private int dirFlag = 1 , objx = 0 , objy = 0 , objw = 220 , objh = 230 ;
    public MAINFRAME() {
        init();
    }
    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50,50,1000,800);
        cp=this.getContentPane();
        cp.setLayout(null);

        Image img=imgplan1.getImage();
        Image img2=img.getScaledInstance(210,135,Image.SCALE_AREA_AVERAGING);
        imgplan1.setImage(img2);
        jlb3.setIcon(imgplan1);

        Image img1=imgplan.getImage();
        Image img3=img1.getScaledInstance(210,135,Image.SCALE_AREA_AVERAGING);
        imgplan.setImage(img3);
        jlb1.setIcon(imgplan);

        Image img4=imgpocket.getImage();
        Image img5=img4.getScaledInstance(30,50,Image.SCALE_AREA_AVERAGING);
        jlb2.setIcon(imgpocket);
        imgpocket.setImage(img5);

        jlb1.setBounds(350,550,269,187);
        cp.add(jlb1);
        t1=new Timer(50, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jlb2.setLocation(jlb2.getX(),jlb2.getY()-5);
                if (jlb2.getY()<0){
                    t1.stop();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getExtendedKeyCode());
                switch (e.getKeyCode()){
                    case 37:
                        jlb1.setIcon(imgplan);
                        jlb1.setLocation(jlb1.getX()-5,jlb1.getY());
                        break;
                    case 39:
                        jlb1.setIcon(imgplan1);
                        jlb1.setLocation(jlb1.getX()+5,jlb1.getY());
                        break;
                    case 32:
                        jlb2.setBounds(jlb1.getX()+50,jlb1.getY(),30,60);
                        cp.add(jlb2);
                        t1.start();
                        break;
                }

            }
        });
    }
}