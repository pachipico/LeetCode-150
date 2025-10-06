package reverseWordsInAString;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseWordsInAString {

    // 12ms 가 걸린 첫번째 풀이
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.stream(split).toList());
        List<String> list = new LinkedList<>();

        while (!queue.isEmpty()){

            list.add(queue.removeLast());

        }

        return list.stream().collect(Collectors.joining(" "));
    }

    // 11ms 가 걸린 두번째 풀이
    public String reverseWords2(String s) {
        String[] split = s.trim().split("\\s+");
        s = "";
        for (int i = split.length-1; i >= 0; i--) {
            s += (split[i] + " ");
        }
        return s.trim();
    }


}
