package interview.algorithm.string;

import java.util.Stack;

/**
 * Created by chenjianhua on 2014/11/25 0025.
 *
 *   The problem:

     Evaluate the value of an arithmetic expression in Reverse Polish Notation.

     Valid operators are +, -, *, /. Each operand may be an integer or another expression.

     Some examples:
     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {
    public static void main(String []args){
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));

    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        String oprates = "+-*/";
        for(String entry : tokens){
            if(oprates.indexOf(entry.toString()) > -1){
                if(stack.size()>1){
                    stack.push(performCalculate(stack.pop(), stack.pop(), entry));
                }
            }else{
                stack.push(Integer.parseInt(entry));
            }
        }
        return stack.pop();
    }

    public static int performCalculate(int num1,int num2,String oprate){
        if (oprate.equals("+")) {
            return num1 + num2;

        } else if (oprate.equals("-")) {
            return num1 - num2;

        } else if (oprate.equals("*")) {
            return num1 * num2;

        } else if (oprate.equals("/")) {
            return num1 / num2;

        }
        return 0;
    }
}
