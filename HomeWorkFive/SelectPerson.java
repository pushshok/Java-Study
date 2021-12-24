package ru.geekbrains.home_work_app;
import ru.geekbrains.home_work_app.Person;

public class SelectPerson {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person("Petrov Pavel", "Teacher", "pepavel@mailbox.com", "892312334", 30000, 25);
        persArray[2] = new Person("Sidorov Ivan", "Manager", "siivan@mailbox.com", "8923124512", 30000, 40);
        persArray[3] = new Person("Volkov Vladimir", "Worker", "vovlad@mailbox.com", "892312319", 30000, 20);
        persArray[4] = new Person("Zaycev Stas", "Programmer", "zastas@mailbox.com", "892372312", 30000, 55);

        for (Person person : persArray) {
            if (person.getAge() >= 40) {
                System.out.println(person);
            }
        }
    }
}
