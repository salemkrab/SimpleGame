package game.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Utils {
    private static String[] namesArray;

    static {
        try {
            Utils.setNamesArray(Utils.generateNamesArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int randInt(int min, int max) {
        return (int)(Math.floor(Math.random() * (max - min + 1) + min));
    }
    private static String[] generateNamesArray() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/dominictarr/random-name/master/first-names.txt");
        Scanner s = new Scanner(url.openStream());
        String[] namesArray = new String[4945];
        int i=0;
        while (s.hasNext()) {
            namesArray[i++]=s.nextLine();
        }
        return namesArray;
    }
    public static String getRandName() {

        return Utils.getNamesArray()[Utils.randInt(0,4945)];
    }



    private static String[] getNamesArray() {
        return namesArray;
    }

    private static void setNamesArray(String[] namesArray) {
        Utils.namesArray = namesArray;
    }
}