package integerToRoman;

import java.text.DecimalFormat;
import java.util.Map;

public class IntegerToRoman {

    // 11ms 가 걸린 첫번째 풀이
    public String intToRoman(int num) {
        int thousand = num / 1000;
        num -= thousand * 1000;
        int hundred = num / 100;
        num -= hundred * 100;
        int ten = num / 10;
        num -= ten * 10;

        return compute(thousand, 1000) + compute(hundred, 100) + compute(ten, 10) + compute(num, 1);
    }

    public String compute(int digit, int times) {

        Map<Integer, String> romanMap = Map.of(1000, "M", 500, "D", 100, "C", 50, "L", 10, "X", 5, "V", 1, "I");

        StringBuilder res = new StringBuilder();

        if (digit == 9) {
            res.append(romanMap.get(times)).append(romanMap.get(10 * times));
        } else if (digit > 5) {
            int i = digit - 5;
            res.append(romanMap.get(5 * times)).append(romanMap.get(times).repeat(i));
        } else if (digit == 5) {
            res.append(romanMap.get(5 * times));
        } else if (digit == 4) {
            res.append(romanMap.get(times)).append(romanMap.get(5 * times));
        } else if (digit >= 1) {
            res.append(romanMap.get(times).repeat(digit));
        }
//        System.out.println(res.toString());

        return res.toString();
    }

    // 3ms 걸리는 모범답안. 이렇게 접근할 생각 조차 못했는데 때로는 간결한 생각이 좀더 효율적인 결과를 낼 수 있는것 같다.
    public String intToRoman2(int num) {
        int val[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
        String[] map = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "II", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < val.length; i++) {
            if (num == 0) {
                break;
            }
            while (num >= val[i]) {
                sb.append(map[i]);
                num -= val[i];
            }
        }
        return sb.toString();
    }


}
