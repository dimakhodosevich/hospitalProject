package by.itstep.khodosevich.hospitalproject.module.entity.abstractions;

import by.itstep.khodosevich.hospitalproject.module.entity.discount.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.disease.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.medicine.Drug;

public abstract class Person {
    private String name;
    private int age;
    private int hp;
    private Disease disease;
    private Drug[] treatment;
    private Discount discount;

    public Person() {
        name = "no name";
        age = 0;
        hp = 0;
        disease = Disease.NO_DISEASE;
        treatment = new Drug[]{Drug.NO_DRUG};
        discount = Discount.WITHOUT_DISCOUNT;
    }

    public Person(String name, int age, int hp, Disease disease, Drug[] drugs, Discount discount) {
        this.name = name;
        this.age = age;
        this.hp = hp;
        this.disease = disease;
        treatment = drugs;
        this.discount = discount;
    }

    public Person(Person person){
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

    public Drug[] getTreatment() {
        return treatment;
    }

    public void setTreatment(Drug[] treatment) {
        this.treatment = treatment;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public String getHistoryOfTreatment(){
        StringBuilder builder =new StringBuilder();
        for(Drug drug: treatment){
            builder.append(drug).append("\n");
        }

        return builder.toString();
    }

    public int getHpAfterTreatment(){
        int temp = getHpAfterDamage();
        for(Drug drug: treatment){
            temp+=drug.getPower();
        }

        return temp;
    }

    public int getHpAfterDamage(){
        int temp = hp;
        temp-= disease.getDamage();
        return temp;
    }

    abstract public double getMoneyAfterTreatment(Discount discount);

    public double getPriceForTreatment() {
        double moneyForTreatment = 0;
        for(Drug drug: getTreatment()){
            moneyForTreatment+= drug.getPrice();
        }
        return moneyForTreatment;
    }

    @Override
    public String toString() {
        String msg = String.format("Name: %20s, age: %2d, hp: %2d",name, age, getHp() );
        return msg;
    }
}
