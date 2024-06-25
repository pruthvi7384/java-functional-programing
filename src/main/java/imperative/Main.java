package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Pruthviraj",Gender.MALE),
                new Person("Khushbu",Gender.FEMALE),
                new Person("Devendra",Gender.MALE),
                new Person("Shivani",Gender.FEMALE)
        );

        /**
         * Imperative Approach
         */
        System.out.println("============= Imperative Approach ==============\n");

        List<Person> malePerson = new ArrayList<>();
        for (Person person : people){
            if(Gender.MALE.equals(person.gender)){
                malePerson.add(person);
            }
        }
        System.out.println("MALE_PERSONS");
        for (Person male : malePerson){
           System.out.println(male);
        }

        List<Person> femalePerson = new ArrayList<>();
        for (Person person : people){
            if(Gender.FEMALE.equals(person.gender)){
                femalePerson.add(person);
            }
        }
        System.out.println("\nFEMALE_PERSONS");
        for (Person female : femalePerson){
            System.out.println(female);
        }

        /**
         * Declarative Approach
         */
        System.out.println("\n============= Declarative Approach ==============\n");
        List<Person> maleDeclarative =  people.stream().filter(person -> Gender.MALE.equals(person.gender)).collect(Collectors.toList());
        System.out.println("MALE_PERSONS\n"+maleDeclarative);

        List<Person> femaleDeclarative =  people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).collect(Collectors.toList());
        System.out.println("\nFEMALE_PERSONS\n"+femaleDeclarative);

        System.out.println("\n======== For Each Loop ===========");
        people.stream().filter(person -> Gender.MALE.equals(person.gender)).forEach(person -> System.out.println(person));

        people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).forEach(person -> System.out.println(person));

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
        FEMALE,MALE
     }
}