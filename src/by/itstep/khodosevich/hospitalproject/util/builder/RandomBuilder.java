package by.itstep.khodosevich.hospitalproject.util.builder;

import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.ArrayDynamicContainer;
import by.itstep.khodosevich.hospitalproject.module.container.mycontainers.MyCollection;
import by.itstep.khodosevich.hospitalproject.module.entity.abstractions.Person;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Student;
import by.itstep.khodosevich.hospitalproject.module.entity.enheritance.Worker;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Discount;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Disease;
import by.itstep.khodosevich.hospitalproject.module.entity.enums.Drug;

import java.util.ArrayList;
import java.util.Random;

public class RandomBuilder {
    public static int DEFAULT_PERSON_COUNT = 15;
    public static final int MIN_PERSON_AGE = 1;
    public static final int MAX_PERSON_AGE = 100;
    public static final int MIN_PERSON_HP = 0;
    public static final int MAX_PERSON_HP = 100;
    public static final String[] NAMES = {"Dima Khodosevich", "Erik Freeman", "Gerbert Shildt", "James Gosling",
    "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum", "Brendan Eich", "Rasmus Lerdorf",    "Larry Wall"};
    public static final String[] UNIVERSITY_PLACES = {"BNTU", "BGU", "MGU", "BRUIR"};
    public static final String[] PROFESSIONS = {"doctor", "engineer", "teacher", "writer", "programmer", "scientist",
    "astronaut", "driver", "pilot", "sportsman"};
    public static final double MIN_MONEY = 0;
    public static final double MAX_MONEY = 0;

    private enum PersonType{
        STUDENT, WORKER;
    }

    public static ArrayList<Person> createPersonList(){
        ArrayList<Person> list = new ArrayList<>();

        for (int i =0; i<DEFAULT_PERSON_COUNT; i++){
            Person person = createPerson();
            list.add(person);
        }

        return list;
    }


    private static Person createPerson(){

        Person person = null;

        Random random = new Random();
        int index = random.nextInt(PersonType.values().length);
        PersonType type = PersonType.values()[index];

        String name = NAMES[random.nextInt(NAMES.length)];
        int age = random.nextInt(MAX_PERSON_AGE-MIN_PERSON_AGE+1)+MIN_PERSON_AGE;
        int hp = random.nextInt(MAX_PERSON_HP-MIN_PERSON_HP+1)+MIN_PERSON_HP;
        Disease disease = Disease.values()[random.nextInt(Disease.values().length)];
        Discount discount = Discount.values()[random.nextInt(Discount.values().length)];
        MyCollection<Drug> treatment = new ArrayDynamicContainer<Drug>();
        double money = (random.nextDouble(MAX_MONEY-MIN_MONEY+1)+MIN_MONEY)*100;

        switch (type){
            case WORKER: {
                String profession = PROFESSIONS[random.nextInt(PROFESSIONS.length)];
                person = new Worker(name, age, hp, disease, treatment, discount, money, profession);
                break;
            }
            case STUDENT: {
                String uniPlace = UNIVERSITY_PLACES[random.nextInt(UNIVERSITY_PLACES.length)];
                person = new Student(name, age, hp, disease, treatment, discount, money, uniPlace);
                break;
            }
        }

        return person;
    }
}
