package day01;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 22:07
 * @Version
 **/
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 9, 1, 2, 6, 4, 7, 0, 8};
//        InsertSort(arr);
//        shellSort(arr);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @return void
     * @Param
     * @Date 22:53 2020/7/31
     * @Description: 插入排序
     * 时间复杂度O(n^2)
     **/
    private static void InsertSort(int[] arr) {
        int tmp, k = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                tmp = arr[i];
                for (int j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                    arr[j + 1] = arr[j];
                    k = j;
                }
                arr[k] = tmp;
            }
        }
    }

    /**
     * @return void
     * @Param
     * @Date 23:14 2020/7/31
     * @Description: 希尔排序
     **/
    private static void shellSort(int[] arr) {
        int d, tmp, k = 0;
        for (d = arr.length / 2; d >= 1; d /= 2) {
            for (int i = d; i < arr.length; i++) {
                if (arr[i] < arr[i - d]) {
                    tmp = arr[i];
                    for (int j = i - d; j >= 0 && arr[j] > tmp; j -= d) {
                        arr[j + d] = arr[j];
                        k = j;
                    }
                    arr[k] = tmp;
                }
            }
        }
    }

    /**
     * @return void
     * @Param
     * @Date 23:44 2020/7/31
     * @Description: 冒泡排序
     * 时间复杂度O(n^2)
     **/
    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            if (flag) {
                return;
            }
        }
    }


}
