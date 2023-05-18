import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
    private BinarySearch fullList = new BinarySearch();

    @BeforeEach
    void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            fullList.insert(i);
        }
    }

    @Test
    void testInsertFull() {
        fullList.insert(-1);
        int[] list = fullList.getList();
        for (int i = 0; i < 100; i++) {
            if (list[i] != i) {
                fail();
            }
        }
    }

    @Test
    void testInsertEmpty() {
        BinarySearch list1 = new BinarySearch();
        list1.insert(1);
        int[] list = list1.getList();
        assertEquals (1, list[0]);
    }


    @Test
    void testInsert() {
        fail("Not yet implemented");
    }

    @Test
    void testSearch() {
        fail("Not yet implemented");
    }
    
}
