package randomizedtest;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        for(int i = 0; i < 3; i++) {
            a.addLast(i);
            b.addLast(i);
        }
        for(int i = 0; i < 3; i++) {
            assertEquals(a.removeLast(), b.removeLast());
        }
        assertEquals(a.size(), b.size());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
                assertEquals(L.size(), B.size());
            } else if (operationNumber == 1) {
                // size
                if (L.size() == 0) {
                    continue;
                }
                int val = L.removeLast();
                int valB = B.removeLast();
               // System.out.println("removeLast: " + val);
                assertEquals(val, valB);

            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0) {
                    continue;
                }
                int val = L.getLast();
                int valB = B.getLast();
                //System.out.println("getLast: " + val);
                assertEquals(val, valB);
            }
        }
    }

    //int operationNumber = StdRandom.uniform(0, 2);
}
