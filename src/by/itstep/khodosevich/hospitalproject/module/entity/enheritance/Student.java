package by.itstep.khodosevich.hospitalproject.module.entity.enheritance;

import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.MyCollection;
import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private double stipend;
    private String universityName;

    public Student() {
        stipend = 0;
        universityName = "no name";
    }

    public Student(String name, int age, int hp, Disease disease,
                   MyCollection<Drug> drugs, Discount discount, double stipend, String universityName) {
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
    public double getBudget() {
        return stipend;
    }

    @Override
    public void setBudget(Drug drug) {
        stipend -= (drug.getPrice() - drug.getPrice() * getDiscount().getDiscountValue());
    }

    @Override
    public String toString() {
        String msg = String.format(", stipend: %2.2f, university name: %s, %s, discount: %s.",
                stipend, universityName, getDisease(), getDiscount());
        return super.toString() + msg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;

        boolean result = super.equals(o);

        if(result){
            if (!(o instanceof Student)) return false;
            Student student = (Student)o;
            result = universityName.equals(student.getUniversityName());
        }

        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime*result + Objects.hash(stipend);
        result = prime*result + universityName.hashCode();

        return result;
    }

    @Override
    public int compareTo(Person o) {
        int result = super.compareTo(o);

        if(result==0){
            if(!(o instanceof Student)) return -1;
            Student student = (Student)o;
            result=universityName.compareTo(student.getUniversityName());
        }

        return result;
    }
}
