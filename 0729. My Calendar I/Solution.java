import java.util.TreeMap;

class MyCalendar {
    TreeMap<Integer, Integer> booked_;
    public MyCalendar() {
        booked_ = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer lb = booked_.floorKey(start);
        if (lb != null && booked_.get(lb) > start) return false;
        Integer ub = booked_.ceilingKey(start);
        if (ub != null && ub < end) return false;
 
        booked_.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */