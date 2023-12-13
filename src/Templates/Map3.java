package Pacman.src.Templates;

import com.sun.opengl.util.FPSAnimator;
import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map3 extends JFrame {

    GLCanvas glcanvas;
    static FPSAnimator animator;
    Map3Listener listener = new Map3Listener();
    JLabel timerLabel;
    static Timer timer;
    JButton pauseButton;

    public Map3() {
        super("Map 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create timer label
        timerLabel = new JLabel("Timer: 0");
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        add(timerLabel, BorderLayout.NORTH);

        // Create pause button
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                    pauseButton.setText("Resume");
                } else {
                    timer.start();
                    pauseButton.setText("Pause");
                }
            }
        });
        add(pauseButton, BorderLayout.SOUTH);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        animator = new FPSAnimator(glcanvas, 15);
        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();

        // Set up timer to update the label every second
        timer = new Timer(1000, new ActionListener() {
            int seconds = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timerLabel.setText("Timer: " + seconds);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new Map3();
        animator.start();
    }
}
