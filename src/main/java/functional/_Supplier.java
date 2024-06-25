package functional;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        /**
         * Represent Supplier of result
         * There is no requirement that a new or distinct result be returned each time supplier is invoked.
         * This is a functional interface whose functional method is get()
         */

        // Normal Function Call
        System.out.println(getDBConnectionURL());

        // Suppler Function Call
        System.out.println(getDBConnectionSupplier.get());
    }

    // Normal Function
    static String getDBConnectionURL(){
        return "jdbc://localhost:5432/users";
    }

    // Supplier Function
    // T - the type of results supplied by this supplier

    static Supplier<String> getDBConnectionSupplier = () -> "jdbc://localhost:5432/users";
}
