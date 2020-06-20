import java.util.Arrays;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/19 20:39
 * @Version
 **/
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {6, 8, 2, 1, 0, 3, 5, 4, 7, 9, 10};
        SortDemo s = new SortDemo();
//        s.bubbleSort(arr);
        s.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr) {
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

    public void quickSort(int[] arr, int left, int right) {
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
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);

    }


}
