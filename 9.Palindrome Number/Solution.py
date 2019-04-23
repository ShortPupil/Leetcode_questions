class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0 or (x != 0 and x%10 == 0):
            return False

        y = 0
        while x > y:
            y = y*10 + x%10
            x = x/10
        return x == y or y/10 == x