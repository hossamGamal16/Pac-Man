
package Pacman.src.Pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SinglePlayer extends JFrame {

    JButton back = new JButton();
    JButton play = new JButton();
    JButton help = new JButton();
    JButton users = new JButton();
    JLabel EnterUserName = new javax.swing.JLabel();
    JLabel img = new JLabel();
    JTextField input = new JTextField();

    public SinglePlayer() {
        initComponents();
        setLocationRelativeTo(null);

    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon gif = new ImageIcon("src/Pacman/src/Assets02/pac.gif");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 500));
        setResizable(false);
        setTitle("Single Player");
        getContentPane().setLayout(null);

        //back button 
        back = createButton("BACK", 80, 400, 200, 35);
        back.addActionListener((java.awt.event.ActionEvent evt) -> {
            backActionPerformed(evt);
        });

        //play button 
        play = createButton("PLAY", 300, 400, 200, 35);;
        play.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                playActionPerformed(evt);
            } catch (IOException ex) {
                Logger.getLogger(SinglePlayer.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        //enter your user label
        EnterUserName.setFont(new java.awt.Font("Hobo Std", Font.BOLD, 32)); // NOI18N
        EnterUserName.setForeground(new java.awt.Color(255, 255, 255));
        EnterUserName.setText("Enter User Name");
        this.add(EnterUserName);
        EnterUserName.setBounds(20, 20, 320, 70);
        EnterUserName.setForeground(Color.WHITE);

        //textfield 
        this.add(input);
        input.setBounds(330, 35, 220, 35);
        input.setBackground(Color.WHITE);
        input.setFont(new Font("Hobo Std", 0, 22)); // Change the font and size

        //image label 
        img.setBounds(0, -120, 770, 590);
        this.add(img);
        img.setIcon(gif);

    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setFont(new Font("Hobo Std", Font.BOLD, 22));
        button.setText(text);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.black);
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        add(button);
        return button;
    }

    //handle back action 
    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HomePages().setVisible(true);
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
        }
    }

    public static void SaveUser(String s) {

        try (FileWriter f = new FileWriter("Users.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) {
            p.println(s + " ");
            p.flush();
        } catch (IOException i) {
        }
    }

    private void initial() {
        // Create Users.txt file if it doesn't exist
        File file = new File("Users.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SinglePlayer().setVisible(true));
    }
}
