package by.itstep.khodosevich.hospitalproject.module.container.mycontainers;

public class ArrayStaticContainer<T> extends MyCollection<T> {

    private static int defaultSize;
    private T[] array;
    private int size;

    static {
        defaultSize = 10;
    }

    public ArrayStaticContainer() {
        array = (T[]) new Object[defaultSize];
        size = 0;
    }

    public ArrayStaticContainer(T[] array) {
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

        array[size++] = object;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == size - 1) {
            array[size - 1] = null;
        } else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
        }

        size--;
    }

    @Override
    public T getObject(int index) {
        return array[index];
    }

    @Override
    public void setObject(int index, T object) {
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
