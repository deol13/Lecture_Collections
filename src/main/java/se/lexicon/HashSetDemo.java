package se.lexicon;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        //ex1();
        ex2();
    }

    public static void ex1(){
        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Cherry");

        System.out.println("fruits = " + fruits);
        System.out.println(fruits.size());
    }

    public static void ex2(){
        HashSet<Person> people = new HashSet<>();
        people.add(new Person(1, "Dennis", "dennis@test.se"));
        people.add(new Person(3, "Alice", "alice@test.se"));
        people.add(new Person(2, "Alice", "alice@xyz.se"));
        people.add(new Person(2, "Alice", "alice@xyz.se"));
        // **Override equal and hashCode** methods to allow proper handling of duplicates in HashSet

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
