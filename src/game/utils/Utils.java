package game.utils;

public class Utils {

    public static int randInt(double min, double max) {
        return (int)(Math.floor(Math.random() * (max - min + 1) + min));
    }

}