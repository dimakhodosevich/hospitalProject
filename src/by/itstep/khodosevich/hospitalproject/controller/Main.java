package by.itstep.khodosevich.hospitalproject.controller;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.logic.Doctor;
import by.itstep.khodosevich.hospitalproject.util.builder.RandomBuilder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        ArrayList<Person> list = RandomBuilder.createPersonList();

        System.out.println("Before treatment");

        for (Person person : list) {
            System.out.println(person);
        }


        System.out.println("After treatment");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("----------------------------------------------------------------------------");
            doctor.defineDisease(list.get(i));
            doctor.toTreat(list.get(i));
            System.out.println(list.get(i));
            System.out.println(list.get(i).getTreatment());
            System.out.println("----------------------------------------------------------------------------");
        }
    }
}
