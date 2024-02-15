import java.util.Scanner;

public class PalindromePermutation {    // Solution without using any data structurs and having time complexity of O(N)

    static boolean isPermuationOfPalindrome(String phrase){
        int bitVector = createBitVector(phrase);
        return checkExactlyOneBitSet(bitVector);
    }

    static int createBitVector(String phrase){
        int bitVector = 0;

        for (char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            int mask = 1 << x;
            if ((bitVector & mask) == 0)
                bitVector = bitVector | mask; //eikhane just jodi character tar bit jodi 0 hoile sheitake 1 kortesi, mane ei character ta ekhon odd times ache
            else
                bitVector = bitVector & ~mask; // eikhane amra bit vector e odd times thaka character ta ke toggle kore even times banay dicchi, while keeping everything else same
        }
        return bitVector;
    }

    static int getCharNumber(Character c){   // Basically ei funtion kar hocche, a,b,c,d eigula konta koto number character sheita bola -_-
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z)
            return val - a;
        
        return -1;
    }

    static boolean checkExactlyOneBitSet(int bitVector){
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        
        System.out.println(isPermuationOfPalindrome(s));

        scanner.close(); 
    }
}

/*
 * 110101
 * 101111
 */
