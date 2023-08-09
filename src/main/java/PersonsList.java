package src.main.java;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersonsList {
    private ArrayList<Person> list;

    public PersonsList() {
        this.list = new ArrayList<Person>();
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public void addPerson(Person person) {
        list.add(person);
    }

    public String printPersonsOlderThanToString(int age) {
        String result = "";
        for (Person p : list) {
            if (p.getAge() >= age) {
                result += printPersonToString(p);
            }
        }
        return result.isEmpty() ? "" : result;
    }

    public ArrayList<Person> printPersonsOlderThan(int age) {
        ArrayList<Person> result = new ArrayList<>();
//        for (Person p : list) {
//            if (p.getAge() >= age) {
//                result.add(p);
//            }
//        }
       return list.stream()
                .filter(person -> age <= person.getAge())
                .collect(Collectors.toCollection(ArrayList::new));
        //return result;

    }

    public String printPersonToString(Person person) {
        return "Name: " + person.getName() + ",Gender: " + person.getGender() + ",Age :" + person.getAge();
    }

    public void printPerson(Person person) {

        if (list.contains(person)) {
            System.out.println("Name: " + person.getName());
            System.out.println("Birthday: " + person.getBirthday());
            System.out.println("Gender: " + person.getGender());
            System.out.println("Email: " + person.getEmailAddress());;
        }
    }

    public void printPersonsWithinAgeRange( int low, int high) {
//        for (Person p : list) {
//            if (low <= p.getAge() && p.getAge() < high) {
//                printPerson(p);
//            }
//        }

        list.stream()
                .filter(person -> low <= person.getAge() && person.getAge() < high)
                .forEach(this::printPerson);
    }
    public void printMatchingPerson(PersonFilter filter) {
//        for (Person p : list) {
//            if (filter.test(p)){
//                printPerson(p);
//            }
//        }

        list.stream()
                .filter(filter::test)
                .forEach(this::printPerson);
    }


//        public String printPersonsOlderThan( int age) {
//        ArrayList <String> result  = new ArrayList<>();
//        for (Person p : list) {
//            if (p.getAge() >= age) {
//                result.add(printPerson());
//            }
//        }
//        return result.toString();
//    }

    PersonFilter personFilter = new PersonFilter() {
        @Override
        public boolean test(Person person) {
            return person.getAge() == -1;
        }
    };

}
