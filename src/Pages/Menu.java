package Pacman.src.Pages;

import Pacman.src.Templates.Map3;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu extends JFrame {

    int maxWidth = 600;
    int maxHeight = 500;
    public static Clip voice;

    public Menu() {

        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        centerWindow();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(maxWidth, maxHeight));
        setResizable(false);
        setTitle("Menu");
        setLayout(null);

        JButton MAP_01 = createButton("MAP_01", (maxWidth / 3), 100, 200, 35, this::MAP_01ActionPerformed);
        JButton MAP_02 = createButton("MAP_02", (maxWidth / 3), 170, 200, 35, this::MAP_02ActionPerformed);
        JButton MAP_03 = createButton("MAP_03", (maxWidth / 3), 240, 200, 35, this::MAP_03ActionPerformed);
        JButton BACK = createButton("BACK", (maxWidth / 3), 310, 200, 35, this::backActionPerformed);

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

    private void MAP_01ActionPerformed(ActionEvent evt) {
        dispose();
        new Map01PlayerChoose().setVisible(true);
    }

    private void MAP_02ActionPerformed(ActionEvent evt) {
        this.dispose();
        new Map02PlayerChoose().setVisible(true);
    }

    private void MAP_03ActionPerformed(ActionEvent evt) {
        dispose();
        new Map3().setVisible(true);
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HomePages().setVisible(true);
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
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}
