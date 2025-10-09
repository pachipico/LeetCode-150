package longestCommonPrefix;

import java.util.Arrays;
import java.util.regex.Pattern;

public class LongestCommonPrefix {

    // 7ms 걸린 첫번째 풀이.
    public String longestCommonPrefix(String[] strs) {
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            Pattern pattern = Pattern.compile("^" + firstStr.substring(0, i + 1));
            if (!Arrays.stream(strs).allMatch(str -> pattern.matcher(str).find())) return firstStr.substring(0, i);
        }
        return firstStr;
    }

    // 1ms 걸린 두번쨰 풀이. 굳이 모든 단어를 비교할 필요 없이 하나라도 맞지 않으면 멈추도록 다시 풀이했다.
    public String longestCommonPrefix2(String[] strs) {
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            String prefix = firstStr.substring(0, i + 1);
            for (int j = 0; j < strs.length; j++) {
                if(!strs[j].startsWith(prefix)) return prefix.substring(0, i);
            }
        }
        return firstStr;
    }

}
