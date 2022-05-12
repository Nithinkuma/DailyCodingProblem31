/**The edit distance between two strings refers to the minimum number of character insertions,
 deletions, and substitutions required to change one string to the other.
 For example, the edit distance between “kitten” and “sitting” is three:
 substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.**/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int lengthOfStr1 = str1.length();
        int lengthOfStr2 = str2.length();

        System.out.println(editDistance(str1,str2,lengthOfStr1,lengthOfStr2));
    }

    private static int editDistance(String str1, String str2, int lengthOfStr1, int lengthOfStr2) {
        if (lengthOfStr1==0)
            return lengthOfStr2;
        else if (lengthOfStr2==0)
            return lengthOfStr1;
        else if(str1.charAt(lengthOfStr1-1)==str2.charAt(lengthOfStr2-1))
            return editDistance(str1,str2,lengthOfStr1-1,lengthOfStr2-1);

        return 1+min(editDistance(str1,str2,lengthOfStr1-1,lengthOfStr2),
                editDistance(str1,str2,lengthOfStr1-1,lengthOfStr2-1),
                editDistance(str1,str2,lengthOfStr1,lengthOfStr2-1));
    }

    private static int min(int editDistance, int editDistance1, int editDistance2) {
        if(editDistance<editDistance1 && editDistance<editDistance2)
            return editDistance;
        else if(editDistance1<editDistance && editDistance1<editDistance2)
            return editDistance1;
        return editDistance2;
    }
}