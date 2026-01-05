package stringPrograms;

public class stringToInteger {

/*    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

    The algorithm for myAtoi(string s) is as follows:

    Whitespace: Ignore any leading whitespace (" ").
    Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
    Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
    Return the integer as the final result.*/

    public static int myAtoi(String str){
        long num;
        char sign='\u0000';

        str = str.replaceFirst("^\\s","");
        if(str.charAt(0)=='+' || str.charAt(0)=='-') {
            sign = str.charAt(0);
            str = str.substring(1);
        }

        if(str.length()<=0 || str.matches("^[a-zA-Z].*")){
            return 0;
        }else{
                String s = "";
                for(Character c : str.toCharArray()){
                    if(Character.isDigit(c)) {
                        s = s + String.valueOf(c);
                        if(Long.parseLong(s) > Integer.MAX_VALUE){
                            num = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    else
                        break;
                }
            //num = Integer.parseInt(s); //need to parse in long, if value is too large will get error here
            num = Long.parseLong(s);
        }
        if(sign == '+'){
            num = +num;
        }else if(sign == '-'){
            num = -num;
        }

        if(num < Integer.MIN_VALUE) num = Integer.MIN_VALUE;
        else if (num > Integer.MAX_VALUE) {
            num = Integer.MAX_VALUE;
        }

        return Math.toIntExact(num);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" +42"));
        System.out.println(myAtoi(" -42"));
        System.out.println(myAtoi("2"));
        System.out.println(myAtoi("42_ac"));
        System.out.println(myAtoi("42ac"));
        System.out.println(myAtoi("ab_12"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("-20000000000000000000"));
        System.out.println(myAtoi("-91283472332"));
    }
}
