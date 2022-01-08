package replitCalismasi;
import java.util.*;
public class con1main {
    static Scanner scan = new Scanner(System.in);
    static int puan1=0;
    static int puan2=0;
    static String kelime1;
    static String kelime2;
    static int uzunluk;
    public static void main(String[] args) {

        String alfabe = "ABCDEFGHIJKLMNOPRSTUVQWXYZabcdefghijklmnopqrstuvwxyz";

        do {
            System.out.println("Oyuncu1 Kelime Gir");

            kelime1 = scan.next();
            uzunluk=kelime1.length();
        } while ( uzunluk<2||!alfabe.contains(kelime1));
        System.out.println("Oyuncu2 Kelime Gir");
        // kelime2 = scan.next();

    } }


