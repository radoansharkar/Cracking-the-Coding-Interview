import java.util.Scanner;

public class CheckPermutation {
    
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128]; //Assumption

        char[] s_array = s.toCharArray();
        for (char c : s_array){
            letters[c]++;   //Here 'c' is a char, but java converts it to it's ASCII value automatically 
        }

        for (int i = 0; i < t.length(); i++){
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        
        System.out.println(isAnagram(s, t));
        
        scanner.close(); 
    }
}
