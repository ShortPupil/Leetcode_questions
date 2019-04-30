class Solution {
public:
    int sumSubarrayMins(vector<int>& A) {
        stack<pair<int, int>> leftStack, rightStack;
        int n = A.size();
        int left[n], right[n];

        leftStack.emplace(-1, -1);  // val, idx
        for (int i = 0; i < n; i++) {
            while (!leftStack.empty() && leftStack.top().first >= A[i])
                leftStack.pop();
            if (leftStack.top().second == -1)
                left[i] = i;
            else
                left[i] = i - leftStack.top().second - 1;

            leftStack.emplace(A[i], i);
        }

        rightStack.emplace(-1, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.empty() && rightStack.top().first > A[i])
                rightStack.pop();
            if (rightStack.top().second == -1)
                right[i] = n - i - 1;
            else
                right[i] = rightStack.top().second - i - 1;

            rightStack.emplace(A[i], i);
        }

        long long int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (left[i] + 1) * (right[i] + 1) * (long long int) A[i] % 1000000007;
            sum %= 1000000007;
        }
        return sum;
    }
};