package combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class CustomerValidatorService {
    private final Predicate<String> isEmailValid = email -> email.contains("@");
    private final Predicate<String> isMobileNumberValid = number -> number.length() == 10;
    private final Predicate<LocalDate> isAdult = localDate -> Period.between(localDate,LocalDate.now()).getYears()>16;

    public Predicate<Customer> isValid = customer -> isAdult.test(customer.getDob()) && isMobileNumberValid.test(customer.getMobileNumber()) && isEmailValid.test(customer.getEmail());
}
