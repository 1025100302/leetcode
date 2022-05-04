//在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能
//围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
//解释:
//
// 
//
// 示例 2: 
//
// 输入: [[1,2],[2,2],[4,2]]
//输出: [[1,2],[2,2],[4,2]]
//解释:
//
//即使树都在一条直线上，你也需要先用绳子包围它们。
// 
//
// 
//
// 注意: 
//
// 
// 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。 
// 输入的整数在 0 到 100 之间。 
// 花园至少有一棵树。 
// 所有树的坐标都是不同的。 
// 输入的点没有顺序。输出顺序也没有要求。 
// Related Topics 几何 数组 数学 
// 👍 159 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * 安装栅栏 2022-04-23 17:11:48
 * 运行结果：
 */
public class ProblemFive87ErectTheFence {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orientation(int[] p, int[] q, int[] r) {
            return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
        }

        public int[][] outerTrees(int[][] points) {
            Arrays.sort(points, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
            Stack<int[]> hull = new Stack<>();
            for (int[] point : points) {
                while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) > 0)
                    hull.pop();
                hull.push(point);
            }
            hull.pop();
            for (int i = points.length - 1; i >= 0; i--) {
                while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
                    hull.pop();
                hull.push(points[i]);
            }
            HashSet<int[]> set = new HashSet<>(hull);
            return set.toArray(new int[set.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
