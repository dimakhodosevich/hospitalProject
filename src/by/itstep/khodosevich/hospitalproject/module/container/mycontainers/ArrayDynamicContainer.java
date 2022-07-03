package by.itstep.khodosevich.hospitalproject.module.container.mycontainers;

public class ArrayDynamicContainer<T> extends MyCollection<T>{

    private int size;
    private T[] array;

    public ArrayDynamicContainer() {
        array = (T[]) new Object[0];
        size = 0;
    }

    public ArrayDynamicContainer(T[] array) {
        this.array = array;
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public int capacity() {
        return array.length;
    }


    @Override
    public void add(T object) {
        if (object == null) {
            return;
        }

        T[] newArray = (T[]) new Object[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[size++] = object;
        array = newArray;
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        T[] newArray = (T[]) new Object[array.length - 1];


        for (int i = 0, j = 0; i < size; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }

        array = newArray;
        size--;
    }

    @Override
    public T getObject(int index) {
        return array[index];
    }

    @Override
    public void setObject(int index, T object){
        array[index] = object;
    }

    @Override
    public MyIterable getIterator() {
        return new MyIterable<T>(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (size == 0) {
            builder.append("Drug list doesn't consist any drugs.\n");
        } else {
            builder.append("Drug list:\n");
            for (int i = 0; i < size; i++) {
                builder.append(array[i]);
            }
        }

        return builder.toString();
    }
}
