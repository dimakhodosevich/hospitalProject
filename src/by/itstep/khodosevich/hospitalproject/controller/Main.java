package by.itstep.khodosevich.hospitalproject.controller;

import by.itstep.khodosevich.hospitalproject.module.entity.comparators.CompareByAge;
import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.*;
import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Student;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Worker;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person s1 = new Worker("Dima Khodosevich", 27, 50, Disease.NO_DISEASE, new ArrayDynamicContainer<>(),
                Discount.WITHOUT_DISCOUNT, 80, "engineer");

        Person s2 = new Worker("Andrey Khodosevich", 28, 50, Disease.NO_DISEASE, new ArrayDynamicContainer<>(),
                Discount.WITHOUT_DISCOUNT, 80, "engineer");

        Person s3 = new Worker("Bad Khodosevich", 29, 50, Disease.NO_DISEASE, new ArrayDynamicContainer<>(),
                Discount.WITHOUT_DISCOUNT, 80, "engineer");


        Person s4 = new Student("Vova Khodosevich", 30, 50, Disease.NO_DISEASE, new ArrayDynamicContainer<>(),
                Discount.WITHOUT_DISCOUNT, 50, "BNTU");

        TreeSet<Person> treeSet = new TreeSet<>(new CompareByAge());

        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        System.out.println(treeSet);
    }
}
