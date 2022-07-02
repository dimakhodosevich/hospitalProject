package by.itstep.khodosevich.hospitalproject.module.entity.enheritance;

import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.discount.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.disease.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.medicine.Drug;

public class Student extends Person {
    private double stipend;
    private String universityName;

    public Student() {
        stipend =0;
        universityName = "no name";
    }

    public Student(String name, int age, int hp, Disease disease,
                   Drug[] drugs, Discount discount, double stipend, String universityName) {
        super(name, age, hp, disease, drugs, discount);
        this.stipend = stipend;
        this.universityName = universityName;
    }

    public Student(Person person, double stipend, String universityName) {
        super(person);
        this.stipend = stipend;
        this.universityName = universityName;
    }

    public double getStipend() {
        return stipend;
    }

    public void setStipend(double stipend) {
        this.stipend = stipend;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public double getMoneyAfterTreatment(Discount discount) {
        return stipend-(getPriceForTreatment()-getPriceForTreatment()*discount.getDiscount());
    }

    @Override
    public String toString() {
        String msg = String.format(", stipend: %2.2f, university name: %s, %s, hp after damage: %d" +
                        ", hp after treatment: %d, price for treatment: %.2f, discount: %s, money after treatment: %.2f.\n",
                stipend, universityName, getDisease(), getHpAfterDamage(), getHpAfterTreatment(),
                getPriceForTreatment(), getDiscount(), getMoneyAfterTreatment(getDiscount()));
        return super.toString() + msg;
    }
}
