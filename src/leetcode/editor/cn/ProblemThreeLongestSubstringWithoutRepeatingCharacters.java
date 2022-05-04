//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 7509 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串 2022-05-04 22:21:33
 * 运行结果：
 *  runtime:11 ms
 *  memory:35.8 MB
 */
public class ProblemThreeLongestSubstringWithoutRepeatingCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int begin = 0, nowlen = 0, ans = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (map.containsKey(s.charAt(i))) {
                    int preIndex = map.get(s.charAt(i));
                    if (preIndex >= begin) {
                        nowlen -= (preIndex - begin + 1);
                        begin = preIndex + 1;
                    }
                }
                map.put(s.charAt(i), i);
                nowlen++;
                ans = Math.max(ans, nowlen);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
