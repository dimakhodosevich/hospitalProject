package by.itstep.khodosevich.hospitalproject.module.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HospitalList<T> implements Serializable {
    private List<T> list;

    public HospitalList() {
        list = new ArrayList<>();
    }

    public HospitalList(List<T> list) {
        this.list = list;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T getPerson(int index) {
        return list.get(index);
    }

    public boolean find(T person) {
        int index = list.lastIndexOf(person);
        return index == -1 ? false : true;
    }

    public void add(T person) {
        if (find(person)) {
            int index = list.lastIndexOf(person);
            list.add(index, person);
        }

        list.add(person);
    }

    public void remove(T person) {
        if (find(person)) {
            int firstIndex = list.indexOf(person);
            int lastIndex = list.lastIndexOf(person);
            for (int i = firstIndex; i <= lastIndex; i++) {
                list.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (list.isEmpty()) {
            builder.append("Hospital list is empty").append("\n");
        } else {
            for (T person : list) {
                builder.append(person).append('\n');
            }
        }

        return builder.toString();
    }
}
