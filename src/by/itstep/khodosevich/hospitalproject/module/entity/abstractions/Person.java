package by.itstep.khodosevich.hospitalproject.module.entity.abstractions;

import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    private int age;
    private int hp;
    private Disease disease;
    private List<Drug> treatment;
    private Discount discount;

    public Person() {
        name = "no name";
        age = 0;
        hp = 0;
        disease = Disease.NO_DISEASE;
        treatment = new ArrayList<>();
        treatment.add(Drug.NO_DRUG);
        discount = Discount.WITHOUT_DISCOUNT;
    }

    public Person(String name, int age, int hp, Disease disease, List drugs, Discount discount) {
        this.name = name;
        this.age = age;
        this.hp = hp;
        this.disease = disease;
        treatment = drugs;
        this.discount = discount;
    }

    public Person(Person person) {
        name = person.name;
        age = person.age;
        hp = person.hp;
        disease = person.disease;
        treatment = person.treatment;
        discount = person.discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public List<Drug> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<Drug> treatment) {
        this.treatment = treatment;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    abstract public double getBudget();

    abstract public void setBudget(Drug drug);

    public void treat(Drug drug) {
        setHp(getHp() + drug.getPower());
    }

    @Override
    public String toString() {
        String msg = String.format("Name: %20s, age: %2d, hp: %2d", name, age, hp);
        return msg;
    }
}
