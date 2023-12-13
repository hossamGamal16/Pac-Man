package Pacman.src.Characters;

import static project.core.utils.trX;
import static project.core.utils.trY;

public class PacMan {

    public int stepSize = 10; // Represents the step size for movements
    public static final int R = 10;
    public double posX = 15, posY = 15; // Represents Pacman's x and y positions
    public int gridX = trX(posX), gridY = trY(posY); // Represents grid positions based on Pacman's position

    public Directions direction = Directions.IDEAL; // Represents Pacman's current direction

    public void moveUP() {
        direction = Directions.UP;
        posY -= stepSize; // Move Pacman up by stepSize
        gridY = trY(posY); // Update grid Y coordinate
    }

    public void moveDown() {
        direction = Directions.DOWN;
        posY += stepSize; // Move Pacman down by stepSize
        gridY = trY(posY); // Update grid Y coordinate
    }

    public void moveRight() {
        direction = Directions.RIGHT;
        posX += stepSize; // Move Pacman right by stepSize
        gridX = trX(posX); // Update grid X coordinate
    }

    public void moveLeft() {
        direction = Directions.LEFT;
        posX -= stepSize; // Move Pacman left by stepSize
        gridX = trX(posX); // Update grid X coordinate
    }

    public void reset() {
        direction = Directions.IDEAL;
        posX = posY = 15; // Reset Pacman's position to initial coordinates
        gridX = gridY = trX(posX); // Reset grid coordinates
    }
}
