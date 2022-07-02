package by.itstep.khodosevich.hospitalproject.module.entity.enums;

public enum Drug {
    PARACETAMOL(3, 3), IBUKLIN(6, 6), INJECTION(8, 8), VITAMIN(1, 1), NO_DRUG(0, 0);

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
        String msg = String.format("drug: %5s, drug power: %d, drug price: %.2f.\n",
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

    public static Drug getCheapDrugPrice() {
        Drug[] drugs = Drug.values();
        Drug cheapDrug = drugs[0];

        for (int i = 1; i < drugs.length; i++) {
            if (cheapDrug.getPrice() > drugs[i].getPrice()
                    && drugs[i] != Drug.NO_DRUG) {
                cheapDrug = drugs[i];
            }
        }
        return cheapDrug;
    }

    public static Drug getWeakDrugPower() {
        Drug[] drugs = Drug.values();
        Drug weakDrug = drugs[0];

        for (int i = 1; i < drugs.length; i++) {
            if (weakDrug.getPrice() > drugs[i].getPrice()
                    && drugs[i] != Drug.NO_DRUG) {
                weakDrug = drugs[i];
            }
        }
        return weakDrug;
    }
}
