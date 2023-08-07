package src.main.java;

public class PersonAgeFilter implements PersonFilter {
    private int high;
    public int low;

    public PersonAgeFilter(int low, int high) {
        this.high = high;
        this.low = low;
    }

    @Override
    public boolean test(Person person) {
        return low <= person.getAge() && person.getAge() < high;
    }
}
