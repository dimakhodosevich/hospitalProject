package by.itstep.khodosevich.hospitalproject.module.container.mycontainers;

public class LinkedListContainer<T> extends MyCollection<T>{

    private Node first;
    private int size;

    public LinkedListContainer() {
        first = null;
        size = 0;
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
        return size;
    }

    @Override
    public void add(T object) {
        if (first == null) {
            object = (T)object;
            first = new Node(object);
        } else {
            object = (T)object;
            Node temp = first;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(object);
        }

        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            first = first.next;
        } else {
            int counter = 0;
            Node temp = first;

            while (counter != index - 1) {
                temp = temp.next;
                counter++;
            }

            Node previous = temp;
            temp = temp.next;
            previous.next = temp.next;
        }
        size--;
    }

    @Override
    public T getObject(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        int counter = 0;
        Node temp = first;

        while (counter != index) {
            temp = temp.next;
            counter++;
        }

        return (T) temp.object;
    }

    @Override
    public void setObject(int index, T object){
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            first.object = object;
        } else {
            int counter = 0;
            Node temp = first;

            while (counter != index) {
                temp = temp.next;
                counter++;
            }

            temp.object = object;
        }

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
            Node temp = first;

            while (temp.next != null) {
                builder.append(temp.object);
                temp = temp.next;
            }

            builder.append(temp.object);
        }

        return builder.toString();
    }

    private class Node<T> {
        public T object;
        public Node next;

        public Node(T object) {
            this.object = object;
        }
    }
}
