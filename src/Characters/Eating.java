package Pacman.src.Characters;

import static project.core.utils.arcTrX;
import static project.core.utils.arcTrY;

public class Eating {

    public static final int R = 1;
    public double x, y;
    public int ii, jj;

    public Eating(int i, int j) {
        x = arcTrX(i);
        y = arcTrY(j);

        ii = i;
        jj = j;
    }

}
