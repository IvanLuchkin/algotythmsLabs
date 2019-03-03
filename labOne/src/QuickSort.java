import java.util.Scanner;

public class QuickSort {
    public static int arrayLength = (new Scanner(System.in).nextInt());
    private static int[] array = new int[arrayLength];

    public static void fillArray() {
        for(int i = 0; i < arrayLength; i++) {
            array[i] = (int)(Math.random() * 10000);
        }
    }
    public static void printArray() {
        for(int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + ", ");
        }
    }
    private static void sort(int start, int end) {
        if(start >= end)
            return;
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while(i < j) {
            while((i < pivot) && (array[i] <= array[pivot])) {
                i++;
            }
            while(j > pivot && (array[pivot] <= array[j])) {
                j--;
            }
            if(i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if(i == pivot) {
                    pivot = j;
                } else if(j == pivot) {
                    pivot = j;
                }
            }
            sort(start, pivot);
            sort(pivot + 1, end);
        }
    }
    public static void quickSort() {
        int startIndex = 0;
        int endIndex = arrayLength - 1;
        sort(startIndex, endIndex);
    }

    public static void main(String[] args) {
        long m = System.currentTimeMillis();

        QuickSort arrayObj = new QuickSort();
        fillArray();
        printArray();
        System.out.println();
        quickSort();
        printArray();

        System.out.println((double) (System.currentTimeMillis() - m));
    }


}
