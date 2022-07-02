package by.itstep.khodosevich.hospitalproject.controller;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.discount.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.disease.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Worker;
import by.itstep.khodosevich.hospitalproject.module.entity.medicine.Drug;
import by.itstep.khodosevich.hospitalproject.module.logic.Doctor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person s1 = new Worker("Dima", 27, 50, Disease.NO_DISEASE, new ArrayList<Drug>(),
                Discount.TEN_PERCENT, 80, "engineer");

        Doctor doctor = new Doctor();
        doctor.defineDisease(s1);
//        doctor.defineDiscount(s1);
        doctor.toTreat(s1);
        System.out.println(s1.getTreatment());
        System.out.println(doctor.getPriceForTreatment(s1));
        System.out.println(s1);


    }
}
