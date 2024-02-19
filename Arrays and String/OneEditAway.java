import java.util.Scanner;

public class OneEditAway {
    
    static boolean OneEditAway(String first, String second){
        /*Length checks */
        if (Math.abs(first.length() - second.length()) > 1)
            return false;
        
        /*Get shorter and longer strings (trust me it works) */
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;

        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)){
                /* Ensure that this is the first difference found */
                if (foundDifference)
                    return false;
                foundDifference = true;
            
                if (s1.length() == s2.length()) // On replace, move shorter string's pointer
                    index1++;
            } else {
                index1++; //if matching, move pointer for the shorter string
            }
            index2++;  // Always move the longer string's pointer
        }
        return true;
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String second = sc.nextLine();

        System.out.println(OneEditAway(first, second));

    }
}
