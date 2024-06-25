package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Pruthviraj",Gender.MALE),
                new Person("Devedara",Gender.MALE),
                new Person("Khushbu",Gender.FEMALE)
        );

        // Printing Name
        personList.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // Printing Length
        personList.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // Functional Interface

        Function<Person,String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer print = System.out::println;

        personList.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(print);

        Predicate<Person> checkGender = person -> Gender.MALE.equals(person.gender);

       boolean male =  personList
                .stream()
                .allMatch(person -> Gender.MALE.equals(person.gender));
        System.out.println(male);

        // allMatch()
        boolean malePredicate = personList
                .stream()
                .allMatch(checkGender);
        System.out.println(malePredicate);

        // anyMatch()
        boolean maleMatch = personList
                .stream()
                .anyMatch(checkGender);
        System.out.println(maleMatch);

        // noneMatch()
        boolean maleNotMatch = personList
                .stream()
                .noneMatch(checkGender);
        System.out.println(maleNotMatch);
    }

    static class Person{
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender{
        MALE,
        FEMALE
    }
}
