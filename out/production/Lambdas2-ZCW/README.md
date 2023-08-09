# Lambdas Exercise
Suppose that you are creating a social networking application. You want to create a feature that enables an administrator to perform any kind of action, such as sending a message, on members of the social networking application that satisfy certain criteria. The following table describes this use case in detail:

Suppose that members of this social networking application are represented by the following Person class:

```
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
    }

    public void printPerson() {
        // ...
    }
}
```

Suppose that the members of your social networking application are stored in a `List<Person>` instance.

### Approach 1: Create Methods That Search for Members That Match One Characteristic
One simplistic approach is to create several methods; each method searches for members that match one characteristic, such as gender or age. The following method prints members that are older than a specified age:

```
public static void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
        if (p.getAge() >= age) {
            p.printPerson();
        }
    }
}
```
### Approach 2: Create More Generalized Search Methods
The following method is more generic than printPersonsOlderThan; it prints members within a specified range of ages:

```
public static void printPersonsWithinAgeRange(
    List<Person> roster, int low, int high) {
    for (Person p : roster) {
        if (low <= p.getAge() && p.getAge() < high) {
            p.printPerson();
        }
    }
}
```
What if you want to print members of a specified sex, or a combination of a specified gender and age range? What if you decide to change the Person class and add other attributes such as relationship status or geographical location? Although this method is more generic than printPersonsOlderThan, trying to create a separate method for each possible search query can still lead to brittle code. You can instead separate the code that specifies the criteria for which you want to search in a different class.

### Approach 3: Specify Search Criteria Code in a Local Class

The following method prints members that match search criteria that you specify:

```
public static void printPersons(
    List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}
```

This method checks each Person instance contained in the List parameter roster whether it satisfies the search criteria specified in the CheckPerson parameter tester by invoking the method tester.test. If the method tester.test returns a true value, then the method printPersons is invoked on the Person instance.

To specify the search criteria, you implement the CheckPerson interface:

```
interface CheckPerson {
    boolean test(Person p);
}
```

### Your Mission
Using the 3rd approach, create a branch for each of the following implementations:

* Specify Search Criteria Code in a Local Class
* Specify Search Criteria Code in an Anonymous Class
* Specify Search Criteria Code with a Lambda Expression

**Don't forget your test!**