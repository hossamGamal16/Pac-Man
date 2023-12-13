package Pacman.src.Templates;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import java.awt.*;
import javax.media.opengl.GLCanvas;
import javax.swing.*;

public class Map1_TwoPlayer extends JFrame {

    Font font =new Font("MV Boli",Font.BOLD,14);
    public Map1_TwoPlayer() {
        super("PackMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Map1_Two_Listener listener = new Map1_Two_Listener();
        this.setLayout(null);

        JPanel panal=new JPanel();
        panal.setFocusable(false);
        panal.setBackground(Color.pink);
        panal.setBounds(0,0,1200,70);
        panal.setLayout(null);

        JLabel scoreText1=new JLabel();
        JLabel scorenum1=new JLabel();
        JLabel scoreText2=new JLabel();
        JLabel scorenum2=new JLabel();

        scorenum1.setFocusable(false);
        scoreText1.setFocusable(false);
        scorenum2.setFocusable(false);
        scoreText2.setFocusable(false);

        scoreText1.setText("Player1 Score: ");
        scorenum1.setText("0");
        scoreText2.setText("Player2 Score: ");
        scorenum2.setText("0");


        scoreText1.setBounds(300,5,200,25);
        scorenum1.setBounds(500,5,50,25);
        scoreText2.setBounds(300,35,200,30);
        scorenum2.setBounds(500,35,50,30);

        JLabel livesText1=new JLabel();
        JLabel livesenum1=new JLabel();
        JLabel livesText2=new JLabel();
        JLabel livesenum2=new JLabel();

        JLabel timertext=new JLabel();
        JLabel timer=new JLabel();

        livesenum1.setFocusable(false);
        livesText1.setFocusable(false);
        livesenum2.setFocusable(false);
        livesText2.setFocusable(false);

        timer.setFocusable(false);
        timertext.setFocusable(false);

        JLabel pause=new JLabel();
        pause.setFont(font);
        pause.setText("esc TO Pause");
        pause.setBounds(120,5,400,40);

        livesText1.setBounds(1000,5,120,25);
        livesenum1.setBounds(1120,5,50,25);
        livesenum1.setText(3+"");
        livesText1.setText("Player 1 Lives: ");
        livesText2.setBounds(1000,35,120,30);
        livesenum2.setBounds(1120,35,50,30);
        livesenum2.setText(3+"");
        livesText2.setText("Player 2 Lives: ");
        timertext.setBounds(700,5,70,60);
        timer.setBounds(770,5,120,60);
        timertext.setText("Time:");
        timer.setText(0+"");


        scorenum1.setFont(font);
        scoreText1.setFont(font);
        scorenum2.setFont(font);
        scoreText2.setFont(font);
        livesenum1.setFont(font);
        livesText1.setFont(font);
        livesenum2.setFont(font);
        livesText2.setFont(font);
        timertext.setFont(font);
        timer.setFont(font);



        panal.add(scoreText1);
        panal.add(scorenum1);
        panal.add(scoreText2);
        panal.add(scorenum2);
        panal.add(livesenum1);
        panal.add(livesText1);
        panal.add(livesenum2);
        panal.add(livesText2);
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
        glcanvas.setBounds(0,70,1200,850);

        listener.setGLcanvas(glcanvas);
        listener.setScore(scorenum1,scorenum2);
        listener.setLives(livesenum1,livesenum2);
        listener.settimes(timer);
        getContentPane().add(glcanvas);
        setSize(1200, 900);
        this.add(panal);
        setLocationRelativeTo(this);
        this.setResizable(false);
        setVisible(true);
    }
}

