package functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        System.out.println("========= Function =========");
        System.out.println(increment(2));
        System.out.println(incrementFunction.apply(2));

        System.out.println("\n========= BiFunction =========");
        System.out.println(multiplication(2,2));
        System.out.println(multiplicationBifunction.apply(2,2));
    }
    static int increment(int number){
        return number+1;
    }

    /**
     * Function Represent a function that accept one argument and produce result
     * First type is input and second is output
     */
    static Function<Integer,Integer> incrementFunction = number -> number + 1;

    static int multiplication(int number1, int number2){
        return number1 * number2;
    }

    /**
     * BiFunction Represent a function that accept two arguments and produce the result
     * T - First argument
     * U - Second argument
     * R - Output of function
     */

   static BiFunction<Integer, Integer, Integer>  multiplicationBifunction = (number1,number2) ->number1 * number2;
}
