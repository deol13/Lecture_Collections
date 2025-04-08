package se.lexicon;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>(); // [0]
        ArrayList<Integer> numbers = new ArrayList<>(); // [0]
        // int -> Integer : A wrapper class of int. All primitiv datatypes have them

        //ex1();
        //ex2();
        //ex3();
        //ex4();
        //ex5();
        ex6();
    }

    public static void ex1() {
        ArrayList<String> bookNames = new ArrayList<>();
        bookNames.add("Java");
        bookNames.add("Java");
        bookNames.add("Spring");
        bookNames.add("React");
        bookNames.add("Clean Code");
        bookNames.add("OCP");
        bookNames.add("OCP");

        // [Java, Java, Spring, React, Clean Code, OCP, OCP]
        System.out.println(bookNames); // the same as bookNames.toString()
        System.out.println(bookNames.size());

        System.out.println(bookNames.get(0)); // Java
        System.out.println(bookNames.get(1)); // Java
        System.out.println(bookNames.get(2)); // Spring
        //System.out.println(bookNames.get(10)); // Throws IndexOutOfBoundsException

        System.out.println("--------------");

        Iterator<String> iterator = bookNames.iterator();
        while (iterator.hasNext()) {
            String bookName = iterator.next();
            if (bookName.equals("OCP"))
                iterator.remove();
        }

        System.out.println("--------------");

        for (String bookName : bookNames) {
            System.out.println(bookName);
        }

        for (int i = 0; i < bookNames.size(); i++) {
            System.out.println(bookNames.get(i));
        }
    }

    public static void ex2() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(100);
        numbers.add(400);
        numbers.add(300);
        numbers.add(200);

        System.out.println(numbers.size()); // 5
        boolean isRemoved = numbers.remove(Integer.valueOf(100));
        System.out.println("isRemoved = " + isRemoved);
        System.out.println(numbers.size()); // 4
        Integer removedNumber = numbers.remove(2);
        System.out.println("removedNumber = " + removedNumber);
        System.out.println(numbers.size()); // 3
    }

    public static void ex3() {
        ArrayList<String> euCars = new ArrayList<>();
        euCars.add("Volvo");
        euCars.add("BWM");
        euCars.add("Volvo");
        // "Tesla"

        ArrayList<String> usaCars = new ArrayList<>();
        usaCars.add("Tesla");

        // By default it adds the other array at the end.
        //euCars.addAll(usaCars);
        // But you can make it start anywhere, here it starts at index one
        euCars.addAll(1, usaCars);

        System.out.println("euCars = " + euCars);
        System.out.println(euCars.indexOf("Volvo"));
        System.out.println(euCars.lastIndexOf("Volvo"));
    }

    public static void ex4(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);
        System.out.println("Original List : " + numbers);

        Collections.sort(numbers); // All elements in the list must implement the Comparable
        System.out.println("Sorted List : " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffle : " + numbers);

        numbers.sort(Comparator.naturalOrder());
        System.out.println("Sorted List 2 : " + numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse Sorted List : " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffle : " + numbers);

        numbers.sort(Collections.reverseOrder());
        System.out.println("Reverse Sorted List 2 : " + numbers);
    }

    public static void ex5(){
        Person2 person1 = new Person2(1, "Mehrdad", "mehrdad.javan@lexicon.se");
        Person2 person2 = new Person2(1, "Mehrdad", "mehrdad.javan@lexicon.se");

        // Equal method by default will compare the reference number aka the position in the memory the objects data is stored.
        // And since these are two objects those are different.
        boolean isEqualTwoPersons = person1.equals(person2); // false if the Object class equal is used.

        // Object class's toString will return the name of the class and the objects hashcode.
        // person1 and person2 have different hashcode because the default hashcode uses the reference number.
        System.out.println(person1.toString());
        System.out.println(person2.toString());

        String test1 = "TEST";
        String test2 = "TEST";
        System.out.println(test1.equals(test2)); //String and custom objects should always use equals.

        int num1 = 100;
        int num2 = 100;
        boolean isEqualNumbers = num1 == num2;
    }

    public static void ex6(){
        ArrayList<Person> people = new ArrayList<>();
        Person person1 = new Person(3, "John", "john@test.se");
        people.add(person1);
        people.add(new Person(1, "Dennis", "dennis@test.se"));
        people.add(new Person(4, "Björn", "björn@test.se"));
        people.add(new Person(2, "Gunilla", "gunilla@test.se"));

        System.out.println("-------------");
        System.out.println("Original List: ");
        for (Person person : people) {
            System.out.println(person);
        }

        // Comparator
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getId(), o2.getId()); // Ascending Order
            }
        });

        // if o1.getId < o2.getId -> returns a negative number = o1 should come before o2
        // if o1.getId == o2.getId -> returns a zero = both are considered equal
        // if o1.getId > o2.getId -> returns a positive number = o1 should come after o2

        //Lambda expressions: Both gets the same result:
        //Collections.sort(people, (o1,o2) -> Integer.compare(o1.getId(), o2.getId()));
        //Collections.sort(people, Comparator.comparingInt(Person::getId));

        System.out.println("-------------");
        System.out.println("Sorted List by id: ");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
