package by.itstep.khodosevich.hospitalproject.controller;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.discount.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.disease.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Student;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Worker;
import by.itstep.khodosevich.hospitalproject.module.entity.medicine.Drug;
import by.itstep.khodosevich.hospitalproject.view.Printer;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Dima", 27, 70, Disease.ANGINA, new Drug[]{Drug.NO_DRUG, Drug.IBUKLIN, Drug.INJECTION},
                Discount.TEN_PERCENT, 65,  "BNTU");
        Printer.printToConsole(s);
        Printer.printToConsole(s.getHistoryOfTreatment());
        Printer.printToConsole("---------\n");
        Worker w = new Worker("Vlada", 26, 85,Disease.NO_DISEASE, new Drug[]{Drug.NO_DRUG},
                Discount.TEN_PERCENT,42, "teacher");
        Printer.printToConsole(w);
        Printer.printToConsole(w.getHistoryOfTreatment());
    }
}
