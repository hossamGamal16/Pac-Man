/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.pages;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import project.pages.HomePages;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Users extends JFrame {
    JTextArea USERNAME = new JTextArea();

    public Users() {
        initComponents();
        setLocationRelativeTo(null);
        displayUserData(); // Fetch and display user data
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 452));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setBackground(Color.BLACK);

        // Layout managers are generally better than absolute positioning
        getContentPane().setLayout(new BorderLayout());

        JButton Back = new JButton();
        Back.setFont(new Font("Hobo Std", Font.BOLD, 30));
        Back.setText("back");
        Back.setBackground(Color.orange);
        Back.setForeground(Color.black);
        Back.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(Back, BorderLayout.SOUTH);

        // Creating a panel for centering the table
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);

        // JTextArea setup
        USERNAME.setEditable(false);
        USERNAME.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14)); // Using a monospaced font
        USERNAME.setBackground(Color.BLACK); // Set background color to black
        USERNAME.setForeground(Color.WHITE); // Set text color to white

        // Adding the JScrollPane containing the JTextArea to the centerPanel
        JScrollPane jScrollPane1 = new JScrollPane(USERNAME);
        centerPanel.add(jScrollPane1);

        // Adding the centerPanel to the content pane in the CENTER position
        getContentPane().add(centerPanel, BorderLayout.CENTER);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HomePages().setVisible(true);
    }

    private void displayUserData() {
        try {
            Scanner sc = new Scanner(new File("Users.txt"));
            // Displaying column headers with separating lines
            USERNAME.append("┌────────────────────┬──────────┬──────────┬──────────┐\n");
            USERNAME.append("│      UserName       Play     Win     Lose    \n");
            USERNAME.append("├────────────────────┼──────────┼──────────┼──────────┤\n");

            while (sc.hasNext()) {
                String userName = sc.nextLine().trim();
                // Displaying user data with separating lines
                USERNAME.append(String.format(" %-18s                               \n", userName));
                USERNAME.append("├────────────────────┼──────────┼──────────┼──────────┤\n");
            }
            sc.close();
            // Closing the table with a bottom line
            USERNAME.append("└────────────────────┴──────────┴──────────┴──────────┘\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Users().setVisible(true));
    }
}
