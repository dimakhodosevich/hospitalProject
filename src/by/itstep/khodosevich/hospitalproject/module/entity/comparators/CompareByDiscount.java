package by.itstep.khodosevich.hospitalproject.module.entity.comparators;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;

import java.util.Comparator;

public class CompareByDiscount implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Double.compare(o1.getDiscount().getDiscountValue(),o2.getDiscount().getDiscountValue());
    }
}
