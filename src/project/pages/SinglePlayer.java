/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Hossam_Gamal
 */
public class SinglePlayer extends JFrame {
    JButton back = new JButton();
        JButton play = new JButton();
        JButton help = new JButton();
        JButton users = new JButton();
        JLabel  EnterUserName = new javax.swing.JLabel();
        JLabel img = new JLabel();
        JTextField input=new JTextField();
        
    
    public SinglePlayer(){
            initComponents();
                setLocationRelativeTo(null);
            
    }
 private void   initComponents(){
             setDefaultCloseOperation(EXIT_ON_CLOSE);

//getting img from file 
          ImageIcon gif = new ImageIcon("C:\\Users\\Hossam_Gamal\\Documents\\NetBeansProjects\\Pac-Man\\src\\project\\Assets\\pac.gif");
//set visibility and size of frame 


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 500));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);
        
        
        
//initialization components
        
        
        
//back button 

        back.setFont(new Font("Hobo Std", Font.BOLD, 30));
        back.setText("back");
        back.setBackground(Color.orange); // Set the background color of the button to black
        back.setForeground(Color.black); // Set the font color of the button to green
        this.add(back);
        back.setBounds(110, 250, 150, 40);
        back.setBorderPainted(false); // Disable the border of the button
        back.setFocusPainted(false); // Removes the border when the button is focused
        back.setBounds(80, 400, 210, 50);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        
//play button 
        
        play.setFont(new Font("Hobo Std", Font.BOLD, 30));
        play.setText("Play");
        play.setBackground(Color.orange); // Set the background color of the button to black
        play.setForeground(Color.black); // Set the font color of the button to green
        this.add(play);
        play.setBorderPainted(false); // Disable the border of the button
        play.setFocusPainted(false); // Removes the border when the button is focused
        play.setBounds(300, 400, 250, 50);
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    playActionPerformed(evt);
                } catch (IOException e) {
                }
            }
        });
        
        
        
        
       
           
//ener your user label

        EnterUserName.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        EnterUserName.setForeground(new java.awt.Color(255, 255, 255));
        EnterUserName.setText("Enter User Name");
        this.add(EnterUserName);
        EnterUserName.setBounds(20, 20, 320, 70);
        EnterUserName.setForeground(Color.ORANGE);

                  
//textfield 
       this.add(input);
        input.setBounds(330, 35, 200, 45);
        input.setBackground(Color.ORANGE);
        input.setFont(new Font("Hobo Std", Font.BOLD, 24)); // Change the font and size

        
 
  //image label 
           img.setBounds(0, -120, 770, 590);
           this.add(img);
           img.setIcon(gif);

 
           
           
           
 }
 
  //handle back action 
  private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new PlayerChoose().setVisible(true);
    }
  //handle play action 
   private void playActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
    if (input.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter your name", "User Name", JOptionPane.WARNING_MESSAGE);
        return;
    }
    initial();
    try (Scanner input1 = new Scanner(new File("Users.txt"))) {
        boolean flag = false;
        while (input1.hasNextLine()) {
            String name = input.getText();
            String name2 = input1.nextLine();
            name2 = name2.substring(0, name2.indexOf(' ') == -1 ? name2.length() : name2.indexOf(' '));

            if (name.equals(name2)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            SaveUser(input.getText());
            System.out.println(input.getText());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

   public static void SaveUser(String s) {


        try (FileWriter f = new FileWriter("Users.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {
            p.println(s + " ");
            p.flush();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
   private void initial() {
    // Create Users.txt file if it doesn't exist
    File file = new File("Users.txt");
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Rest of your code for initializing components goes here
    // ...
}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SinglePlayer().setVisible(true));
    }
}
