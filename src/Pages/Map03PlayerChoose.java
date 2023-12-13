package Pacman.src.Pages;

import Pacman.src.Templates.Map3;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map03PlayerChoose extends JFrame {

    int maxWidth = 600;
    int maxHeight = 500;
    public static Clip voice;

    public Map03PlayerChoose() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        centerWindow();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 500));
        setResizable(false);
        setTitle("PacMan Game");
        setLayout(null);

        JButton singlePlayer = createButton("SINGLE_PLAYER", (maxWidth / 3)-30, 100, 250, 35, this::singleActionPerformed);
        JButton multiPlayer = createButton("MULTI_PLAYER", (maxWidth / 3)-30, 200, 250, 35, this::multiActionPerformed);
        JButton back = createButton("BACK", (maxWidth / 3)-30, 300, 250, 35, this::backActionPerformed);

        // Gif image
        JLabel img = new JLabel();
        img.setBounds(0, -120, 770, 590);
        add(img);
        img.setIcon(new ImageIcon("src/Pacman/src/Assets02/pac.gif"));
    }

    private JButton createButton(String text, int x, int y, int width, int height, ActionListener listener) {
        JButton button = new JButton();
        button.setFont(new Font(Font.SERIF, Font.BOLD, 22));
        button.setText(text);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.black);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBounds(x, y, width, height);
        button.addActionListener(listener);
        add(button);
        return button;
    }

    private void singleActionPerformed(ActionEvent evt) {
        dispose();
        new Map3().setVisible(true);
    }

    private void multiActionPerformed(ActionEvent evt) {
        dispose();
        new Map3().setVisible(true);
    }

    private void backActionPerformed(ActionEvent evt) {
         dispose();
        new Menu().setVisible(true);
    }

    private void centerWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public static void stopAudio() {
        if (voice != null) {
            voice.stop();
            voice.close();
            voice = null;
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new PlayerChoose().setVisible(true));
    }
}
