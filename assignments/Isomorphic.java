import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Isomorphic {
    public static void main(String [] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String s1 = scan.nextLine();
        System.out.print("Enter String 2: ");
        String s2 = scan.nextLine();

        System.out.println(isIsomorphic(s1, s2));
        scan.close();
    }

    // It's isomorphic as long as there's no two characters mapped to the same thing
    public static boolean isIsomorphic(String s1, String s2) {

        // Check if either String is null or different length and auto fail
        if ((s1 == null) || (s2 == null) || (s1.length() != s2.length())) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(map.containsKey(c1)) {
                // If character has been mapped before, compare if that mapping matches what is at c2
                if(map.get(c1) != c2) {
                    return false;
                }
            }else {
                // If the character has not been mapped before, check if c2 has been used before, then map it
                if(map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }

        // Return true if it passes all tests
        return true;
    }
}