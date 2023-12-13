package Pacman.src.Pages;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import Pacman.src.Core.Music;

public class HomePages extends JFrame {

    public static Clip voice;

    public HomePages() {
        setLocationRelativeTo(null);
        initComponents();
        getContentPane().setBackground(Color.BLACK); // Set the background color of the JFrame to black
        if (voice == null) {
            voice = Music.playMusic("src/Pacman/src/Assets01/audio/pacman_beginning.wav", true);
        }
        centerWindow();

    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon("src/Pacman/src/Assets02/help.png");
        ImageIcon usersIcon = new ImageIcon("src/Pacman/src/Assets02/users.png");
        ImageIcon gif = new ImageIcon("src/Pacman/src/Assets02/pac.gif");

        JButton exit = new JButton();
        JButton play = new JButton();
        JButton help = new JButton();
        JButton users = new JButton();
        JButton user = new JButton();
        JLabel img = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 500));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);

        // exit button
        exit.setFont(new Font("Hobo Std", Font.BOLD, 30));
        exit.setText("Exit");
        exit.setForeground(Color.ORANGE); // Set the font color of the button to green
        this.add(exit);
        exit.setBounds(110, 250, 150, 40);
        exit.addActionListener(this::exitActionPerformed);
        exit.setBorderPainted(false); // Disable the border of the button
        exit.setFocusPainted(false); // Removes the border when the button is focused
        exit.setBounds(80, 400, 210, 50);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);

        // help button
        this.add(help);
        help.setBounds(455, 30, 130, 50);
        help.setBorderPainted(false); // Disable the border of the button
        help.setFocusPainted(false); // Removes the border when the button is focused
        help.setIcon(icon);
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        help.addActionListener((java.awt.event.ActionEvent evt) -> {
            helpActionPerformed(evt);
        });

        // users button
        this.add(users);
        users.setBounds(10, 30, 130, 40);
        users.setBorderPainted(false); // Disable the border of the button
        users.setFocusPainted(false); // Removes the border when the button is focused
        users.setIcon(usersIcon);
        users.setOpaque(false);
        users.setContentAreaFilled(false);
        users.addActionListener((java.awt.event.ActionEvent evt) -> {
            UsersActionPerformed(evt);
        });

        //play button 
        play.setFont(new Font("Hobo Std", Font.BOLD, 30));
        play.setText("Play");
        play.setForeground(Color.orange); // Set the font color of the button to green
        this.add(play);
        play.setBorderPainted(false); // Disable the border of the button
        play.setFocusPainted(false); // Removes the border when the button is focused
        play.setBounds(300, 400, 210, 50);
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.addActionListener((java.awt.event.ActionEvent evt) -> {
            playActionPerformed(evt);
        });

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

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HelpPage().setVisible(true);

    }
    //play

    private void playActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new Menu().setVisible(true);

    }

    private void UsersActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new Users().setVisible(true);

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
        java.awt.EventQueue.invokeLater(() -> new HomePages().setVisible(true));
    }
}
