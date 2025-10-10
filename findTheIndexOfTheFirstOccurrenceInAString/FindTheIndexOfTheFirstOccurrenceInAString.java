package findTheIndexOfTheFirstOccurrenceInAString;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    // 0ms 걸린 첫번째 풀이 - if문도 필요가 없었네
    public int strStr(String haystack, String needle) {

//        if(!haystack.contains(needle)) return -1;
        return haystack.indexOf(needle);
    }

}
