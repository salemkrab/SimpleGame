package game.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Utils {
    private static String[] namesArray;

    static {
        Utils.setNamesArray(Utils.generateNamesArray());
    }

    public static int randInt(int min, int max) {
        return (int)(Math.floor(Math.random() * (max - min + 1) + min));
    }
    private static String[] generateNamesArray() {
        URL url = null;
        try {
            url = new URL("https://raw.githubusercontent.com/dominictarr/random-name/master/first-names.txt");
        } catch (MalformedURLException e) {
            System.out.println("Url invalide, veuillez saisir une URL valide.");
        }
        Scanner s = null;
        try {
            s = new Scanner(url.openStream());
        } catch (IOException e) {
            System.out.println("Erreur de connection à l'URL, veuillez recommencer");
        }
        String[] namesArray = new String[4945];
        int i=0;
        while (s.hasNext()) {
            namesArray[i++]=s.nextLine();
        }
        s.close();
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