package by.itstep.khodosevich.hospitalproject.module.entity.abstractions;

import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.ArrayDynamicContainer;
import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.MyCollection;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int hp;
    private Disease disease;
    private MyCollection<Drug> treatment;
    private Discount discount;

    public Person() {
        name = "no name";
        age = 0;
        hp = 0;
        disease = Disease.NO_DISEASE;
        treatment = new ArrayDynamicContainer<>();
        treatment.add(Drug.NO_DRUG);
        discount = Discount.WITHOUT_DISCOUNT;
    }

    public Person(String name, int age, int hp, Disease disease, MyCollection<Drug> drugs, Discount discount) {
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

    public MyCollection<Drug> getTreatment() {
        return treatment;
    }

    public void setTreatment(MyCollection<Drug> treatment) {
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
        String msg = String.format("Name: %2s, age: %2d, hp: %2d", name, age, hp);
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        boolean result = false;
        if(name.equals(person.name)){
                if(age == person.getAge()){
                    result = true;
                }
        }

        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = name.hashCode();
        result = result*prime + Objects.hash(age);
        return result;
    }


    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
