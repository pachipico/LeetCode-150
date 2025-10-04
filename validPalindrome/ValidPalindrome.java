package validPalindrome;

import java.util.Arrays;

public class ValidPalindrome {


    // 115ms 걸림
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("replaceAll: " + s);

        String[] split = s.split("");
        for (int i = 0; i < split.length/2; i++) {

            System.out.println(i + ": " + split[i] + ", " + (split.length - i) + ": " + split[split.length - i - 1]);

            if(!split[i].equals(split[split.length - i - 1])) return false;
        }

        return true;
    }

    // 15ms 걸림
    public boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("replaceAll: " + s);

        boolean isOdd = s.length()%2 > 0;
        String first = s.substring(0, s.length()/2);
        String last  = s.substring(isOdd ? s.length()/2 + 1 : s.length()/2);
        String reverse = new StringBuilder(first).reverse().toString();

        System.out.println("first: " + first);
        System.out.println("last: " + last);
        System.out.println("reverse: " + reverse);


        return last.equals(reverse);
    }

}
