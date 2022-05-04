//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 5170 👎 0


package leetcode.editor.cn;

/**
 * 最长回文子串 2022-05-04 22:24:50
 * 运行结果：
 *  runtime:87 ms
 *  memory:36.4 MB
 */
public class ProblemFiveLongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.isEmpty()) return s;
            int ansBegin = 0, ansEnd = 0;
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i == 1) dp[j][i - 1] = true;
                    else if (j + i <= len) {
                        boolean flag = s.charAt(j) == s.charAt(j + i - 1);
                        dp[j][i - 1] = i == 2 ? flag : dp[j + 1][i - 1 - 2] && flag;
                        if (dp[j][i - 1] && i - 1 > ansEnd - ansBegin) {
                            ansBegin = j;
                            ansEnd = j + i - 1;
                        }
                    }
                }
            }
            return s.substring(ansBegin, ansEnd + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
