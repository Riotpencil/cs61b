package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        int maxi = 0;
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), get(maxi)) > 0) {
                maxi = i;
            }
        }
        return get(maxi);
    }

    public T max() {
        return max(comparator);
    }
}
