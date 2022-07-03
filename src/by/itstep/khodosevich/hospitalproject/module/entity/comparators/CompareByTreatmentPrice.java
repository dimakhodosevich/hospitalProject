package by.itstep.khodosevich.hospitalproject.module.entity.comparators;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.logic.Doctor;

import java.util.Comparator;

public class CompareByTreatmentPrice implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        double priceForFirstPerson = Doctor.getPriceForTreatment(o1);
        double priceForSecondPerson = Doctor.getPriceForTreatment(o2);
        return Double.compare(priceForFirstPerson, priceForSecondPerson);
    }
}
