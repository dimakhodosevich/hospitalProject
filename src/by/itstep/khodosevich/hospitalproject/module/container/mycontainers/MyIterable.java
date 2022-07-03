package by.itstep.khodosevich.hospitalproject.module.container.mycontainers;

public class MyIterable<T> {

    private MyCollection list;
    private static int current;

    static {
        current = 0;
    }

    public MyIterable(MyCollection list) {
        this.list = list;
    }

    public T next() {
        return (T)list.getObject(current++);
    }

    public boolean hasNext() {
        return current < list.size();
    }

    public void reset() {
        current = 0;
    }
}

