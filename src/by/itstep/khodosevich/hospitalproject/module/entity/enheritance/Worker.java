package by.itstep.khodosevich.hospitalproject.module.entity.enheritance;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

import java.util.List;

public class Worker extends Person {
    private double insurance;
    private String profession;

    public Worker() {
        insurance = 0;
        profession = "no type";
    }

    public Worker(String name, int age, int hp, Disease disease,
                  List drugs, Discount discount, double insurance, String profession) {
        super(name, age, hp, disease, drugs, discount);
        this.insurance = insurance;
        this.profession = profession;
    }

    public Worker(Person person, double insurance, String profession) {
        super(person);
        this.insurance = insurance;
        this.profession = profession;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    @Override
    public double getBudget() {
        return insurance;
    }

    @Override
    public void setBudget(Drug drug) {
        insurance -= (drug.getPrice() - drug.getPrice()
                * getDiscount().getDiscountValue());
    }

    @Override
    public String toString() {
        String msg = String.format(", insurance: %.2f, profession: %s, %s, discount: %s.\n,",
                insurance, profession, getDisease(), getDiscount());
        return super.toString() + msg;
    }
}
