package by.itstep.khodosevich.hospitalproject.module.entity.enheritance;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.discount.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.disease.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.medicine.Drug;

public class Worker extends Person {
    private double insurance;
    private String profession;

    public Worker() {
        insurance = 0;
        profession = "no type";
    }

    public Worker(String name, int age, int hp, Disease disease,
                  Drug[] drugs, Discount discount, double insurance, String profession) {
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
    public double getMoneyAfterTreatment(Discount discount) {
        return insurance - (getPriceForTreatment()-getPriceForTreatment()*discount.getDiscount());
    }

    @Override
    public String toString() {
        String msg = String.format(", insurance: %.2f, profession: %s, %s, hp after damage: %d" +
                        ", hp after treatment: %d, price for treatment: %.2f, discount: %s," +
                        " money after treatment: %.2f.\n",
                insurance,profession, getDisease(), getHpAfterDamage(), getHpAfterTreatment(),
                getPriceForTreatment(), getDiscount(),getMoneyAfterTreatment(getDiscount()));
        return super.toString()+msg;
    }
}
