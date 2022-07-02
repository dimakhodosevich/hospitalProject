package by.itstep.khodosevich.hospitalproject.controller;

import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.LinkedListContainer;
import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.MyCollection;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

public class Main {
    public static void main(String[] args) {
//        Person s1 = new Worker("Dima", 27, 50, Disease.NO_DISEASE, new ArrayList<Drug>(),
//                Discount.TEN_PERCENT, 80, "engineer");
//
//        Doctor doctor = new Doctor();
//        doctor.defineDisease(s1);
////        doctor.defineDiscount(s1);
//        doctor.toTreat(s1);
//        System.out.println(s1.getTreatment());
//        System.out.println(doctor.getPriceForTreatment(s1));
//        System.out.println(s1);


        MyCollection<Drug> container = new LinkedListContainer<>();
        container.add(Drug.IBUKLIN);
        container.add(Drug.PARACETAMOL);
        container.add(Drug.INJECTION);
        container.remove(3);
        container.setObject(2, Drug.NO_DRUG);
        System.out.println(container);
        System.out.println(container.size());
        System.out.println(container.capacity());

    }
}
