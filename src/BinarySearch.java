/**
 * Simple class that manages a sorted array that can be searched.
 *
 */
public class BinarySearch {
    // The array size
    static final int MAX_ELEMENTS = 100;
    
    // The array to keep sorted
    private int[] list = new int[MAX_ELEMENTS];
    
    // The position where the next value will be placed in the array.
    private int numElements = 0;

    /**
     * Inserts a value into the array, keeping the array sorted. Does nothing 
     * if the array is full.
     * 
     * @param newValue the value to insert
     */
    public void insert(int newValue) {
        if (numElements == MAX_ELEMENTS) {
            return;
        }

        for (int i = 0; i < numElements; i++) {
            if (newValue < list[i]) {
                // Move values up in the array to make space for the new value.
                makeEmpty(i);
                list[i] = newValue;
                numElements++;
                return;
            }
        }

        list[numElements] = newValue;
        numElements++;
    }

    /**
     * 
     * @param value the value to search for
     * @return the index where the value is. Returns -1 if the value is not 
     *    found.
     */
    public int search(int value) {
        int low = 0;
        int high = list.length - 1;
        int middle;
        while (low < high) {
            middle = (low + high) / 2;
            if (value == list[middle]) {
                return middle;
            }
            else if (value < list[middle]) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return -1;
    }
    
    /**
     * Move everything in position pos and higher up one 
     * position in the array
     * @param pos the index where we should start moving things up
     *    pos should be between 0 and numElements-1
     * @pre the array is not full
     */
    private void makeEmpty (int pos) {
        for (int i = numElements - 1; i >= pos; i--) {
            list[i+1] = list[i];
        }
    }
    
    /**
     * This method was added to facilitate testing of the insert
     * method.  Notice that this method is not declared to be public
     * or private.  This causes the method to be visible to other
     * classes in the same package (like our test class), but not
     * visible outside the package.
     * @return
     */
    int[] getList () {
        return list;
    }

}
