package class125;

// 测试链接 : https://www.luogu.com.cn/problem/P2435
// 提交以下的code，提交时请把类名改成"Main"，可以通过所有用例
// 空间压缩的版本才能通过

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code03_Colors2 {

	public static int n, m, k;

	public static int LIMIT1 = 100001;

	public static int[] start = new int[LIMIT1];

	public static int[] end = new int[LIMIT1];

	public static int LIMIT2 = 8;

	public static int[][] dp = new int[LIMIT2 + 1][1 << (LIMIT2 << 1)];

	public static int[] backup = new int[1 << (LIMIT2 << 1)];

	public static int startStatus;

	public static int endStatus;

	public static int MOD = 376544743;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int) in.nval;
		in.nextToken();
		m = (int) in.nval;
		in.nextToken();
		k = (int) in.nval;
		for (int i = 0; i < m; i++) {
			in.nextToken();
			start[i] = (int) in.nval;
		}
		for (int i = 0; i < m; i++) {
			in.nextToken();
			end[i] = (int) in.nval;
		}
		if (k == 2) {
			out.println(special());
		} else {
			out.println(compute());
		}
		out.flush();
		out.close();
		br.close();
	}

	public static int special() {
		if ((n & 1) == 0) {
			for (int i = 0; i < m; i++) {
				if (start[i] == end[i]) {
					return 0;
				}
			}
		} else {
			for (int i = 0; i < m; i++) {
				if (start[i] != end[i]) {
					return 0;
				}
			}
		}
		return 1;
	}

	public static int compute() {
		startStatus = endStatus = 0;
		for (int i = 0, j = 0; i < m; i++, j += 2) {
			startStatus |= start[i] << j;
			endStatus |= end[i] << j;
		}

		for (int s = 0; s < 1 << (m << 1); s++) {
			backup[s] = check(s, endStatus) ? 1 : 0;
		}
		int ans;
		for (int i = n - 2; i >= 1; i--) {
			for (int s = 0; s < 1 << (m << 1); s++) {
				dp[m][s] = backup[s];
			}
			for (int j = m - 1; j >= 0; j--) {
				for (int s = 0; s < 1 << (m << 1); s++) {
					ans = 0;
					for (int color = 0; color < k; color++) {
						if ((j == 0 || ((s >> ((j - 1) << 1)) & 3) != color) && ((s >> (j << 1)) & 3) != color) {
							ans = (ans + dp[j + 1][setColor(s, color, j)]) % MOD;
						}
					}
					dp[j][s] = ans;
				}
			}
			for (int s = 0; s < 1 << (m << 1); s++) {
				backup[s] = dp[0][s];
			}
		}
		return dp[0][startStatus];
	}

	public static boolean check(int a, int b) {
		for (int i = 0, j = 0; i < m; i++, j += 2) {
			if (((a >> j) & 3) == ((b >> j) & 3)) {
				return false;
			}
		}
		return true;
	}

	public static int setColor(int s, int c, int j) {
		int i = j << 1;
		return s & (~((1 << i) | (1 << (i | 1)))) | (c << i);
	}

}