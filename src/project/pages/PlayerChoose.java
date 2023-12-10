package project.pages;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import project.core.Music;
import project.pages.HelpPage;

public class PlayerChoose extends JFrame {
    public static Clip voice;

    public PlayerChoose() {
        setLocationRelativeTo(null);
        initComponents();
      //  HomePages.stopAudio();
        getContentPane().setBackground(Color.BLACK); // Set the background color of the JFrame to black
                
                centerWindow();

    }

    private void initComponents() {
                setDefaultCloseOperation(EXIT_ON_CLOSE);

         ImageIcon icon = new ImageIcon("C:\\Users\\Hossam_Gamal\\Documents\\NetBeansProjects\\Pac-Man\\src\\project\\Assets\\help.png");
         ImageIcon usersIcon = new ImageIcon("C:\\Users\\Hossam_Gamal\\Documents\\NetBeansProjects\\Pac-Man\\src\\project\\Assets\\users.png");
        ImageIcon gif = new ImageIcon("C:\\Users\\Hossam_Gamal\\Documents\\NetBeansProjects\\Pac-Man\\src\\project\\Assets\\pac.gif");

         
        JButton exit = new JButton();
        JButton play = new JButton();
        JButton help = new JButton();
        JButton users = new JButton();
        JLabel img = new JLabel();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 500));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);

        // exit button
        exit.setFont(new Font("Hobo Std", Font.BOLD, 30));
        exit.setText("Multi_Player");
        exit.setBackground(Color.orange); // Set the background color of the button to black
        exit.setForeground(Color.black); // Set the font color of the button to green
        this.add(exit);
        exit.setBounds(110, 250, 150, 40);
        exit.setBorderPainted(false); // Disable the border of the button
        exit.setFocusPainted(false); // Removes the border when the button is focused
        exit.setBounds(80, 400, 210, 50);
  






   
        
        //play button 
        play.setFont(new Font("Hobo Std", Font.BOLD, 30));
        play.setText("Single_Player");
        play.setBackground(Color.orange); // Set the background color of the button to black
        play.setForeground(Color.black); // Set the font color of the button to green
        this.add(play);
        play.setBorderPainted(false); // Disable the border of the button
        play.setFocusPainted(false); // Removes the border when the button is focused
        play.setBounds(300, 400, 250, 50);
         play.addActionListener(this::playActionPerformed);

   
        //gif image 
                img.setBounds(0, -120, 770, 590);
                this.add(img);
                img.setIcon(gif);
                

        
        
        


    }
    //action performance
        //exit
        private void exitActionPerformed(java.awt.event.ActionEvent evt) {
            System.exit(0);
        }
         //help 
         private void playActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new SinglePlayer().setVisible(true);

    }
    private void centerWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
    }
//function to stop home page audio 
   public static void stopAudio() {
        if (voice != null) {
            voice.stop();
            voice.close();
            voice = null;
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PlayerChoose().setVisible(true));
    }
}
