/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author harsh
 */
public class Nmap extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    // Instance variable
    
    Container c;
    JMenuBar menubar;
    JMenu menu[]=new JMenu[4];
    JTextField t[]=new JTextField[3];
    public static JTextArea ta;
    JButton b[]=new JButton[4];
    JLabel l[]=new JLabel[5];
    JPanel p[]=new JPanel[5];
    
    Nmap(){
        setTitle("Nmap Reconisance tool");
        setSize(1400,800);
        setLocationRelativeTo(null);
        
        c=this.getContentPane();
        c.setBackground(Color.WHITE);
        
        setLayout(new BorderLayout());
        
        menubar=new JMenuBar();
        menubar.setBackground(Color.GRAY);
        
        
        String[] menu_name={"Scan","Tool","Profile","Help"};
        for(int i=0;i<menu_name.length;i++){
            menu[i]=new JMenu(menu_name[i]);
            menu[i].setFont(new Font("Arial",Font.ITALIC,20));
            menu[i].setForeground(Color.WHITE);
            menu[i].setBorder(BorderFactory.createLineBorder(Color.GREEN,1));
            menubar.add(menu[i]);
        }
        
        //String[][] menu_item={{"New Window","Open Scan","Open Scan in this window","Save"}};
        JMenuItem new_window=new JMenuItem("New Window");
        new_window.setFont(new Font("Arial",Font.ITALIC,20));
     
        JMenuItem open_scan=new JMenuItem("Open Scan");
        open_scan.setFont(new Font("Arial",Font.ITALIC,20));
        
        JMenuItem open_scan_this=new JMenuItem("Open Scan in this window");
        open_scan_this.setFont(new Font("Arial",Font.ITALIC,20));
        
        JMenuItem save_scan=new JMenuItem("save scan");
        save_scan.setFont(new Font("Arial",Font.ITALIC,20));
        
        JMenuItem save_scan_dir=new JMenuItem("save all scan to directory");
        save_scan_dir.setFont(new Font("Arial",Font.ITALIC,20));
        
        JMenuItem exit=new JMenuItem("exit");
        exit.setFont(new Font("Arial",Font.ITALIC,20));
        
        menu[0].add(new_window);
        menu[0].add(new_window);
        menu[0].add(open_scan);
        menu[0].add(open_scan_this);
        menu[0].add(save_scan);
        menu[0].add(save_scan_dir);
        menu[0].add(exit);
        
        setJMenuBar(menubar);
        
        p[0]=new JPanel();
        p[0].setLayout(null);
        p[0].setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        
        l[0]=new JLabel("Target:");
        l[0].setBounds(10,10,70,30);
        l[0].setFont(new Font("Arial",Font.ITALIC,20));
        p[0].add(l[0]);
        
        t[0]=new JTextField(10);
        t[0].setBounds(84,10,470,30);
        p[0].setBackground(Color.WHITE);
        p[0].add(t[0]);
        p[0].setPreferredSize(new Dimension(this.getWidth(),40));
        t[0].setBackground(Color.YELLOW);
        
        l[1]=new JLabel("Profile:");
        l[1].setBounds(567,10,70,30);
        l[1].setFont(new Font("Arial",Font.ITALIC,20));
        p[0].add(l[1]);
        
        t[1]=new JTextField(10);
        t[1].setBounds(640,10,470,30);
        p[0].setPreferredSize(new Dimension(this.getWidth(),60));
        t[1].setBackground(Color.YELLOW);
        t[1].setOpaque(true);
        p[0].add(t[1]);
        
        b[0]=new JButton("Scan");
        b[0].setBounds(1120, 10, 100, 30);
        b[0].setFont(new Font("Arial", Font.ITALIC, 17));  // Set font
        b[0].setForeground(Color.BLACK);  // Set font color
        p[0].add(b[0]);
        b[0].addActionListener((ActionEvent e)->{
            
            new Thread(()->{
        
                String text=t[2].getText();
                String command[]=text.split(" ");
                NmapImplementation.info(command);
            }).start();
        });
        
        b[1]=new JButton("Cancel");
        b[1].setBounds(1240, 10, 100, 30);
        b[1].setFont(new Font("Arial", Font.ITALIC, 17));  // Set font
        b[1].setForeground(Color.BLACK);  // Set font color
        p[0].add(b[1]);
        
        l[2]=new JLabel("Command:");
        l[2].setBounds(10,45,100,30);
        l[2].setFont(new Font("Arial",Font.ITALIC,20));
        p[0].add(l[2]);
        
        t[2]=new JTextField(10);
        t[2].setBounds(118,45,1250,30);
        t[2].setText("nmap -T4 -O -A ");
        t[2].setFont(new Font("Arial",Font.ITALIC,20));
        t[2].setBackground(Color.YELLOW);
        p[0].add(t[2]);
        
        p[0].setBackground(Color.WHITE);
        p[0].setPreferredSize(new Dimension(this.getWidth(),100));
        add(p[0],BorderLayout.NORTH);
        
        p[1]=new JPanel();
        p[1].setPreferredSize(new Dimension(250,this.getHeight()-200));
        add(p[1],BorderLayout.WEST);
        p[1].setBackground(Color.WHITE);
        p[1].setBorder(BorderFactory.createLineBorder(Color.YELLOW,4));
        p[1].setLayout(null);
        
        b[2]=new JButton("Host");
        b[2].setBounds(10, 10, 100, 30);
        b[2].setFont(new Font("Arial", Font.ITALIC, 17));  // Set font
        b[2].setForeground(Color.BLACK);  // Set font color
        p[1].add(b[2]);
        
        b[3]=new JButton("Services");
        b[3].setBounds(130, 10, 100, 30);
        b[3].setFont(new Font("Arial", Font.ITALIC, 17));  // Set font
        b[3].setForeground(Color.BLACK);  // Set font color
        p[1].add(b[3]);
        
        p[2]=new JPanel();
        p[2].setPreferredSize(new Dimension(this.getWidth()-280,this.getHeight()-80));
        add(p[2],BorderLayout.CENTER);
        p[2].setBackground(Color.RED);
        p[2].setBorder(BorderFactory.createLineBorder(Color.YELLOW,4));
        p[2].setLayout(null);
        
        ta=new JTextArea();
        ta.setFont(new Font("Arial",Font.ITALIC,20));
        ta.setBounds(10,10,1120,610);
        ta.setBackground(Color.YELLOW);
        ta.setOpaque(true);
        JScrollPane scrollpane=new JScrollPane(ta);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p[2].add(ta);
        p[2].add(scrollpane);
        
        
        Thread thread=new Thread(()->{
            for(int i=0;i<b.length;i++){
                try{
                    t[i].setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
                    l[i].setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
                    
                }catch(Exception e){
                    
                }
                try{
                    b[i].setBackground(Color.BLUE);
                    b[i].setForeground(Color.WHITE);
                    b[i].setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
                }catch(Exception e){
                }
            }
        });
        thread.start();
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }   
    public static void main(String[] args) {
        // TODO code application logic here
        new Nmap();
    }
    
}
