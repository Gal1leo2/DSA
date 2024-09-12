// package Solutions.pack5_new;

// import java.util.ArrayList;
// import java.util.Iterator;

// public class MyQueueListWrap<T> implements Iterable<T> {
//     private ArrayList<T> items = new ArrayList<>();
//     private int count;

//     public void add(T item) {
//         items.add(item);
//         count++;
//     }

//     public T get(int index) {
//         return items.get(index);
//     }
//     @Override
//     public Iterator<T> iterator() {
//         return new AnyItemsIterator(this);
//     }
// }
