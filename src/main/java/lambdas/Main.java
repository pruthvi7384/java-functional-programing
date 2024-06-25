package lambdas;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        /**
         * Lambdas Function
         */
        Function<String,String> upperCaseName  = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };
        System.out.println(upperCaseName.apply("Pruthviraj"));
    }

    /**
     * Pure function programming has set of rule
     * No State
     * No Side Function
     * Higher Order Functions
     * The function takes one or more functions s parameters
     * The function returns another function as result
     */
}
