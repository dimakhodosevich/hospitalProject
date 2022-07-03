package by.itstep.khodosevich.hospitalproject.module.container.mycontainers;

public abstract class MyCollection<T> implements MyIterator{


    public abstract int size();

    public abstract boolean isEmpty();

    public abstract int capacity();

    public abstract void add(T object);

    public abstract void remove(int index);

    public abstract T getObject(int index);

    public abstract void setObject(int index, T object);
}
