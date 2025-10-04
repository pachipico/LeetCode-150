package lengthOfLastWord;

import java.util.regex.*;

public class LengthOfLastWord {

    // 4ms 걸림
    public int lengthOfLastWord(String s) {
        Matcher matcher = Pattern.compile("\\w+$").matcher(s.trim());
        if (matcher.find()) return matcher.group().length();
        else return 0;
    }


    // 3ms 걸림. 0ms 밖에 걸리지 않은 답이 있어 다른 방법을 찾아봐야겠음
    public int lengthOfLastWord2(String s) {
        return new StringBuilder(s.trim()).reverse().toString().split("\\s+")[0].length();
    }

    // 0ms 걸리는 답을 찾았다. 문자열은 그냥 문자열 그대로를 이용하는게 제일 빠른듯
    public int lengthOfLastWord3(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
