package src.main.java;

public class LocalClassFilter implements PersonFilter{
    @Override
    public boolean test(Person person) {
        return false;
    }
}
