class MedianFinder {
    private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        if(left.size()>right.size()+1) {
            right.offer(left.poll());
        } 
        else if(right.size()>left.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()) {
            return (double)(left.peek() + right.peek()) / 2;
        }

        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */