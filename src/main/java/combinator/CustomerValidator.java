package combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerValidator extends Function<Customer, CustomerValidator.ValidationResult> {

    static CustomerValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }
    static CustomerValidator isPhoneNumberValid(){
        return customer -> customer.getMobileNumber().length() == 10 ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }
    static CustomerValidator isAdult(){
        return customer -> Period.between(customer.getDob(),LocalDate.now()).getYears()>16 ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    default CustomerValidator and (CustomerValidator other){
        return customer -> {
           ValidationResult result = this.apply(customer);
           return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }
    static
    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
