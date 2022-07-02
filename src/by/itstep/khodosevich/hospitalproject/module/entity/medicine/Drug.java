package by.itstep.khodosevich.hospitalproject.module.entity.medicine;

import by.itstep.khodosevich.hospitalproject.module.entity.disease.Disease;

public enum Drug {
    PARACETAMOL(2, 2), IBUKLIN(4,4), INJECTION(6,6), VITAMIN(1,1), NO_DRUG(0,0);

    private int power;
    private double price;

    Drug(int power, double price) {
        this.power = power;
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String msg = String.format("drug: %5s, drug power: %d, drug price: %.2f.",
                getDrugName(this), getPower(), getPrice());
        return msg;
    }

    private String getDrugName(Drug drug) {
        String msg = "no info";

        switch (drug) {
            case PARACETAMOL: {
                msg = "paracetamol";
                break;
            }
            case IBUKLIN: {
                msg = "ibuklin";
                break;
            }
            case INJECTION: {
                msg = "injection";
                break;
            }
            case VITAMIN: {
                msg = "vitamin";
                break;
            }
        }

        return msg;
    }

}
