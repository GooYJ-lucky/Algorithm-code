package java_com.sort;

import java.util.Arrays;

public class Sort1 {
    /*
    * 插入排序
    * */
    public static void InsertionSort(int[] a, int n){
        if(n <= 1){
            return;
        }
        for (int i = 1; i < n; i++){
            int value = a[i];
            int j = i - 1;
            for (;j >= 0; --j){
                if (a[j] > value) {
                    a[j + 1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
        }

    }

    /*
    * 冒泡排序
    * */
    public static void bubbleSort(int[] a, int n){
        if(n <= 1)return;

        for (int i = 0; i < n; i++){
            boolean flag = false;
            for(int j = 0; j < n-i-1; j++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag)break;
        }

    }
    /*
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     * */
    public static void bubbleSort2(int[] a,int n){
        if(n <= 1)return;

        //最后一次交换的位置
        int lastExchange = 0;

        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;

        for (int i = 0; i < n; i++){
            boolean flag = false;
            for(int j = 0; j < sortBorder; j++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag)break;
        }

    }

    /*
     * 选择排序
     * */
    public static void selectionSort(int[] a, int n){
        if(n <= 1)return;

        for (int i = 0; i < n-1; ++i){
            int minIndex = i;
            for(int j = i+1; j < n; j++ ){
                if (a[j] < a[minIndex]) {
                    minIndex = j;

                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }


    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        selectionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
