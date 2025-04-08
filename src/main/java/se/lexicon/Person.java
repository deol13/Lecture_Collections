package se.lexicon;

public class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Person newObj = (Person) obj;
        return newObj.id == id && newObj.name.equals(name) && newObj.email.equals(email);
    }

    @Override
    public String toString() {
        return "Person " +
                "ID: " + id +
                ", Name: " + name +
                ", Email: " + email;
    }
}
