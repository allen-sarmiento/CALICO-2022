import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // 0 to 12 and 13 to 25
    // 1 to 13 and 14 to 26

    // Shifting Atbash
    // 0 -> 25 (25-0)
    // 1 -> 24 (25-1)
    // 2 -> 23 (25-2)
    // 25 -> 0 (25-25)
    // 24 -> 1 (25-24)
    // 23 -> 2 (25-23)

    static String letters = "abcdefghijklmnopqrstuvwxyz"; // 26 letters (0 to 25)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for (int c = 0; c < cases; c++) {

            String text = sc.nextLine();
            int numCiphers = Integer.parseInt(sc.nextLine());
            String ciphers = sc.nextLine();
            Scanner sc2 = new Scanner(ciphers);
            sc.nextLine();

            for (int i = 0; i < numCiphers; i++)
            {
                String cipher = sc2.next();
                if (cipher.charAt(0) == 'C')
                {
                    if (cipher.charAt(1) == '-')
                        text = caeser(text, -Integer.parseInt(cipher.substring(2)));
                    else
                        text = caeser(text, Integer.parseInt(cipher.substring(1)));
                }

                else if ((cipher.charAt(0) == 'A'))
                    text = atbash(text);

                else if ((cipher.charAt(0) == 'R'))
                    text = reverse(text);

            }
            System.out.println();
        }
    }

    public static String caeser(String text, int shift) {
        System.out.println("Caeser In: " + text);
        String out = "";
        for (int i = 0; i < text.length(); i++) { // loop thru all chars
            int c = letters.indexOf(text.charAt(i));
            if (c == -1) {
                out += text.charAt(i);
                continue;
            }
            c -= shift;
            if (c > 25)
                c -= 26;
            else if (c < 0)
                c += 26;
            out += letters.charAt(c);
        }
        System.out.println("Caeser " + shift + " out: " + out);
        return out;
    }

    public static String atbash(String text) {
        System.out.println("Atbash In: " + text);
        String out = "";
        for (int i = 0; i < text.length(); i++) { // loop thru all chars
            int c = letters.indexOf(text.charAt(i));
            if (c == -1) {
                out += text.charAt(i);
                continue;
            }
            c = 25-c;
            out += letters.charAt(c);
        }
        System.out.println("Atbash Out: " + out);
        return out;
    }

    public static String reverse(String text) {
        System.out.println("Reverse In: " + text);
        String out = "";
        for (int i = text.length()-1; i >= 0; i--) // loop thru all chars
            out += text.charAt(i);
        System.out.println("Reverse Out: " + out);
        return out;
    }
}