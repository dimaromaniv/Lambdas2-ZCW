package src.java.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.main.java.Person;
import src.main.java.PersonAgeFilter;
import src.main.java.PersonGenderFilter;
import src.main.java.PersonsList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    ArrayList<Person> listTest;

    @Test
    void printPersonToString() {
        Person person = new Person("name", LocalDate.of(2000, 2, 2), Person.Sex.MALE, "Email.address");
        PersonsList list = new PersonsList();
        list.addPerson(person);
        String expected = "Name: name,Gender: MALE,Age :23";
        String actual = list.printPersonToString(person);
        Assert.assertEquals(expected, actual);
    }
    @Test
    void printPerson() {
        Person person = new Person("name", LocalDate.of(2000, 2, 2), Person.Sex.MALE, "Email.address");
        PersonsList list = new PersonsList();
        list.addPerson(person);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        list.printPerson(person);

        System.setOut(System.out);

        String expectedOut = "Name: name\n" +
                "Birthday: 2000-02-02\n" +
                "Gender: MALE\n" +
                "Email: Email.address\n";

        Assert.assertEquals(expectedOut, outputStream.toString());
    }

    @Test
    void printPersonsOlderThanToString() {
        PersonsList list = new PersonsList();
        Person person = new Person("name", LocalDate.of(2000, 2, 2), Person.Sex.MALE, "Email.address");
        Person person1 = new Person("name1", LocalDate.of(2010, 2, 2), Person.Sex.FEMALE, "Email.address");
        list.addPerson(person);
        list.addPerson(person1);
        String expected = "Name: name,Gender: MALE,Age :23";
        String actual  = list.printPersonsOlderThanToString(18);
        Assert.assertEquals(expected,actual);

    }

    @Test
    void printPersonsOlderThan() {
        PersonsList list = new PersonsList();
        Person person = new Person("name", LocalDate.of(2000, 2, 2), Person.Sex.MALE, "Email.address");
        Person person1 = new Person("name1", LocalDate.of(2010, 2, 2), Person.Sex.FEMALE, "Email.address");
        list.addPerson(person);
        list.addPerson(person1);


        int expected = 1;
        int actual = list.printPersonsOlderThan(20).size();


        Assert.assertEquals(expected,actual);

    }

    @Test
    void testMachingMethodAge() {
        PersonsList list = new PersonsList();
        Person person = new Person("name", LocalDate.of(2000, 2, 2), Person.Sex.MALE, "Email.address");
        Person person1 = new Person("name1", LocalDate.of(2010, 2, 2), Person.Sex.FEMALE, "Email.address");
        list.addPerson(person);
        list.addPerson(person1);
        list.printMatchingPerson(new PersonAgeFilter(15,30));
        //list.printMatchingPersons(new PersonGenderFilter(Person.Sex.MALE));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        list.printMatchingPerson(new PersonAgeFilter(15,30));

        //list.printMatchingPersons(new PersonGenderFilter(Person.Sex.MALE));


        String expected = "Name: name\n" +
                "Birthday: 2000-02-02\n" +
                "Gender: MALE\n" +
                "Email: Email.address\n";

        Assert.assertEquals(expected, outputStream.toString());
    }

    @Test
    void testMachingMethodGender() {

        //given
        PersonsList list = new PersonsList();
        Person person = new Person("name", LocalDate.of(2000, 2, 2), Person.Sex.MALE, "Email.address");
        Person person1 = new Person("name1", LocalDate.of(2010, 2, 2), Person.Sex.FEMALE, "Email.address");
        list.addPerson(person);
        list.addPerson(person1);
        //When

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        list.printMatchingPerson(new PersonGenderFilter(Person.Sex.MALE));


        Person expectedPerson =  person;
        //list.addPerson(expected);
        ByteArrayOutputStream newOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutput));
        list.printPerson(expectedPerson);

        Assert.assertEquals(newOutput.toString(),outputStream.toString());
    }

}