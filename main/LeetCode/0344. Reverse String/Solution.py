class Solution(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        b = 0
        e = len(s)-1
        while b < e:
            tmp = s[b]
            s[b] = s[e]
            s[e] = tmp
            b += 1
            e -= 1
        