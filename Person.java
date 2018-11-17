package ru.yazgevich.se;

public class Person {

    private String fullname;

    private String position;

    private String email;

    private String phonenumber;

    private int salary;

    private int age;

    public Person(String fullname, String position, String email, String phonenumber, int salary, int age) {
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phonenumber = phonenumber;
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Yazgevich Anton", "Storekeeper", "yazgevich@mail.ru", "7770777", 28000, 29);
        persArray[1] = new Person("Ivanov Ivan","Engineer","ivan@mail.ru","251700",30000,25);
        persArray[2] = new Person("Petrov Petr","Policeman","sawauzarepost@.mail.ru","002",10000,67);
        persArray[3] = new Person("Pushkin Alexander","Writer","pushkin@mail.ru","123123",50000,37);
        persArray[4] = new Person("Lenin Vladimir","Dux","vechnomolodoi@mail.ru","111111",0,100500);
        printOldPerson(persArray);
    }

    @Override
    public String toString (){
        return ("\nFULLNAME - " + fullname + "\nPOSITION - " + position + "\nEMAIL - " + email + "\nPHONE NUMBER - " + phonenumber + "\nAGE - " + age);
    }

    public static void printOldPerson(Person[] persArray){
        for (int i = 0; i < persArray.length;i++){
            if (persArray[i].age > 40) System.out.println(persArray[i]);
        }
    }
}

