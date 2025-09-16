package model;

public class Pet {
    private String breed;
    private String name;
    private int age;

    public Pet() {
    }
    public Pet(String breed, String name, int age) {
        this.breed = breed;
        this.name = name;
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + breed + "), Age: " + age;
    }
}
