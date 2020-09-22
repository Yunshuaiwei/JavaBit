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
        insertSort(arr);
//        shellSort(arr);
//        bubbleSort(arr);
        quickSort(arr, 0, arr.length - 1);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @return void
     * @Param
     * @Date 22:53 2020/7/31
     * @Description: 插入排序
     * 时间复杂度O(n^2)
     **/
    private static void insertSort(int[] arr) {
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

    /**
     * @return void
     * @Param
     * @Date 0:06 2020/8/6
     * @Description: 快速排序
     **/
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {//递归跳出条件
            //划分区域
            int pivot = partition(arr, low, high);
            //划分左子表
            quickSort(arr, low, pivot - 1);
            //划分右子表
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * @return int
     * @Param
     * @Date 23:28 2020/8/1
     * @Description: 区间调整
     **/
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            //从右边开始找到比基准值小的元素
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            //将该元素移动到基准值的左边
            arr[low] = arr[high];
            //从左边开始找到比基准值大的元素
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            //将该元素移动到基准值的右边
            arr[high] = arr[low];
        }
        //将基准值填到空的位置
        arr[low] = pivot;
        //此时low和high都指向基准值所在的位置
        return low;
    }

    /**
     * @return void
     * @Param
     * @Date 0:07 2020/8/6
     * @Description: 堆排序
     **/
    public static void heapSort(int[] arr) {
        buildMaxHeap(arr, arr.length - 1);
        for (int i = arr.length - 1; i > 0; i--) {//n-1趟排序
            //交换堆顶元素和最后一个元素
            arr[0] ^= arr[i];
            arr[i] ^= arr[0];
            arr[0] ^= arr[i];
            //将剩余的元素调整为堆
            heapAdjust(arr, 0, i - 1);
        }
    }

    /**
     * @return void
     * @Param
     * @Date 11:20 2020/8/2
     * @Description: 构建大顶堆
     **/
    private static void buildMaxHeap(int[] arr, int len) {
        int i = len / 2;
        while (i >= 0) {
            heapAdjust(arr, i, len);
            i--;
        }
    }

    /**
     * @return void
     * @Param
     * @Date 11:17 2020/8/2
     * @Description: 将以k为根节点的子树调整为大顶堆
     **/
    private static void heapAdjust(int[] arr, int k, int len) {
        int tmp = arr[k];
        for (int i = 2 * k; i <= len; i *= 2) {
            //找以i为根节点子节点中较大的一个
            if (i < len && arr[i] < arr[i + 1]) {
                i++;
            }
            //根节点比子节点大，此时该子树已经是大顶堆，则退出循环
            if (tmp >= arr[i]) {
                break;
            } else {
                arr[k] = arr[i];
                //i位置的元素被赋值到k处，则i处需要元素来填充
                k = i;
            }
        }
        arr[k] = tmp;
    }


}
