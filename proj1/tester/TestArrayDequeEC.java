package tester;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import static org.junit.Assert.*;

public class TestArrayDequeEC {
    @Test
    public void test() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 200; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                ads1.addLast(i);
            } else {
                sad1.addFirst(i);
                ads1.addFirst(i);
            }
        }

        for (int i = 0; i < 92; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer expected = ads1.removeLast();
                Integer actual = sad1.removeLast();
                assertEquals("removeLast() failed at iteration " + i, expected, actual);
            } else {
                Integer expected = ads1.removeFirst();
                Integer actual = sad1.removeFirst();
                assertEquals("removeFirst() failed at iteration " + i, expected, actual);
            }
        }

        for (int i = 0; i < 10; i += 1) {
            Integer expected = ads1.get(i);
            Integer actual = sad1.get(i);
            //assertEquals("get(" + i + ") failed", expected, actual);
        }
    }
    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 200; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                ads1.addLast(i);
            } else {
                sad1.addFirst(i);
                ads1.addFirst(i);
            }
        }

        for (int i = 0; i < 100; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer expected = ads1.removeLast();
                Integer actual = sad1.removeLast();
                assertEquals("removeLast() failed at iteration " + i, expected, actual);
            } else {
                Integer expected = ads1.removeFirst();
                Integer actual = sad1.removeFirst();
                assertEquals("removeFirst() failed at iteration " + i, expected, actual);
            }
        }

        for (int i = 0; i < 10; i += 1) {
            Integer expected = ads1.get(i);
            Integer actual = sad1.get(i);
            //assertEquals("get(" + i + ") failed", expected, actual);
        }
    }

    @Test
    public void testAddRemoveFirst() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 200; i++) {
            sad1.addFirst(i);
            ads1.addFirst(i);
            assertEquals("addFirst() failed at iteration " + i, ads1.size(), sad1.size());
        }

        for (int i = 0; i < 80; i++) {
            Integer expected = ads1.removeFirst();
            Integer actual = sad1.removeFirst();
            assertEquals("removeFirst() failed at iteration " + i, expected, actual);
        }
    }

    @Test
    public void testAddRemoveLast() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 200; i++) {
            sad1.addLast(i);
            ads1.addLast(i);
            assertEquals("addLast() failed at iteration " + i, ads1.size(), sad1.size());
        }

        for (int i = 0; i < 100; i++) {
            Integer expected = ads1.removeLast();
            Integer actual = sad1.removeLast();
            assertEquals("removeLast() failed at iteration " + i, expected, actual);
        }
    }

    @Test
    public void testIsEmpty() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        assertTrue("isEmpty() failed on new deque", sad1.isEmpty());

        sad1.addFirst(1);
        assertFalse("isEmpty() failed after addFirst", sad1.isEmpty());

        sad1.removeFirst();
        assertTrue("isEmpty() failed after removeFirst", sad1.isEmpty());
    }

    @Test
    public void testSize() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        assertEquals("size() failed on new deque", 0, sad1.size());

        for (int i = 0; i < 100; i++) {
            sad1.addLast(i);
            assertEquals("size() failed at iteration " + i, i + 1, sad1.size());
        }

        for (int i = 0; i < 100; i++) {
            sad1.removeFirst();
            assertEquals("size() failed at iteration " + i, 99 - i, sad1.size());
        }
    }

    @Test
    public void testGet() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            sad1.addLast(i);
            ads1.addLast(i);
        }

        for (int i = 0; i < 100; i++) {
            Integer expected = ads1.get(i);
            Integer actual = sad1.get(i);
            assertEquals("get(" + i + ") failed", expected, actual);
        }

        assertNull("get() should return null for out of bounds index", sad1.get(100));
    }
}