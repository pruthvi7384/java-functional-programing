package combinator;

import java.time.LocalDate;

import static combinator.CustomerValidator.*;

public class Main {
    public static void main(String[] args) {
            Customer customer = new Customer(
                    "Alice",
                    "alice@gmail.com",
                    "1234567890",
                    LocalDate.of(2000,5,30)
            );

        System.out.println(new CustomerValidatorService().isValid.test(customer));

        // Using Combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
