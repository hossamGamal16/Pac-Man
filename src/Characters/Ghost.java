package Pacman.src.Characters;

import java.util.Random;
import static project.core.utils.trX;
import static project.core.utils.trY;

public class Ghost {
    Random random = new Random();
    public int step = 10; // Represents the step size for movements
    public static final int R = 10; // Represents the radius of the Ghost
    public double x = 250, y = 250; // Represents Ghost's x and y positions
    public int ii = trX(x), jj = trY(y); // Represents grid positions based on Ghost's position
    public Directions direction = Directions.IDEAL; // Represents Ghost's current direction

    public Ghost() {
        // Default constructor
    }

    public Ghost(double x, double y) {
        this.x = x;
        this.y = y;
        ii = trX(x); // Update grid X coordinate
        jj = trY(y); // Update grid Y coordinate
    }

    // Method to make a random move for the Ghost
    public void randMove() {
        int sw = random.nextInt(4);
        switch (sw) {
            case 0:
                direction = Directions.UP;
                break;
            case 1:
                direction = Directions.RIGHT;
                break;
            case 2:
                direction = Directions.DOWN;
                break;
            case 3:
                direction = Directions.LEFT;
                break;
        }
    }

    // Methods to move the Ghost in specific directions
    public void moveUP() {
        direction = Directions.UP;
        y -= step; // Move Ghost up by step
        jj = trY(y); // Update grid Y coordinate
    }

    public void moveDown() {
        direction = Directions.DOWN;
        y += step; // Move Ghost down by step
        jj = trY(y); // Update grid Y coordinate
    }

    public void moveRight() {
        direction = Directions.RIGHT;
        x += step; // Move Ghost right by step
        ii = trX(x); // Update grid X coordinate
    }

    public void moveLeft() {
        direction = Directions.LEFT;
        x -= step; // Move Ghost left by step
        ii = trX(x); // Update grid X coordinate
    }

    // Reset Ghost's state to default
    public void reset() {
        direction = Directions.IDEAL;
    }
}
