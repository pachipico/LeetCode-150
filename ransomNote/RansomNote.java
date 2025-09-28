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




    public static void main(String[] args) {


    }

}
