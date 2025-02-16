package deque;

//import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items = (T[]) new Object[8];;
    private int size;
    private int nextFirst;
    private int nextLast;

//    public Iterator<T> iterator() {
//        return null;
//        //return new ArrayDequeIterator();
//    }


    public ArrayDeque() {
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public ArrayDeque(T item) {
        items = (T[]) new Object[8];
        items[3] = item;
        size = 1;
        nextFirst = 2;
        nextLast = 4;
    }
    public void addFirst(T item) {
        items[nextFirst] = item;
        size += 1;
        nextFirst -= 1;
        if (nextFirst == -1) {
            resize(size * 2);
        }
    }

    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
        if (nextLast == items.length) {
            resize(size * 2);
        }
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int start = (int) (capacity - size) / 2;
        System.arraycopy(items, nextFirst + 1, a, start, size);
        items = a;
        nextFirst = start - 1;
        nextLast = start + size;
    }

    public void shrink() {
        if (isEmpty()) {
            resize(8);
        }
        if (size < items.length / 4 && size >= 4) {
            resize(items.length / 2);
        }
    }

    public T removeLast() {
        size -= 1;
        T r = items[nextLast - 1];
        nextLast -= 1;
        shrink();
        return r;
    }


    public T removeFirst() {
        size -= 1;
        T r = items[nextFirst + 1];
        nextFirst += 1;
        shrink();
        return r;
    }

    public int size() {
        return size;
    }

    public T get(int i) {
        return items[nextFirst + 1 + i];
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (other.get(i) != this.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
