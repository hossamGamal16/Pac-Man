package Pacman.src.Pages;

import Pacman.src.Templates.Map3;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChooseMap extends JFrame {

    public ChooseMap() {
        initcomponents();
    }

    private void initcomponents() {
        ImageIcon gif = new ImageIcon("D:\\New folder (2)\\mapp.jpg");

//set visibility 
        setMinimumSize(new java.awt.Dimension(600, 452));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);

//initialization button 
        JButton map1 = new JButton();
        JButton back = new JButton();
        JLabel choose = new JLabel();
        JLabel img = new JLabel();

//map1 button 
        map1.setFont(new java.awt.Font("Hobo Std", 0, 36));
        map1.setText("Map 1");
        this.add(map1);
        map1.setBounds(80, 270, 160, 50);
        map1.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map1ActionPerformed(evt);
            }
        });
//lable choose map 
        choose.setFont(new Font("Hobo Std", 0, 48));
        choose.setForeground(new Color(255, 255, 255));
        choose.setText("Choose map");
        getContentPane().add(choose);
        choose.setBounds(170, 20, 280, 58);
//add image 
        img.setIcon(gif);
        getContentPane().add(img);
        img.setBounds(0, -120, 770, 590);

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ChooseMap().setVisible(true));
    }

    //actions 
    private void map1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Map3.main(null);
    }

}
