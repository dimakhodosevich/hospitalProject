package by.itstep.khodosevich.hospitalproject.module.entity.comparators;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;

import java.util.Comparator;

public class CompareByDisease implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDisease().getDamage()-o2.getDisease().getDamage();
    }
}
