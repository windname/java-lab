package com.vg.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambda {
    
    private enum Gender  { MALE, FEMALE }
   
    private static class Person {
       
        private final String name;
        private final int age;
        private final Gender gender;
       
        public Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
       
        public String getName() {
            return name;
        }
       
        public int getAge() {
            return age;
        }
       
        public Gender getGender() {
            return gender;
        }
    }
   
   
    public static void main(String[] args) {       
        List persons = new ArrayList<Person>();
        persons.add(new Person("Albert", 80, Gender.MALE));
        persons.add(new Person("Ben", 15, Gender.MALE));
        persons.add(new Person("Charlote", 20, Gender.FEMALE));
        persons.add(new Person("Dean", 6, Gender.MALE));
        persons.add(new Person("Elaine", 17, Gender.FEMALE));
       
        // How much code would you need to do the following without Lambdas?
        System.out.println("----------Printing Persons with age less than 18----------");
        printNames(persons, p -> p.getAge() < 18);
        System.out.println("\n--------Printing all Males-------------");
        printNames(persons, p -> p.getGender() == Gender.MALE);
        System.out.println("\n---------Printing Persons with Names starting With C------------");
        printNames(persons, p -> p.getName().startsWith("C"));
       
    }
   
private static void printNames(List<Person> persons, Predicate<Person> predicate) {
        persons.stream()
                .filter(predicate)
                .map(p -> p.getName())
                .forEach(name -> System.out.println(name));
    }
   
}
