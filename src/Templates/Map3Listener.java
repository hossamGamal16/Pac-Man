package Pacman.src.Templates;

import Pacman.src.Core.AnimListener;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.*;
import java.util.BitSet;
import javax.media.opengl.glu.GLU;
import project.core.Point;
import project.core.Rock;
import static Pacman.src.Templates.Map3.animator;
import static Pacman.src.Templates.Map3.timer;
import Texture.TextureReader;

public class Map3Listener extends AnimListener {

    boolean flag;
    boolean flag2;
    boolean flag3;
    boolean flag4;
    boolean flag5;

    private void handleDown() {
        for (Rock rock : rocks) {

            if ((pacmanY - 5 > rock.getRockY() - 20) && (pacmanY - 5 < rock.getRockY() + 20)) {

                flag5 = false;
                flag4 = true;
                flag3 = true;
                flag2 = true;
                return;

            }

            flag5 = true;

        }
    }

    private void handleUp() {
        for (Rock rock : rocks) {

            if ((pacmanY + 5 > rock.getRockY() - 20) && (pacmanY + 5 < rock.getRockY() + 20)) {

                flag4 = false;
                flag5 = true;
                flag3 = true;
                flag2 = true;
                return;
            }

            flag4 = true;

        }
    }

    private void handleRight() {
        for (Rock rock : rocks) {

            if ((pacmanX + 6 > rock.getRockX() - 20) && (pacmanX + 6 < rock.getRockX() + 20)) {

                flag3 = false;
                flag2 = true;
                flag4 = true;
                flag5 = true;
                return;
            }

            flag3 = true;

        }
    }

    private void handleLeft() {
        for (Rock rock : rocks) {

            if ((pacmanX - 5 > rock.getRockX() - 20) && (pacmanX - 5 < rock.getRockX() + 20)) {

                flag2 = false;
                flag3 = true;
                flag4 = true;
                flag5 = true;
                return;
            }

            flag2 = true;

        }
    }

    private void printRockDimention() {
        for (Rock rock : rocks) {

            if ((pacmanX > rock.getRockX() - 20) && (pacmanX < rock.getRockX() + 20)
                    && (pacmanY > rock.getRockY() - 20) && (pacmanY < rock.getRockY() + 20)) {

                flag = false;
                return;
            }

            flag = true;

        }
    }

    private void HandleMoving(GL gl) {
        if (null != direction) {
            switch (direction) {
                case UP: {
                    DrawSprite(gl, pacmanX, pacmanY, 2, 0.45);
                    if (timer.isRunning() && flag == true && pacmanY < 710) {
                        System.out.println(pacmanY);
                        pacmanY += 5;
                    }
                }
                break;
                case DOWN: {
                    DrawSprite(gl, pacmanX, pacmanY, 3, 0.45);
                    if (timer.isRunning() && flag == true && pacmanY > 0) {
                        pacmanY -= 5;
                    }
                }
                break;

                case RIGHT: {
                    DrawSprite(gl, pacmanX, pacmanY, 4, 0.45);
                    if (timer.isRunning() && flag == true && pacmanX < 710) {
                        pacmanX += 5;
                    }
                }
                break;

                case LEFT: {
                    DrawSprite(gl, pacmanX, pacmanY, 5, 0.45);
                    if (timer.isRunning() && flag == true && pacmanX > 0) {
                        pacmanX -= 5;
                    }
                }
                break;

            }
        }
    }

    enum Directions {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    int maxWidth = 800;
    int maxHeight = 800;
    int pacmanX = maxWidth - 85;
    int pacmanY = 0;
    int[][] map = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    int[][] rocksMap = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    Directions direction = Directions.LEFT;

    String textureNames[] = {"Map.jpg", "pacman.png", "up.gif", "down.gif", "right.gif", "left.gif", "ghost.gif", "food.png", "foodd.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    ArrayList<Point> points = new ArrayList();
    ArrayList<Rock> rocks = new ArrayList();

    @Override
    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();

        gl.glClearColor(0, 0, 0, 1f);

        {
            gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
            gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
            gl.glGenTextures(textureNames.length, textures, 0);

            for (int i = 0; i < textureNames.length; i++) {
                try {
                    texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                    gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

                    new GLU().gluBuild2DMipmaps(
                            GL.GL_TEXTURE_2D,
                            GL.GL_RGBA, // Internal Texel Format,
                            texture[i].getWidth(), texture[i].getHeight(),
                            GL.GL_RGBA, // External format from image,
                            GL.GL_UNSIGNED_BYTE,
                            texture[i].getPixels() // Image data
                    );
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }

    }

    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        DrawSprite(gl, (maxWidth / 2) - 42, (maxWidth / 2) - 37, 0, 10);
        handleKeyPress();
        handleEaten();
        DrawPoints(gl);
        printRockDimention();
        System.out.println("now flag is " + flag);

        HandleMoving(gl);
        System.out.println("the x axis is " + pacmanY);
        //     handleKeyPress();

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[0]);    // Turn Blending On

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        // Front Face
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

    public void DrawSprite(GL gl, int x, int y, int index, double scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(0.1 * scale, 0.1 * scale, 1);
        //System.out.println(x +" " + y);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
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

    public void DrawPoints(GL gl) {

        for (int i = 0; i < rocksMap.length; i++) {
            for (int j = 0; j < rocksMap[0].length; j++) {
                int x = 30 * j;
                int y = 30 * i;
                if (map[i][j] == 0) {
                    Point point = new Point(x, y, i, j);
                    points.add(point);
                    DrawSprite(gl, x, y, 8, 0.22);
                }

                if (rocksMap[i][j] == 1) {
                    // DrawSprite(gl, x, y, 7, 0.22);
                    Rock rock = new Rock(x, y);
                    rocks.add(rock);
                }

            }
        }

    }

    public void handleEaten() {
        for (Point point : points) {
            if (eaten(point.getPointX(), point.getPointY())) {
                map[point.getIndexI()][point.getIndexJ()] = 1;
            }
        }

    }

    private boolean eaten(int pointX, int pointY) {
        return (pacmanX > pointX - 20 && pacmanX < pointX + 20) && (pacmanY > pointY - 20 && pacmanY < pointY + 20);
    }

    public void handleKeyPress() {

        if (timer.isRunning()) {
            if (isKeyPressed(KeyEvent.VK_LEFT)) {
                if (pacmanX > 0) {
                    pacmanX -= 5;
                }
                direction = Directions.LEFT;
            } else if (isKeyPressed(KeyEvent.VK_RIGHT)) {
                if (pacmanX < 710) {
                    pacmanX += 5;
                }
                direction = Directions.RIGHT;
            } else if (isKeyPressed(KeyEvent.VK_DOWN)) {
                if (pacmanY > 0) {
                    pacmanY -= 5;
                }
                direction = Directions.DOWN;
            } else if (isKeyPressed(KeyEvent.VK_UP)) {
                //    if(flag4==true)
                if (pacmanY < 710) {
                    pacmanY += 5;
                }
                direction = Directions.UP;
            }

        }
    }

    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void keyTyped(final KeyEvent event) {
        // don't care 
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

    public static void main(String[] args) {
        new Map3();
        animator.start();
    }

}
