package interview.algorithm.string;

/**
 * Created by chenjianhua on 2014/11/25 0025.
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

    Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
    public static void main(String args[]){
        System.out.println(new MultiplyStrings().multiplyStrings("9999999999999999","3333333423423423"));
    }

    public String multiplyStrings(String num1, String num2){
        try{
            Long arg1 = Long.parseLong(num1);
            Long arg2 = Long.parseLong(num2);
            Long result = arg1 * arg2;
            return result.toString();
        }catch (NumberFormatException e){
            throw e;
        }
    }
}
