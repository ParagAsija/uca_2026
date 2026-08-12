import java.util.*;

// Use two heaps to efficiently maintain the median of a data stream. A max heap stores the smaller half of the numbers, while a min heap stores the larger half. We keep the sizes of the two heaps balanced, with their sizes differing by at most one. When inserting a number, compare it with the maximum element of the max heap to decide which heap it belongs to, then rebalance the heaps if necessary. To find the median, if both heaps have the same size, take the average of their top elements; otherwise, take the top element of the larger heap. This gives O(log n) time for each insertion and O(1) time for retrieving the median, with O(n) space.

public class RunningMedian {

    // Max heap: smaller half
    private PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

    // Min heap: larger half
    private PriorityQueue<Integer> minHeap =
            new PriorityQueue<>();

    // Insert a number into the data structure
    public void insert(int num) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } 
        else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Get current median
    public float getMedian() {

        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            throw new IllegalStateException("No numbers available");
        }

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0f;
        }

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        RunningMedian rm = new RunningMedian();

        rm.insert(5);
        System.out.println(rm.getMedian()); // 5.0

        rm.insert(2);
        System.out.println(rm.getMedian()); // 3.5

        rm.insert(10);
        System.out.println(rm.getMedian()); // 5.0

        rm.insert(4);
        System.out.println(rm.getMedian()); // 4.5

        rm.insert(8);
        System.out.println(rm.getMedian()); // 5.0
    }
}