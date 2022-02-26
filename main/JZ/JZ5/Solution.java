package code.JZ5;

/**描述
 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

 数据范围:0 \le len(s) \le 1000 \0≤len(s)≤1000 。保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
 进阶：时间复杂度 O(n)\O(n)  ,空间复杂度 O(n) \O(n) */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    /**适用stringbuild构建新字符串，遇到空格换成%20*/
    public String replaceSpace (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ' '){
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    /**通过“” 进行字符串拆分，将空格元素替换成%20*/
    public String replaceSpace1 (String s) {
        // write code here
        if(s == null) return s;
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split("");
        for(int i = 0 ; i<strs.length ; i++) {
            if(" ".equals(strs[i])) sb.append("%20");
            else sb.append(strs[i]);
        }
        return sb.toString();
    }
}