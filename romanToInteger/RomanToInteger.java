package romanToInteger;

import java.util.*;
import java.util.stream.IntStream;

public class RomanToInteger {

    // 7ms 걸린 첫번째 풀이
    public int romanToInt(String s) {
        Map<String, Integer> romanMap = Map.of("M", 1000, "D", 500, "C", 100, "L", 50, "X", 10, "V", 5, "I", 1);
        List<Integer> list = Arrays.stream(s.split("")).mapToInt(romanMap::get).boxed().toList();
        int res = 0;
//        System.out.println("list: " + list);
        for (int i = 0; i < list.size(); i++) {


            if (i != 0 && list.get(i - 1) < list.get(i)) {
                res -= list.get(i - 1);
                res += list.get(i) - list.get(i - 1);
            } else {
                res += list.get(i);
            }

        }

        return res;
    }

    // 7ms 걸린 두번째 풀이(IntStream을 써보고 싶었음)
    public int romanToInt2(String s) {
        Map<String, Integer> romanMap = Map.of("M", 1000, "D", 500, "C", 100, "L", 50, "X", 10, "V", 5, "I", 1);
        List<Integer> list = Arrays.stream(s.split("")).mapToInt(romanMap::get).boxed().toList();

//        System.out.println("list: " + list);

        return IntStream.range(0, list.size()).map(i -> {
            int res = 0;
            if (i != 0 && list.get(i - 1) < list.get(i)) {
                res -= list.get(i - 1);
                res += list.get(i) - list.get(i - 1);
            } else {
                res += list.get(i);
            }
            return res;
        }).sum();
    }

    // 5ms가 걸린 모범답안. 매번 더할 필요 없이 뒤의 문자보다 클때만 더하게 하면 됬었다.
    public int bestPractice(String s) {

        Map<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int total = 0;

        for(int i=0;i<s.length();i++)
        {
            int value = map.get(s.charAt(i));

            if(i+1 < s.length() && value < map.get(s.charAt(i+1)))
            {
                total = total - value;
            }else
            {
                total = total + value;
            }
        }
        return total;
    }

}
