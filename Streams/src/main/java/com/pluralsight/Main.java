package com.pluralsight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main<T> {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final Consumer<String> print = System.out::println;
//                               argument and print the argument
    private static final Predicate<Integer> isGreaterTen = data -> data > 10;
//                                 argument |   compare argument with fix data: 10
    private static final Function<List<Integer>, String> printNumbers = data -> "Numbers: " + data;
//                                 Argument,  returnType

    private static final Supplier<String> helloWorld = () -> "Hello world";
//                                return type
    private static final Function<Person, String> printPersonWithFormat = person -> "This is the Person: " + person;
//                               argument returnType            argument,  (return type)

    private static final UnaryOperator<Integer> square = (n) -> n * n;
//                                 argument and return types are same.  only one argument and return the operated value
    private static final BinaryOperator<Integer> add = (a, b) -> a + b;
//                                 argument and return types are same, only two argument and return the operated value based on the two argument

    private static final BiPredicate<String, Integer> isLengthGreaterThan = (s, length) -> s.length() > length;
//
    private static final BiConsumer<String, Integer> printMessage = (s, n) -> System.out.println(s + " " + n);
//                                  first argument, second argument.
    private static final BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
//                                  first argument, second argument, return type
    public static void main(String[] args) {

        Stream.empty();
        boolean test = isGreaterTen.test(10);
        String apply = printNumbers.apply(List.of(1, 2, 3, 4, 5));
        Integer apply1 = square.apply(5);
        String s = helloWorld.get();
        add.apply(5, 10);
        multiply.apply(5, 19);
        boolean test1 = isLengthGreaterThan.test("Hello", 9);


        System.out.println("BiPredicate: " + test1);
        System.out.println("UnaryOperator: " + apply1);
        System.out.println("Function: " + apply);
        System.out.println("Predicate: " + test);
        System.out.println("Supplier: " + s);


        // generates by GPT
        Person person1 = new Person("John", "Doe", 25);
        Person person2 = new Person("Jane", "Smith", 30);
        Person person3 = new Person("Michael", "Johnson", 45);
        Person person4 = new Person("Emily", "Davis", 35);
        Person person5 = new Person("Chris", "Brown", 28);
        Person person6 = new Person("Laura", "Wilson", 33);
        Person person7 = new Person("Daniel", "Moore", 22);
        Person person8 = new Person("Sophia", "Taylor", 40);
        Person person9 = new Person("James", "Anderson", 29);
        Person person10 = new Person("Olivia", "Thomas", 27);
        List<Person> people = List.of(person1, person2, person3, person4, person5, person6, person7, person8, person9, person10);
//        logger.info("Loading people data: " + people);
//        findPersonByName(people);
        getAverageAge(people);
//        getOldestAge(people);
//        getYoungestAge(people);

    }




    private static void getOldestAge(List<Person> people) {
        people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .ifPresent(person -> print.accept(
                        "Person with oldest age: " + person.getFirstName() + " " + person.getLastName() + ", Age: " + person.getAge()
                ));
    }

    private static void getYoungestAge(List<Person> people) {
        people.stream()
                .min(Comparator.comparingInt(Person::getAge))
                .ifPresent(person -> print.accept(
                        "Person with youngest age: " + person.getFirstName() + " " + person.getLastName() + ", Age: " + person.getAge()
                ));
    }

    private static void getAverageAge(List<Person> people) {
        OptionalDouble average = people.stream()
                .mapToInt(Person::getAge)
                .average();

        int aveAge = people.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);

//        aveAge.ifPresentOrElse(print.accept("Found") () -> print.accept("not found"));

        print.accept( "Average age:  "+ aveAge.get() / people.size());

        average.ifPresentOrElse(
                averageAge -> print.accept("Average age: " + averageAge),
                () -> print.accept("No people in the list to calculate an average age"));
    }
    

    private static void findPersonByName(List<Person> people) {
        String firstName = inputString("Enter your first name: ");
        String lastName = inputString("Enter your last name: ");
        people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName))
                .forEach(System.out::println);
    }

    public static String inputString(String prompt) {
        System.out.println(prompt);
        String value = "";
        try {
            value = scanner.nextLine().trim();
        } catch (Exception e) {
            logger.error("Invalid Input!");
        }

        return value;
    }


}