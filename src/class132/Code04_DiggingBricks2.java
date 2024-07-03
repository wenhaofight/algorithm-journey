package class132;

// 从上到下挖砖块(优化枚举+空间压缩)
// 一堆组成倒三角形状的砖埋在地里，一共有n层，第1层有n块砖，每层递减，类似如下数据
// 4 2 9 5
//  3 1 7
//   2 4
//    8
// 你需要从第1层开始挖，每挖开一块砖都可以获得数值作为收益
// 第一层的砖块可以随意挑选，但是想挖到下面的砖块是有条件的
// 如果你想挖i层的第j号砖，你需要确保i-1层的第j块、i-1层的第j+1块砖已经被挖开
// 比如，想挖2层第3号砖，也就是7数值的位置，那必须把第一层数值9、5的这两块砖挖开才行
// 你最多可以挖m块砖，返回最大的收益
// 1 <= n <= 50
// 1 <= m <= 1300
// 砖块数值 <= 100
// 测试链接 : https://www.luogu.com.cn/problem/P1437
// 提交以下的code，提交时请把类名改成"Main"，可以通过所有用例

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code04_DiggingBricks2 {

	public static int MAXN = 51;

	public static int MAXM = 1301;

	public static int[][] grid = new int[MAXN][MAXN];

	public static int[][] dp = new int[MAXN][MAXM];

	public static int[][] max = new int[MAXN][MAXM];

	public static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int) in.nval;
		in.nextToken();
		m = (int) in.nval;
		for (int j = 1; j <= n; j++) {
			for (int i = n; i >= j; i--) {
				in.nextToken();
				grid[i][j] = (int) in.nval;
			}
		}
		out.println(compute());
		out.flush();
		out.close();
		br.close();
	}

	// 优化枚举 + 空间压缩
	// 时间复杂度O(n^2 * m)
	public static int compute() {
		int sum;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += grid[i][j];
				for (int k = (j + 1) * j / 2; k <= m; k++) {
					dp[j][k] = max[Math.max(0, j - 1)][k - j] + sum;
					ans = Math.max(ans, dp[j][k]);
				}
			}
			prepare(i);
		}
		return ans;
	}

	// 预处理结构优化枚举
	public static void prepare(int i) {
		for (int col = 0; col <= m; col++) {
			for (int row = Math.min(col, i), tmp = 0; row >= 0; row--) {
				max[row][col] = Math.max(tmp, dp[row][col]);
				tmp = max[row][col];
			}
		}
	}

}
