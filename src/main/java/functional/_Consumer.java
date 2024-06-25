package functional;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        /**
         * Consumer represent functional interface that accept a single input argument and returns no result (simply void).
         */

        // Normal Function Calling
        getCustomer(new Customer("Pruthviraj","+917720993937"));

        // Consumer function calling
        message.accept(new Customer("Pruthviraj","+917720993937"));

        /**
         * BiConsumer represent functional interface that accept a two argument and return no result
         */

        messageBiconsumer.accept(new Customer("Pruthviraj","+917720993937"),true);
    }

    // Normal Function Calling
    static void getCustomer(Customer customer){
        System.out.println("Hello "+customer.name+ " thank you for register,"+ " your mobile number - "+customer.mobileNumber);
    }

    // Consumer Function
    static Consumer<Customer> message = customer ->  System.out.println("Hello "+customer.name+ " thank you for register,"+ " your mobile number - "+customer.mobileNumber);

    // BiConsumer Function
    static BiConsumer<Customer,Boolean> messageBiconsumer = (customer, isShow) ->  System.out.println("Hello "+customer.name+ " thank you for register,"+ " your mobile number - "+ (isShow? customer.mobileNumber : "*****"));
    static class Customer{
        private String name;
        private String mobileNumber;

        public Customer(String name, String mobileNumber) {
            this.name = name;
            this.mobileNumber = mobileNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", mobileNumber='" + mobileNumber + '\'' +
                    '}';
        }
    }
}
