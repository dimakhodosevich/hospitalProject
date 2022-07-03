package by.itstep.khodosevich.hospitalproject.module.entity.enheritance;

import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.MyCollection;
import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

import java.util.List;
import java.util.Objects;

public class Worker extends Person {
    private double insurance;
    private String profession;

    public Worker() {
        insurance = 0;
        profession = "no type";
    }

    public Worker(String name, int age, int hp, Disease disease,
                  MyCollection<Drug> drugs, Discount discount, double insurance, String profession) {
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
        String msg = String.format(", insurance: %.2f, profession: %s, %s, discount: %s.\n",
                insurance, profession, getDisease(), getDiscount());
        return super.toString() + msg;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (this==o) return true;
        boolean result = super.equals(o);

        if(result){
            if(!(o instanceof Worker)) return false;
            Worker worker = (Worker) o;
            result = profession.equals(worker.getProfession());
        }

        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime*result + Objects.hash(insurance);
        result = prime*result + profession.hashCode();

        return result;
    }

    @Override
    public int compareTo(Person o) {
        int result = super.compareTo(o);

        if(result==0){
            Worker worker = (Worker) o;
            result=profession.compareTo(worker.getProfession());
        }

        return result;
    }
}
