package task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import task2.BPlusTree.RangePolicy;

class BPlusTreeTest {

    @Test
    public void testBF4() {
        BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(4);
        bpt.insert(0, "a");
        bpt.insert(1, "b");
        bpt.insert(2, "c");
        bpt.insert(3, "d");
        bpt.insert(4, "e");
        bpt.insert(5, "f");
        bpt.insert(6, "g");
        bpt.insert(7, "h");
        bpt.insert(8, "i");
        bpt.insert(9, "j");
        bpt.delete(1);
        bpt.delete(3);
        bpt.delete(5);
        bpt.delete(7);
        bpt.delete(9);
        assertEquals(bpt.search(0), "a");
        assertNull(bpt.search(1));
        assertEquals(bpt.search(2), "c");
        assertNull(bpt.search(3));
        assertEquals(bpt.search(4), "e");
        assertNull(bpt.search(5));
        assertEquals(bpt.search(6), "g");
        assertNull(bpt.search(7));
        assertEquals(bpt.search(8), "i");
        assertNull(bpt.search(9));
    }

    @Test
    public void testSameKey() {
        BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(4);
        bpt.insert(0, "a");
        bpt.insert(1, "b");
        bpt.insert(1, "c");
        bpt.insert(3, "d");
        bpt.insert(4, "e");
        bpt.insert(5, "f");
        bpt.insert(6, "g");
        bpt.insert(7, "h");
        bpt.insert(8, "i");
        bpt.insert(9, "j");
        bpt.delete(1);
        bpt.delete(3);
        bpt.delete(5);
        bpt.delete(7);
        bpt.delete(9);
        assertEquals(bpt.search(0), "a");
        assertNull(bpt.search(1));
        assertNull(bpt.search(2));
        assertEquals(bpt.search(4), "e");
        assertNull(bpt.search(5));
        assertEquals(bpt.search(6), "g");
        assertNull(bpt.search(7));
        assertEquals(bpt.search(8), "i");
        assertNull(bpt.search(9));
    }

    @Test
    public void testBFDefault() {
        BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>();
        bpt.insert(0, "a");
        bpt.insert(1, "b");
        bpt.insert(2, "c");
        bpt.insert(3, "d");
        bpt.insert(4, "e");
        bpt.insert(5, "f");
        bpt.insert(6, "g");
        bpt.insert(7, "h");
        bpt.insert(8, "i");
        bpt.insert(9, "j");
        bpt.delete(1);
        bpt.delete(3);
        bpt.delete(5);
        bpt.delete(7);
        bpt.delete(9);
        assertEquals(bpt.search(0), "a");
        assertNull(bpt.search(1));
        assertEquals(bpt.search(2), "c");
        assertNull(bpt.search(3));
        assertEquals(bpt.search(4), "e");
        assertNull(bpt.search(5));
        assertEquals(bpt.search(6), "g");
        assertNull(bpt.search(7));
        assertEquals(bpt.search(8), "i");
        assertNull(bpt.search(9));
    }

    @Test
    public void testSearchRange() {
        BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(4);
        bpt.insert(0, "a");
        bpt.insert(1, "b");
        bpt.insert(2, "c");
        bpt.insert(3, "d");
        bpt.insert(4, "e");
        bpt.insert(5, "f");
        bpt.insert(6, "g");
        bpt.insert(7, "h");
        bpt.insert(8, "i");
        bpt.insert(9, "j");
        assertArrayEquals(
                bpt.searchRange(3, RangePolicy.EXCLUSIVE, 3,
                        RangePolicy.INCLUSIVE).toArray(), new String[] { });
        assertArrayEquals(
                bpt.searchRange(3, RangePolicy.EXCLUSIVE, 7,
                        RangePolicy.EXCLUSIVE).toArray(), new String[] { "e",
                        "f", "g" });
        assertArrayEquals(
                bpt.searchRange(3, RangePolicy.INCLUSIVE, 7,
                        RangePolicy.EXCLUSIVE).toArray(), new String[] { "d",
                        "e", "f", "g" });
        assertArrayEquals(
                bpt.searchRange(3, RangePolicy.EXCLUSIVE, 7,
                        RangePolicy.INCLUSIVE).toArray(), new String[] { "e",
                        "f", "g", "h" });
        assertArrayEquals(
                bpt.searchRange(3, RangePolicy.INCLUSIVE, 7,
                        RangePolicy.INCLUSIVE).toArray(), new String[] { "d",
                        "e", "f", "g", "h" });
    }

    @Test
    public void testNullNode() {
        BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(4);
        assertArrayEquals(
                bpt.searchRange(3, RangePolicy.INCLUSIVE, 10,
                        RangePolicy.INCLUSIVE).toArray(), new String[] { });
    }

    @Test
    public void illegalBranchingTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(1);
        });

    }




}
