package class021;

import java.util.Arrays;

public class Test021 {

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    private void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int index = left;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= right) {
            help[index++] = arr[p2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, -1, 2, 4, 6, 68, 7, 8, 8, 8, 8};
        Test021 t = new Test021();
        t.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
