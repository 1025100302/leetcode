//假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例： 
//
// 
//
// 这里将 dir 作为根目录中的唯一目录。dir 包含两个子目录 subdir1 和 subdir2 。subdir1 包含文件 file1.ext 和子目
//录 subsubdir1；subdir2 包含子目录 subsubdir2，该子目录下包含文件 file2.ext 。 
//
// 在文本格式中，如下所示(⟶表示制表符)： 
//
// 
//dir
//⟶ subdir1
//⟶ ⟶ file1.ext
//⟶ ⟶ subsubdir1
//⟶ subdir2
//⟶ ⟶ subsubdir2
//⟶ ⟶ ⟶ file2.ext
// 
//
// 如果是代码表示，上面的文件系统可以写为 "dir
//\tsubdir1
//\t\tfile1.ext
//\t\tsubsubdir1
//\tsubdir2
//\t\tsubsubdir2
//\t\t\tfile2.ext" 。'
//' 和 '\t' 分别是换行符和制表符。 
//
// 文件系统中的每个文件和文件夹都有一个唯一的 绝对路径 ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 '/' 连接。上面例子中，指向 fil
//e2.ext 的 绝对路径 是 "dir/subdir2/subsubdir2/file2.ext" 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 n
//ame.extension 的格式，其中 name 和 extension由字母、数字和/或空格组成。 
//
// 给定一个以上述格式表示文件系统的字符串 input ，返回文件系统中 指向 文件 的 最长绝对路径 的长度 。 如果系统中没有文件，返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：input = "dir
//\tsubdir1
//\tsubdir2
//\t\tfile.ext"
//输出：20
//解释：只有一个文件，绝对路径为 "dir/subdir2/file.ext" ，路径长度 20
// 
//
// 示例 2： 
//
// 
//输入：input = "dir
//\tsubdir1
//\t\tfile1.ext
//\t\tsubsubdir1
//\tsubdir2
//\t\tsubsubdir2
//\t\t\tfile2.ext"
//输出：32
//解释：存在两个文件：
//"dir/subdir1/file1.ext" ，路径长度 21
//"dir/subdir2/subsubdir2/file2.ext" ，路径长度 32
//返回 32 ，因为这是最长的路径 
//
// 示例 3： 
//
// 
//输入：input = "a"
//输出：0
//解释：不存在任何文件 
//
// 示例 4： 
//
// 
//输入：input = "file1.txt
//file2.txt
//longfile.txt"
//输出：12
//解释：根目录下有 3 个文件。
//因为根目录中任何东西的绝对路径只是名称本身，所以答案是 "longfile.txt" ，路径长度为 12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= input.length <= 104 
// input 可能包含小写或大写的英文字母，一个换行符 '
//'，一个制表符 '\t'，一个点 '.'，一个空格 ' '，和数字。 
// 
// Related Topics 栈 深度优先搜索 字符串 
// 👍 208 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件的最长绝对路径 2022-04-20 20:55:44
 * 运行结果：
 *      执行耗时:1 ms,击败了65.17% 的Java用户
 *      内存消耗:39 MB,击败了75.76% 的Java用户
 */
public class ProblemThree88LongestAbsoluteFilePath {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String input) {
            input = input + '\n';
            int ans = 0;
            // 记录每一层的长度
            Map<Integer, Integer> recordMap = new HashMap<>();
            int len = input.length();
            // level表示文件层级，curLen表示当前文件夹名或文件名的长度
            int level = 0, curLen = 0;
            boolean isFile = false;
            for (int i = 0; i < len; i++) {
                char c = input.charAt(i);
                if (c != '\n' && c != '\t') {
                    curLen++;
                    if (c == '.') isFile = true;
                } else {
                    // 当前层级的长度等于上一层的长度+1（连接符：/）
                    if (curLen > 0) recordMap.put(level, recordMap.getOrDefault(level - 1, 0) + curLen + 1);
                    if (input.charAt(i) == '\n') {
                        // 只记录文件的路径长度，忽略文件夹的路径长度
                        if (isFile) ans = Math.max(ans, recordMap.get(level));
                        level = 0;
                    } else {
                        level++;
                    }
                    curLen = 0;
                    isFile = false;
                }
            }
            return Math.max(0, ans - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
