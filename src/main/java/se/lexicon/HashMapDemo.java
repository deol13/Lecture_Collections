package se.lexicon;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,String> concatHashMap = new HashMap<>();
        concatHashMap.put("Simon","simon@lexicon.se");
        concatHashMap.put("Ulf","ulf@lexicon.se");
        concatHashMap.put("Mehrdad","mehrdad@lexicon.se");

        System.out.println(concatHashMap.get("Mehrdad"));

        HashMap<Integer,Person> concatHashMap2 = new HashMap<>();
        concatHashMap2.put(1, new Person(1, "test", "test@lexicon.se"));
    }
}
