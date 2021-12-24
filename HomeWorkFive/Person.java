package ru.geekbrains.home_work_app;

public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    Person(String fullName, String position, String email, String phone, float salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return ("Full Name: " + fullName + "; Position: " + position + "; Email: " + email + "; Phone: " + phone + "; Salary: " + salary + "; Age: " + age);
    }
}
