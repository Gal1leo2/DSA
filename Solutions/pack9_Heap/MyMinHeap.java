package Solutions.pack9_Heap;

import java.util.Arrays;

public class MyMinHeap {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    public void insert(int d) {
        int p = size++;
        heap[p] = d;
        int parent = (p - 1) / 2;
        while ((p > 0) && (heap[p] < heap[parent])) {
            swap(p, parent);
            p = parent;
            parent = (p - 1) / 2;
        }
    }

    public void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        int p = 0;
        while (true) {
            int left = 2 * p + 1;
            if (left >= size)
                break;

            int right = 2 * p + 2;
            if (right == size) {
                if (heap[p] > heap[left])
                    swap(p, left);
                break;
            } else {
                int q = heap[left] < heap[right] ? left : right;
                if (heap[p] > heap[q])
                    swap(p, q);
                else
                    break;
                p = q;
            }
        }
        return d;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        return Arrays.toString(heap);
    }
}