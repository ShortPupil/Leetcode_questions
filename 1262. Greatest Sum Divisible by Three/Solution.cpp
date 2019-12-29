//看数组中的数是否能被三整除
//能被3整除，直接加，就应该是最大
//余1，加上余2的，再跟被3整除的比谁最大
//余2，加上余1的，再跟被3整除的比谁最大
class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int records[3] = {0,0,0};
        int len = nums.size();
        for(int i=0; i<len ; i++){
            if(nums[i]%3 == 0){
                records[0]+=nums[i];
                records[1]+=nums[i];
                records[2]+=nums[i];
            }
            if(nums[i]%3 == 1){
                int x = records[0];
                if((nums[i]+records[2])%3==0) records[0] = max(records[0], nums[i]+records[2]);
                if((nums[i]+records[1])%3==2) records[2] = max(records[2], nums[i]+records[1]);
                if((nums[i]+x)%3==1) records[1] = max(records[1], nums[i]+x);
            }
            if(nums[i]%3 == 2){
                int x = records[0];
                if((nums[i]+records[1])%3==0) records[0] = max(records[0], nums[i]+records[1]);
                if((nums[i]+records[2])%3==1) records[1] = max(records[1], nums[i]+records[2]);
                if((nums[i]+x)%3==2) records[2] = max(records[2], nums[i]+x);
            }
        }
        return records[0];
    }
};