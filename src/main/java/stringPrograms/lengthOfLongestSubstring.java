package stringPrograms;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    //Given a string s, find the length of the longest substring without duplicate characters.

    public static int longestSubStr(String str){
    int maxLength = 0;
    int left=0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for(int right=0; right<str.length(); right++){
        char ch = str.charAt(right);
        if(map.containsKey(ch) && map.get(ch)>=left){
            left = map.get(ch)+1;
        }
        map.put(ch, right);
        maxLength = Math.max(maxLength, right-left+1);
    }
    return maxLength;
    }

    public static void main(String[] args) {

        System.out.println("length of longest substring of "+"abcabc is :"+longestSubStr("abcabc"));
        System.out.println("length of longest substring of "+"abcd is :"+longestSubStr("abcd"));
        System.out.println("length of longest substring of "+"pwwkew is :"+longestSubStr("pwwkew"));
        System.out.println("length of longest substring of "+"bbbb is :"+longestSubStr("bbbb"));
    }
}
