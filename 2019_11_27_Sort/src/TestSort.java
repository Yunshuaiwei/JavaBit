import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author DELL
 */
public class TestSort {

    /**
     *最坏情况下： 时间复杂度为O(n^2)   无序的时候
     *最好情况下： 时间复杂度为O(n)    有序的时候
     *             越有序越快
     *稳定性：稳定
     * @param array
     */
    public static void insertSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                //如果加== 他就是一个不稳定的排序
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    /**
     * gap->组数  进行组内直接插入排序
     * @param array
     * @param gap
     */
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i+=1) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0 ; j-=gap) {
                //如果加== 他就是一个不稳定的排序
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5,3};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }
        public static void  adjustDown(int[]elem , int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            //判断是否有右孩子 且谁最大
            if(child+1 < len && elem[child] <
                    elem[child+1]) {
                child = child+1;
            }
            //child肯定是左右孩子的最大值下标
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void heapSort(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
        //每次调整的结束位置  9
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }

    /**
     * 时间复杂度：O(n^2)
     *     1  2  3  4  5  6
     * 空间复杂度：O(1)
     * 稳定的排序
     * @param array
     */
    public static  void bubbleSort(int[] array) {
        boolean flg = false;
        //i->趟数
        for (int i = 0; i < array.length-1; i++) {
            flg = false;
            //j->下标
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(!flg) {
                break;
            }
        }
    }

    public static int partion(int[] array,
                              int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            if(low >= high) {
                break;
            }else {
                array[low] = array[high];
            }

            while (low < high && array[low] <= tmp) {
                low++;
            }
            if(low >= high) {
                break;
            }else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }

    public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void threeNumMid(int[] array,int low,int high) {
        //array[low]     array[high]    array[mid]    2   7   5
        //array[mid] <= array[low] <= array[high]
        int mid = (low+high)/2;
        if(array[mid] > array[low]) {
            //  7   2     5
            swap(array,low,mid);
        }
        if(array[mid] > array[high]) {
            //  5   2    7
            swap(array,high,mid);
        }
        if(array[low] > array[high]) {
            // 5   2    7
            swap(array,low,high);
        }
    }

    public static void insertSort(int[] array,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= low ; j--) {
                //如果加== 他就是一个不稳定的排序
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    /**
     *  n*log2n         空间复杂度：log2n
     *  1 2 3 4 5 6 7   最坏情况：有序的时候-》O(n^2)
     *                  O(n)
     * @param array
     * @param low
     * @param high
     */
    public static void quick(int[] array,int low,int high) {

       /*if(high-low+1 <= 100) {
            insertSort(array,low,high);
            return;
        }

        threeNumMid(array,low,high);*/

        int par = partion(array,low,high);
        if(par > low+1) {
            quick(array,low,par-1);
        }
        if(par < high-1) {
            quick(array,par+1,high);
        }
    }

    public static void quickSort1(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length-1;
        int par = partion(array,low,high);
        if(par > low+1) {
            stack.push(low);
            stack.push(par-1);
        }
        if(par < high-1) {
            stack.push(par+1);
            stack.push(high);
        }
        while (!stack.empty()) {
            //1、取出数对
            high = stack.pop();
            low = stack.pop();
            //2.par
            par = partion(array,low,high);
            if(par > low+1) {
                stack.push(low);
                stack.push(par-1);
            }
            if(par < high-1) {
                stack.push(par+1);
                stack.push(high);
            }
        }

    }
        public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] =random.nextInt(100000) ;
        }
        long time1 = System.currentTimeMillis();
        quickSort(array);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        System.out.println(Arrays.toString(array));
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
