package ransomNote;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RansomNote {


    // 1차 풀이 - 결과가 별로임.
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Long> magazineMap = Arrays.stream(magazine.split("")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        Map<String, Long> ransomNoteMap = Arrays.stream(ransomNote.split("")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        for (Map.Entry<String, Long> entry : ransomNoteMap.entrySet()) {
            String word = entry.getKey();
            Long count = entry.getValue();
            Long magazineCount = magazineMap.getOrDefault(word, 0L);

            if(count > magazineCount) return false;
        }

        return true;
    }

    // 두번째 풀이도 결과가 별로임.
    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] magazineArr = magazine.toCharArray();

        System.out.println("initial ransomNote: [" + ransomNote + "]");
        for (int i = 0; i < magazineArr.length; i++) {

            System.out.println("replacing " + magazineArr[i]);

            ransomNote = ransomNote.replaceFirst(String.valueOf(magazineArr[i]), "");
            System.out.println("ransomNote: " + ransomNote);
        }

        System.out.println("res: " + ransomNote);

        return ransomNote.isBlank();
    }



    public static void main(String[] args) {


    }

}
