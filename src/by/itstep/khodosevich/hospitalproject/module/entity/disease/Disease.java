package by.itstep.khodosevich.hospitalproject.module.entity.disease;

public enum Disease {
    ANGINA(15), NAUSEA(7), HEADACHE(5), COVID(35), FRACTURE(30), NO_DISEASE(0);

    private int damage;

    Disease(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        String msg = String.format("disease: %7s, disease damage: %d",
                getDiseaseName(this), getDamage());
        return msg;
    }

    private String getDiseaseName(Disease disease) {
        String msg = "no info";

        switch (disease) {
            case ANGINA: {
                msg = "angina";
                break;
            }
            case NAUSEA: {
                msg = "nausea";
                break;
            }
            case HEADACHE: {
                msg = "headache";
                break;
            }
            case COVID: {
                msg = "covid";
                break;
            }
            case FRACTURE: {
                msg = "fracture";
                break;
            }
        }

        return msg;
    }
}
