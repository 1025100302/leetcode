//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 5404 👎 0


package leetcode.editor.cn;

/**
 * 寻找两个正序数组的中位数 2022-05-04 22:22:40
 * 运行结果：
 *  runtime:3 ms
 *  memory:45.1 MB
 */
public class ProblemFourMedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length;
            int length2 = nums2.length;
            int mid1 = (length1 + length2) / 2;
            int mid2 = (length1 + length2) % 2 == 0 ? mid1 - 1 : mid1;

            double ans = 0;
            int index1 = 0, index2 = 0;
            for (int i = 0; i <= mid1; i++) {
                int tmp;
                if (index1 > length1 - 1) tmp = nums2[index2++];
                else if (index2 > length2 - 1) tmp = nums1[index1++];
                else if (nums1[index1] < nums2[index2]) tmp = nums1[index1++];
                else tmp = nums2[index2++];
                if (i == mid2) ans += tmp;
                if (i == mid1) ans += tmp;
            }
            return ans / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
