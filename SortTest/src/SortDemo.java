import java.util.Arrays;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/19 20:39
 * @Version
 **/
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 4, 3};
        SortDemo s = new SortDemo();
//        s.bubbleSort(arr);
//        s.quickSort(arr, 0, arr.length - 1);
        s.sortHeap2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort1(int[] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public void quickSort1(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort1(arr, left, r);
        }
        if (right > l) {
            quickSort1(arr, l, right);
        }
    }

    public void quickSort2(int[] arr, int left, int right) {
//        int[] arr = {6, 8, 2, 1, 0, 3, 5, 4, 7, 9, 10};
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[r];
        while (true) {
            while (l <= r && arr[l] < pivot) {
                l++;
            }
            while (l <= r && arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];

        }
        arr[l] ^= pivot;
        pivot ^= arr[l];
        arr[l] ^= pivot;
        quickSort2(arr, left, l - 1);
        quickSort2(arr, l + 1, right);
    }

    public void quickSort3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[r];
        while (true) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
        }
        arr[l] ^= pivot;
        pivot ^= arr[l];
        arr[l] ^= pivot;
        quickSort3(arr, left, r - 1);
        quickSort3(arr, l, right);
    }

    public void bubbleSort(int[] arr) {
        //int[] arr = {6, 8, 2, 1, 0, 3, 5, 4, 7, 9, 10};
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        //int[] arr = {6, 8, 2, 1, 0, 3, 5, 4, 7, 9};
        if (left >= right) {
            return;
        }
        int pivot = arr[right];
        int l = left;
        int r = right - 1;
        while (l <= r) {
            while (l <= r && arr[l] < pivot) {
                l++;
            }
            while (l <= r && arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
        }
        arr[l] ^= arr[right];
        arr[right] ^= arr[l];
        arr[l] ^= arr[right];
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }


    /**
     * 堆排序
     *
     * @return void
     * @Param [arr]
     **/
    public void sortHeap(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     *
     * @return void
     * @Param [arr, i, length]
     **/
    public void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public void sortHeap2(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap1(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap1(arr, 0, i);

        }
    }

    public void adjustHeap1(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }


}
