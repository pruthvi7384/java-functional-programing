package functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        /**
         * Predicate is function interface boolean value function of one argument
         * Predicate is test object
         */

        // Normal Function Call
        System.out.println(validPhoneNumber("0734567890"));

        // Predicate Function Call
        System.out.println(validPhoneNumberUsing.test("0712345678"));

        /**
         * BiPredicate is functional interface boolean value function of two arguments
         */

        // Normal Function Call
        System.out.println(check("pruthviraj","pruthviraj"));

        // BiPredicate Function Call
        System.out.println(checkBipredicate.test("pruthviraj","devendra"));
    }

    // Normal Function
    static Boolean validPhoneNumber(String number){
        return number.startsWith("07") && number.length() == 10;
    }

    static Boolean check(String userName, String usernameCheck){
        return userName.equalsIgnoreCase(usernameCheck);
    }

    // Predicate Function
    static Predicate<String> validPhoneNumberUsing = number -> number.startsWith("07") && number.length() == 10;

    // BiPredicate Function
    static BiPredicate<String,String> checkBipredicate = (username,checkUsername)->username.equalsIgnoreCase(checkUsername);
}
