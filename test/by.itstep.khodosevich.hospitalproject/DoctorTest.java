package by.itstep.khodosevich.hospitalproject;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Worker;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;
import by.itstep.khodosevich.hospitalproject.module.logic.Doctor;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DoctorTest {

    @Test
    public void toTreatTestWithZeroArguments() {
        Person s1 = new Worker("Dima", 27, 0, Disease.NO_DISEASE, new ArrayList<Drug>(),
                Discount.TEN_PERCENT, 0, "engineer");
        Doctor doctor = new Doctor();

        doctor.toTreat(s1);
        int hp = s1.getHp();
        double budget = s1.getBudget();

        boolean isHpGood = hp == 0;
        boolean isBudgetGood = budget == 0;

        assertTrue(isBudgetGood);
        assertTrue(isHpGood);
    }


    @Test
    public void toTreatTestWithMaxArguments() {
        Person s1 = new Worker("Dima", 27, 100, Disease.NO_DISEASE, new ArrayList<Drug>(),
                Discount.TEN_PERCENT, 0, "engineer");
        Doctor doctor = new Doctor();

        doctor.toTreat(s1);
        int hp = s1.getHp();
        double budget = s1.getBudget();

        boolean isHpGood = hp == 100;
        boolean isBudgetGood = budget == 0;

        assertTrue(isBudgetGood);
        assertTrue(isHpGood);
    }


    @Test
    public void toTreatTestWithDefaultArguments() {
        Person s1 = new Worker("Dima", 27, 30, Disease.NO_DISEASE, new ArrayList<Drug>(),
                Discount.TEN_PERCENT, 100, "engineer");
        Doctor doctor = new Doctor();

        doctor.toTreat(s1);
        int hp = s1.getHp();
        double budget = s1.getBudget();

        boolean isHpGood = hp == 100;
        boolean isBudgetGood = budget > 0;

        assertTrue(isBudgetGood);
        assertTrue(isHpGood);
    }


    @Test
    public void toTreatTestWithCheapestDrug() {
        Person s1 = new Worker("Dima", 27, 0, Disease.NO_DISEASE, new ArrayList<Drug>(),
                Discount.WITHOUT_DISCOUNT, 1, "engineer");
        Doctor doctor = new Doctor();

        doctor.toTreat(s1);
        int hp = s1.getHp();
        double budget = s1.getBudget();

        boolean isHpGood = hp == 1;
        assertEquals(0, budget, 0.001);
        assertTrue(isHpGood);
    }

    @Test
    public void toTreatTestWithTwoCheapestDrug() {
        Person s1 = new Worker("Dima", 27, 0, Disease.NO_DISEASE, new ArrayList<Drug>(),
                Discount.WITHOUT_DISCOUNT, 2, "engineer");
        Doctor doctor = new Doctor();

        doctor.toTreat(s1);
        int hp = s1.getHp();
        double budget = s1.getBudget();

        boolean isHpGood = hp == 2;
        assertEquals(0, budget, 0.001);
        assertTrue(isHpGood);
    }

    @Test
    public void getPriceForTreatmentTest() {
        Person s1 = new Worker("Dima", 27, 0, Disease.NO_DISEASE, new ArrayList<Drug>(),
                Discount.TEN_PERCENT, 100, "engineer");
        Doctor doctor = new Doctor();

        ArrayList<Drug> drugs = new ArrayList<>();
        drugs.add(Drug.IBUKLIN);
        drugs.add(Drug.INJECTION);
        drugs.add(Drug.PARACETAMOL);

        s1.setTreatment(drugs);
        double priceForTreatment = Drug.IBUKLIN.getPrice() + Drug.INJECTION.getPrice() + Drug.PARACETAMOL.getPrice();

        double price = priceForTreatment - priceForTreatment * s1.getDiscount().getDiscountValue();
        double expected = 15.3;
        double delta = 0.001;

        assertEquals(expected, doctor.getPriceForTreatment(s1), delta);
    }


}
