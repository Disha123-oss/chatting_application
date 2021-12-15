package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Server extends JFrame implements ActionListener{
    JPanel p1;
    JTextField tf1;
    JButton b1;
    static JTextArea ta1;
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
        
    Server(){
        p1=new JPanel();
        
        
        p1.setLayout(null);
        p1.setBounds(0, 0, 350, 50);
        p1.setBackground(new Color(7,94,84));
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("chatting\\application\\icons\\3.png"));
        Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(5,10,30,30);
        p1.add(l1);
        
        l1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent es){
                System.exit(0);
            }
        });
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("chatting\\application\\icons\\131-modified.png"));
        Image i5=i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l2=new JLabel(i6);
        l2.setBounds(40,0,50,50);
        p1.add(l2);
        
        JLabel l3=new JLabel("swagata dutta");
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        l3.setForeground(Color.WHITE);
        l3.setBounds(100, 5, 150, 20);
        p1.add(l3);
        
        JLabel l6=new JLabel("Active now");
        l6.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l6.setForeground(Color.WHITE);
        l6.setBounds(100, 25, 150, 15);
        p1.add(l6);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("chatting\\application\\icons\\phone.png"));
        Image i8=i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel l4=new JLabel(i9);
        l4.setBounds(240,10,30,30);
        p1.add(l4);
        
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("chatting\\application\\icons\\video.png"));
        Image i11=i10.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i12=new ImageIcon(i11);
        JLabel l5=new JLabel(i12);
        l5.setBounds(280,10,30,30);
        p1.add(l5);
        
        ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("chatting\\application\\icons\\3icon.png"));
        Image i14=i13.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT);
        ImageIcon i15=new ImageIcon(i14);
        JLabel l7=new JLabel(i15);
        l7.setBounds(320,10,10,25);
        p1.add(l7);
        
        ta1=new JTextArea();
        ta1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        ta1.setForeground(Color.BLACK);
        ta1.setBackground(Color.WHITE);
        ta1.setBounds(5, 55, 340, 390);
        ta1.setEditable(false);
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
        add(ta1);
        
        tf1=new JTextField();
        tf1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        tf1.setForeground(Color.black);
        tf1.setBounds(5, 450, 250, 30);
        add(tf1);
        
        b1=new JButton("SEND");
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(7,94,84));
        b1.setBounds(255, 450, 110, 30);
        b1.addActionListener(this);
        add(b1);
        
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(350,500);
        setLocation(200,100);
        
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      try{
        String text=tf1.getText();
        ta1.setText(ta1.getText()+"\n\t\t\t"+text);
        dout.writeUTF(text);
        tf1.setText("");
      }catch(Exception e){
          
      }
    }
    
    public static void main(String[] args){
        new Server();
        
        String msg="";
        try{
            skt = new ServerSocket(6001);
            s = skt.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            msg = din.readUTF();
            ta1.setText(ta1.getText()+"\n"+msg);
        }catch(Exception e){
            
        }
    }
}
