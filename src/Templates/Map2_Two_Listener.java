package Pacman.src.Templates;

import Texture.TextureReader;
import com.sun.opengl.util.FPSAnimator;

import java.awt.event.*;
import java.io.IOException;
import java.util.BitSet;
import javax.media.opengl.*;

import javax.media.opengl.glu.GLU;
import javax.swing.*;

public class Map2_Two_Listener extends Map2Action {

    private GLCanvas glCanvas;
    FPSAnimator Animator;
    private int score1 = 0, score2 = 0, lives1 = 3, lives2 = 3;
    private JLabel scorenum1, scorenum2, livesenum1, livesenum2, timer;

    int index = 0, pause = 1, tel = 9;
    double t = 1, t2 = 0, t3 = 1, t4 = 0;

    int secont = 0, mili = 0, minits = 0;

    double x = .55, y = .48;
    double x2 = .48, y2 = .48;

    double xe1 = -.5, ye1 = -.5, xe2 = -.5, ye2 = .5;

    double[][] food = map2valid.food(29);

    double[][] valid = map2valid.valid;

    String textureNames[] = {"pac_1.png", "pac_1.png", "pac_1.png", "pac_1.png", "pac_1.png", "pac_2.png", "map2.png", "food.png", "Enemy.png", "Teleport.png", "Teleport 2.png", "word.png",
         "pac_1g.png", "pac_1g.png", "pac_1g.png", "pac_1g.png", "pac_1g.png", "pac_2 g.png", "word2.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(0.2f, 0.421f, 0.445f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels()
                );
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }

            Animator = new FPSAnimator(2);
            Animator.start();
        }
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        try {

            if (lives1 <= 0 && lives2 <= 0) {
                glCanvas.setEnabled(false);
                int answer = JOptionPane.showConfirmDialog(null, "Game Over \n want to start new game", "GameOver", JOptionPane.YES_NO_OPTION);
                if (answer == 0) {
                    resetGame();
                } else {
                    System.exit(0);
                }
            }
            handleKeyPress();
            if (checkCollision(x, y, 0.02 * t, 0.035 * (t == 0.8 ? 0.8 : 1), xe1, ye1, .09, .09)
                    || checkCollision(x, y, 0.02 * t, 0.035 * (t == 0.8 ? 0.8 : 1), xe2, ye2, .09, .09)) {
                --lives1;

                if (lives1 > 0) {
                    x = .55;
                    y = .48;
                }
                if (lives2 > 0) {
                    x2 = .48;
                    y2 = .48;
                }
                xe1 = -.5;
                ye1 = -.5;
                xe2 = -.5;
                ye2 = .5;
                if (lives1 <= 0) {
                    x = Integer.MIN_VALUE;
                }
                setLives(livesenum1, livesenum2);
            }
            if (checkCollision(x2, y2, 0.02 * t3, 0.035 * (t3 == 0.8 ? 0.8 : 1), xe1, ye1, .09, .09)
                    || checkCollision(x2, y2, 0.02 * t3, 0.035 * (t3 == 0.8 ? 0.8 : 1), xe2, ye2, .09, .09)) {
                --lives2;
                if (lives1 > 0) {
                    x = .55;
                    y = .48;
                }
                if (lives2 > 0) {
                    x2 = .48;
                    y2 = .48;
                }
                xe1 = -.5;
                ye1 = -.5;
                xe2 = -.5;
                ye2 = .5;
                if (lives1 <= 0) {
                    x = Integer.MIN_VALUE;
                }
                setLives(livesenum1, livesenum2);
            }
            for (int i = 0; i < food.length; i++) {
                if (checkCollision(x, y, 0.02 * t, 0.035 * (t == 0.8 ? 0.8 : 1), food[i][0], food[i][1], 0.05, 0.05)) {
                    score1++;
                    food[i][0] = Integer.MAX_VALUE;
                    setScore(scorenum1, scorenum2);
                    if (score1 + score2 == 27) {
                        int answer2 = JOptionPane.showConfirmDialog(null, "Winner!! \n want to play again", "Winner", JOptionPane.YES_NO_OPTION);
                        if (answer2 == 0) {
                            resetGame();
                        }else {
                            System.exit(0);
                        }
                    }
                }
                if (checkCollision(x2, y2, 0.02 * t3, 0.035 * (t3 == 0.8 ? 0.8 : 1), food[i][0], food[i][1], 0.05, 0.05)) {
                    score2++;
                    food[i][0] = Integer.MAX_VALUE;
                    setScore(scorenum1, scorenum2);
                    if (score1 + score2 == 27) {
                        int answer2 = JOptionPane.showConfirmDialog(null, "Winner!! \n want to play again", "Winner", JOptionPane.YES_NO_OPTION);
                        if (answer2 == 0) {
                            resetGame();
                        } else {
                            System.exit(0);
                        }
                    }
                }
            }
            Draws(gl, -.82, 0, 11, .2, .4);
            Draws(gl, .82, 0, 18, .2, .4);

            DrawPackMan(gl, x, y, t2, index, t);
            DrawPackMan(gl, x2, y2, t4, index + 12, t3);

            Draws(gl, .58, -.55, tel, .09, .09);
            Draws(gl, -.58, .55, tel, .09, .09);

            Draws(gl, xe1, ye1, 8, .05, .05);
            Draws(gl, xe2, ye2, 8, .05, .05);

            for (int i = 0; i < food.length; i++) {
                Draws(gl, food[i][0], food[i][1], 7, .02, .02);
            }
            Drawmap(gl);
            if (pause == 1) {
                index++;
                index = index % 6;

                mili += 7;
                if (mili >= 100) {
                    mili = 0;
                    secont++;
                }
                if (secont == 60) {
                    minits++;
                    secont = 0;
                }
                settimes(timer);

                if (tel == 10) {
                    tel = 9;
                } else {
                    tel++;
                }

                int Xe = (int) (xe1 * 30) + 19, Xe2 = (int) (xe2 * 30) + 19;
                int Ye = (int) (ye1 * 30) + 19, Ye2 = (int) (ye2 * 30) + 19;

                if (lives1 > 0 || lives2 > 0) {
                    if (Math.pow(x - (xe1 + .004), 2) + Math.pow(y - ye1, 2) < Math.pow(x - (xe1 - .004), 2) + Math.pow(y - ye1, 2) && valid[Ye][Xe + 1] == 1) {
                        xe1 += .004;
                    } else if (valid[Ye][Xe - 1] == 1) {
                        xe1 -= .004;
                    }

                    if (Math.pow(x - xe1, 2) + Math.pow(y - (ye1 + .005), 2) < Math.pow(x - xe1, 2) + Math.pow(y - (ye1 - .005), 2) && valid[Ye + 1][Xe] == 1) {
                        ye1 += .005;
                    } else if (valid[Ye - 1][Xe] == 1) {
                        ye1 -= .005;
                    }

                    if (Math.pow(x2 - (xe2 + .004), 2) + Math.pow(y2 - ye2, 2) < Math.pow(x2 - (xe2 - .004), 2) + Math.pow(y2 - ye2, 2) && valid[Ye2][Xe2 + 1] == 1) {
                        xe2 += .004;
                    } else if (valid[Ye2][Xe2 - 1] == 1) {
                        xe2 -= .004;
                    }

                    if (Math.pow(x2 - xe2, 2) + Math.pow(y2 - (ye2 + .005), 2) < Math.pow(x2 - xe2, 2) + Math.pow(y2 - (ye2 - .005), 2) && valid[Ye2 + 1][Xe2] == 1) {
                        ye2 += .005;
                    } else if (valid[Ye2 - 1][Xe2] == 1) {
                        ye2 -= .005;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {
    }

    public void DrawPackMan(GL gl, double X, double Y, double k, int index, double t) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On
        double g = 1;
        if (t == .8) {
            g = .8;
        }
        gl.glPushMatrix();
        gl.glTranslated(X, Y, 0);
        gl.glRotated(180 * k, 0, 0, 1);
        gl.glScaled(0.02 * t, 0.035 * g, 1);
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void Drawmap(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[6]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-.66f, -.66f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(.66f, -.66f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(.66f, .66f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-.66f, .66f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void Draws(GL gl, double x0, double y0, int i, double scalex, double scaley) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(x0, y0, 0);
        gl.glScaled(scalex, scaley, 1);
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-.70f, -.70f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(.70f, -.70f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(.70f, .70f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-.70f, .70f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void handleKeyPress() {
        int X = (int) (x * 30) + 19;
        int Y = (int) (y * 30) + 19;
        int X2 = (int) (x2 * 30) + 19;
        int Y2 = (int) (y2 * 30) + 19;

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (pause == 1 && x > -1) {
                t = -1;
                t2 = 0;
                if (x <= -.54 && y > .51) {
                    x = .55;
                    y = -.55;
                }
                if (valid[Y][X - 1] == 1) {
                    x -= .01;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (pause == 1 && x > -1) {
                t = 1;
                t2 = 0;
                if (x >= .54 && y < -.51) {
                    x = -.55;
                    y = .55;
                }
                if (valid[Y][X + 1] == 1) {
                    x += .01;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (pause == 1 && x > -1) {
                t = .8;
                t2 = -.5;
                if (x >= .54 && y < -.51) {
                    x = -.55;
                    y = .55;
                }
                if (valid[Y - 1][X] == 1) {
                    y -= .01;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_UP)) {
            if (pause == 1 && x > -1) {
                t = .8;
                t2 = .5;
                if (x <= -.54 && y > .51) {
                    x = .55;
                    y = -.55;
                }
                if (valid[Y + 1][X] == 1) {
                    y += .01;
                }
            }
        }
        if (isKeyPressed(KeyEvent.VK_W)) {
            if (pause == 1 && x2 > -1) {
                t3 = .8;
                t4 = .5;
                if (x2 <= -.54 && y2 > .51) {
                    x2 = .55;
                    y2 = -.55;
                }
                if (valid[Y2 + 1][X2] == 1) {
                    y2 += .01;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_S)) {
            if (pause == 1 && x2 > -1) {
                t3 = .8;
                t4 = -.5;
                if (x2 >= .54 && y2 < -.51) {
                    x2 = -.55;
                    y2 = .55;
                }
                if (valid[Y2 - 1][X2] == 1) {
                    y2 -= .01;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_D)) {
            if (pause == 1 && x2 > -1) {
                t3 = 1;
                t4 = 0;
                if (x2 >= .54 && y2 < -.51) {
                    x2 = -.55;
                    y2 = .55;
                }
                if (valid[Y2][X2 + 1] == 1) {
                    x2 += .01;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_A)) {
            if (pause == 1 && x2 > -1) {
                t3 = -1;
                t4 = 0;
                if (x2 <= -.54 && y2 > .51) {
                    x2 = .55;
                    y2 = -.55;
                }
                if (valid[Y2][X2 - 1] == 1) {
                    x2 -= .01;
                }
            }
        }
    }

    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.set(keyCode);

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            pause *= -1;
        }
    }

    public boolean checkCollision(double x1, double y1, double width1, double height1, double x2, double y2, double width2, double height2) {
        return x1 < x2 + width2
                && x1 + width1 > x2
                && y1 < y2 + height2
                && y1 + height1 > y2;
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.clear(keyCode);
    }

    public void setGLcanvas(GLCanvas glcanvas) {
        this.glCanvas = glcanvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void setScore(JLabel scorenum1, JLabel scorenum2) {
        this.scorenum1 = scorenum1;
        this.scorenum2 = scorenum2;
        scorenum1.setText(score1 + "");
        scorenum2.setText(score2 + "");
    }

    public void setLives(JLabel livesenum1, JLabel livesenum2) {
        this.livesenum1 = livesenum1;
        livesenum1.setText(lives1 + "");
        this.livesenum2 = livesenum2;
        livesenum2.setText(lives2 + "");

    }

    public void resetGame() {
        score1 = 0;
        score2 = 0;
        lives1 = 3;
        lives2 = 3;
        x = .55;
        y = .48;
        x2 = .48;
        y2 = .48;
        xe1 = -.5;
        ye1 = -.5;
        xe2 = -.5;
        ye2 = .5;
        secont = 0;
        mili = 0;
        minits = 0;
        food = map2valid.food(29);
        glCanvas.setEnabled(true);
        setScore(scorenum1, scorenum2);
        setLives(livesenum1, livesenum2);
    }

    public void settimes(JLabel timer) {
        this.timer = timer;
        timer.setText(minits + ":" + secont + ":" + mili);
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
}
