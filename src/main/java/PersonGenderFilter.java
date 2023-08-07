package src.main.java;

public class PersonGenderFilter implements PersonFilter {

    private Person.Sex gender;

    public PersonGenderFilter(Person.Sex gender) {
        this.gender = gender;
    }

    @Override
    public boolean test(Person person) {
        return person.getGender() == gender;
    }
}
