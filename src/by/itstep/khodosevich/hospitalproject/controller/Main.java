package by.itstep.khodosevich.hospitalproject.controller;

import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.*;
import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Worker;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.logic.Doctor;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Person s1 = new Worker("Dima Khodosevich", 27, 50, Disease.NO_DISEASE, new ArrayDynamicContainer<>(),
                Discount.WITHOUT_DISCOUNT, 80, "engineer");

        Person s2 = new Worker("Andrey Khodosevich", 27, 50, Disease.NO_DISEASE, new ArrayDynamicContainer<>(),
                Discount.WITHOUT_DISCOUNT, 80, "engineer");

        Person s3 = new Worker("Bad Khodosevich", 27, 50, Disease.NO_DISEASE, new ArrayDynamicContainer<>(),
                Discount.WITHOUT_DISCOUNT, 80, "engineer");


        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        System.out.println(treeSet);
    }
}
