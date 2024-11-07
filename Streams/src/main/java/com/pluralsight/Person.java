package com.pluralsight;

import java.util.function.Consumer;
import java.util.function.Function;

public class Person {

    private String firstName;
    private String lastName;
    private  int age;

    public Person() {
    }

    public static void main(String[] args) {
        Function<Person, String> printPersonWithFormat = person -> "This is the Person: " + person;
        Person person1 = new Person("John", "Doe", 25);
        String apply = printPersonWithFormat.apply(person1);
        System.out.println(apply);
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
