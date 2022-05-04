//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3501 👎 0


package leetcode.editor.cn;

/**
 * 整数反转 2022-05-04 22:26:12
 * 运行结果：
 *  runtime:2 ms
 *  memory:33 MB
 */
public class ProblemSevenReverseInteger {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long ans = 0;
            while (x != 0) {
                ans = ans * 10 + x % 10;
                x /= 10;
            }
            if (ans > ((2L << 30) - 1) || ans < ((2L << 30) * -1)) {
                return 0;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
