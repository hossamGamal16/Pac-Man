package Pacman.src.Templates;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import java.awt.*;
import javax.media.opengl.GLCanvas;
import javax.swing.*;

public class Map1_Single extends JFrame {

         Font font =new Font("MV Boli",Font.BOLD,20);
    public Map1_Single() {
        super("PackMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Map1_Single_Listener listener = new Map1_Single_Listener();
        this.setLayout(null);

        JPanel panal=new JPanel();
        panal.setFocusable(false);
        panal.setBackground(Color.pink);
        panal.setBounds(0,0,1200,50);
        panal.setLayout(null);

        JLabel scoreText=new JLabel();
        JLabel scorenum=new JLabel();

        scorenum.setFocusable(false);
        scoreText.setFocusable(false);

        scoreText.setText("Score: ");
        scorenum.setText("0");


        scoreText.setBounds(710,5,80,40);
        scorenum.setBounds(790,5,60,40);

        JLabel livesText=new JLabel();
        JLabel livesenum=new JLabel();

        JLabel timertext=new JLabel();
        JLabel timer=new JLabel();

        livesenum.setFocusable(false);
        livesText.setFocusable(false);

        timer.setFocusable(false);
        timertext.setFocusable(false);

        JLabel pause=new JLabel();
        pause.setFont(font);
        pause.setText("esc TO Pause");
        pause.setBounds(120,5,400,40);

        livesText.setBounds(1010,5,80,40);
        livesenum.setBounds(1090,5,60,40);
        livesenum.setText(3+"");
        livesText.setText("Lives: ");
        timertext.setBounds(400,5,70,40);
        timer.setBounds(470,5,120,40);
        timertext.setText("Time:");
        timer.setText(0+"");

        scorenum.setFont(font);
        scoreText.setFont(font);
        livesenum.setFont(font);
        livesText.setFont(font);
        timertext.setFont(font);
        timer.setFont(font);


        panal.add(scoreText);
        panal.add(scorenum);
        panal.add(livesenum);
        panal.add(livesText);
        panal.add(pause);
        panal.add(timertext);
        panal.add(timer);


        GLCanvas glcanvas = new GLCanvas();
        Animator animator;
        animator = new FPSAnimator(15);
        animator.add(glcanvas);
        animator.start();
        glcanvas.setFocusable(true);
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.addMouseMotionListener(listener);
        glcanvas.setSize(1500,1200);
        glcanvas.setBounds(0,50,1200,850);

        listener.setGLcanvas(glcanvas);
        listener.setScore(scorenum);
        listener.setLives(livesenum);
        listener.settimes(timer);
        getContentPane().add(glcanvas);
        setSize(1200, 900);
        this.add(panal);
        setLocationRelativeTo(this);
        this.setResizable(false);
        setVisible(true);
    }
}
