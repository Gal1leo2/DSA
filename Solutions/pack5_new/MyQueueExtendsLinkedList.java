package Solutions.pack5_new;

import java.util.ArrayList;
import java.util.Iterator;

public class MyQueueExtendsLinkedList<T> implements Iterable<T> {
    private ArrayList<T> items = new ArrayList<>();
    private int count;

    public void enqueue(T item) {
        items.add(item);
        count++;
    }

    public T peek() {
        return items.get(0);
    }

    public T dequeue() {
        T tmp = items.get(0);
        items.remove(0);
        return tmp;
    }

    public T top() {
        return this.peek();
    }

    public T getLast() {
        return items.get(count);
    }

    public void add(T item) {
        items.add(item);
        count++;
    }

    public T get(int index) {
        return items.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new AnyItemsIterator(this);
    }

    private class AnyItemsIterator implements Iterator<T> {
        private MyQueueExtendsLinkedList<T> lis ;
        private int idx;

        public AnyItemsIterator(MyQueueExtendsLinkedList<T> arg) {
            this.lis = arg;
        }

        @Override
        public boolean hasNext() {
            return (idx < lis.count);
        }

        @Override
        public T next() {
            return lis.items.get(idx++);
        }
    }

    @Override
    public String toString() {
        return " [items=" + items + "]";
    }


    
}

