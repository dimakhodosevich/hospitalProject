package by.itstep.khodosevich.hospitalproject.module.logic;

import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.ArrayDynamicContainer;
import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.MyCollection;
import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.MyIterable;
import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

import java.util.Random;

public class Doctor {
    public static Random random = new Random();

    public void defineDisease(Person person) {
        int diseaseIndex = random.nextInt(Disease.values().length);
        Disease[] diseases = Disease.values();
        person.setDisease(diseases[diseaseIndex]);
    }


    public void defineDiscount(Person person) {
        int discountIndex = random.nextInt(Discount.values().length);
        Discount[] discounts = Discount.values();
        person.setDiscount(discounts[discountIndex]);
    }

    public void toTreat(Person person) {
        MyCollection<Drug> list = new ArrayDynamicContainer<>();

        double cheapPrice = Drug.getCheapDrugPrice().getPrice();
        int weakPower = Drug.getWeakDrugPower().getPower();
        Drug[] drugs = Drug.values();
        Drug drug = null;

        for (int i = 0; person.getBudget() - cheapPrice >= 0
                && person.getHp() + weakPower <= 100; i++) {

            drug = drugs[i];

            if (person.getBudget() - drug.getPrice() >= 0
                    && drugs[i] != Drug.NO_DRUG) {
                if (person.getHp() + drug.getPower() <= 100) {
                    list.add(Drug.values()[i]);
                    person.setBudget(Drug.values()[i]);
                    person.treat(Drug.values()[i]);
                }
            }

            if (i == Drug.values().length - 1) {
                i = 0;
            }
        }

        person.setTreatment(list);
    }

    public double getPriceForTreatment(Person person) {
        double totalPrice = 0;

        MyIterable<Drug> iterable = person.getTreatment().getIterator();

        while(iterable.hasNext()){
            totalPrice += iterable.next().getPrice();
        }

        return totalPrice - totalPrice * person.getDiscount().getDiscountValue();
    }

}


