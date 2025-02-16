package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private Node prev;
        private Node next;
        private T item;
        public Node(Node p, Node n, T i) {
            prev = p;
            next = n;
            item = i;
        }
    }
    private Node sentinel;
    private int size = 0;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    // create an empty deque
    public LinkedListDeque (T item) {
        sentinel.next = new Node(sentinel, sentinel, item);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, sentinel.next, item);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, sentinel, item);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return item;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }
    public T getRecursiveHelper(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        Node p = sentinel.next;
        Node q = other.sentinel.next;
        while (p != sentinel) {
            if (p.item != q.item) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
