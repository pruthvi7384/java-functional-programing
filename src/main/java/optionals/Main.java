package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "DEFAULT VALUE");
        System.out.println(value);

        Object value1 = Optional.ofNullable("Hello")
                .orElseGet(() -> "DEFAULT VALUE");
        System.out.println(value1);

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Send email now "+email),() -> System.out.println("Can not send email"));
    }
}
