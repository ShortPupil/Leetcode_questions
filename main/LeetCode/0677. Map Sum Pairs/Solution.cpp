class MapSum {
public:
    /** Initialize your data structure here. */
    MapSum() {

    }

    void insert(string key, int val) {
        m[key] = val;
    }

    int sum(string prefix) {
        int sum = 0, len = prefix.size();
        for (auto it = m.lower_bound(prefix); it != m.end();++it){
            if (it->first.substr(0,len) != prefix) break;
            sum += it->second;
        }
        return sum;
    }
private:
    map<string, int> m;
};


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum* obj = new MapSum();
 * obj->insert(key,val);
 * int param_2 = obj->sum(prefix);
 */