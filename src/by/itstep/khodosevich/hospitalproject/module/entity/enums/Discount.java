package by.itstep.khodosevich.hospitalproject.module.entity.enums;

public enum Discount {
    THREE_PERCENT(0.03), FIVE_PERCENT(0.05), TEN_PERCENT(0.1), TWENTY_FIVE_PERCENT(0.25), WITHOUT_DISCOUNT(0);

    private double discount;

    Discount(double discount) {
        this.discount = discount;
    }

    public double getDiscountValue() {
        return discount;
    }

    @Override
    public String toString() {
        String msg = String.format("discount: %3s",
                getDiscountName(this));
        return msg;
    }

    private String getDiscountName(Discount discount) {
        String msg = "0 %";

        switch (discount) {
            case THREE_PERCENT: {
                msg = "3 %";
                break;
            }
            case FIVE_PERCENT: {
                msg = "5 %";
                break;
            }
            case TEN_PERCENT: {
                msg = "10 %";
                break;
            }
            case TWENTY_FIVE_PERCENT: {
                msg = "25 %";
                break;
            }
        }

        return msg;
    }

}
