class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        res = 0
        flag = -1 if x<0 else 1
        x = x * flag

        while(x):
            res = res*10 + x%10
            x = x/10
        if res > 0x7FFFFFFF:
            return 0
        return res*flag
        