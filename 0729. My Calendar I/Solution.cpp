class MyCalendar {
public:
    MyCalendar() {}
    
    bool book(int start, int end) {
        auto it = booked.lower_bound(start);
        if(it != booked.cend() && it->first < end)
            return false;
        if(it != booked.cbegin() && (--it)->second > start)
            return false;
        booked[start] = end;
        return true;
    }
    
private:
    map<int, int> booked;
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */