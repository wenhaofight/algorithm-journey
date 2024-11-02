package class025;

import java.io.*;

public class Test025 {
    public static int MAXN = 50001;
    public static int[] arr = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        heapSort();
        for (int i = 0; i < n; i++) {
            out.print(arr[i] + " ");
        }
        out.flush();
        out.close();
        br.close();
    }

    private static void heapSort() {
        for (int i = n - 1; i >= 0; i--) {
            heapify(i, n);
        }
    }

    private static void heapify(int i, int size) {

    }
}
