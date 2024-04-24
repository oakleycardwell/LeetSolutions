class MKAverage {
    // Constants for the class
    private final int m; // Size of the sliding window
    private final int k; // Number of elements to exclude from the top and bottom when calculating average
    private Queue<Integer> elementsQueue = new ArrayDeque<>(); // Queue to maintain the last `m` elements
    private TreeMap<Integer, Integer> smallestElements = new TreeMap<>(); // Sorted map to track smallest `k` elements
    private TreeMap<Integer, Integer> middleElements = new TreeMap<>(); // Sorted map to track middle elements
    private TreeMap<Integer, Integer> largestElements = new TreeMap<>(); // Sorted map to track largest `k` elements
    private int countSmallest = 0; // Counter for smallest elements
    private int countLargest = 0; // Counter for largest elements
    private long sumMiddleElements = 0; // Sum of middle elements for average computation

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        elementsQueue.offer(num); // Add new element to the queue
        addElementToMap(middleElements, num); // Default addition to middle elements
        sumMiddleElements += num;

        if (elementsQueue.size() > m) {
            int removedElement = elementsQueue.poll(); // Remove the oldest element
            if (largestElements.containsKey(removedElement)) {
                removeElementFromMap(largestElements, removedElement);
                countLargest--;
            } else if (middleElements.containsKey(removedElement)) {
                removeElementFromMap(middleElements, removedElement);
                sumMiddleElements -= removedElement;
            } else {
                removeElementFromMap(smallestElements, removedElement);
                countSmallest--;
            }
        }

        // Move items from middle to largest to maintain `k` largest
        while (!middleElements.isEmpty() && countLargest < k) {
            int largestFromMiddle = middleElements.lastKey();
            sumMiddleElements -= largestFromMiddle;
            addElementToMap(largestElements, removeElementFromMap(middleElements, largestFromMiddle));
            countLargest++;
        }

        // Rebalance between largest and middle elements
        while (!middleElements.isEmpty() && !largestElements.isEmpty() && middleElements.lastKey() > largestElements.firstKey()) {
            int midToLarge = middleElements.lastKey();
            int largeToMid = largestElements.firstKey();

            sumMiddleElements += largeToMid - midToLarge;

            addElementToMap(largestElements, removeElementFromMap(middleElements, midToLarge));
            addElementToMap(middleElements, removeElementFromMap(largestElements, largeToMid));
        }

        // Move items from middle to smallest to maintain `k` smallest
        while (!middleElements.isEmpty() && countSmallest < k) {
            int smallestFromMiddle = middleElements.firstKey();
            sumMiddleElements -= smallestFromMiddle;
            addElementToMap(smallestElements, removeElementFromMap(middleElements, smallestFromMiddle));
            countSmallest++;
        }

        // Rebalance between smallest and middle elements
        while (!middleElements.isEmpty() && !smallestElements.isEmpty() && middleElements.firstKey() < smallestElements.lastKey()) {
            int midToSmall = middleElements.firstKey();
            int smallToMid = smallestElements.lastKey();

            sumMiddleElements += smallToMid - midToSmall;

            addElementToMap(smallestElements, removeElementFromMap(middleElements, midToSmall));
            addElementToMap(middleElements, removeElementFromMap(smallestElements, smallToMid));
        }
    }

    public int calculateMKAverage() {
        // Calculate the MKAverage only if the queue is full (i.e., has `m` elements)
        return elementsQueue.size() == m ? (int) (sumMiddleElements / (m - 2 * k)) : -1;
    }

    private void addElementToMap(TreeMap<Integer, Integer> map, int num) {
        map.merge(num, 1, Integer::sum);
    }

    private int removeElementFromMap(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0) {
            map.remove(num);
        }
        return num;
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */