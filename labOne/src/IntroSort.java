public class IntroSort {
    /*
     * Class Variables
     */
    private static final int SIZE_THRESHOLD = 16;
    /*
     * Public interface
     */
    public static void sort(int[] a) {
        introsortLoop(a, 0, a.length, 2 * floorLog(a.length));
    }
    public static void sort(int[] a, int begin, int end) {
        if (begin < end) {
            introsortLoop(a, begin, end, 2 * floorLog(end - begin));
        }
    }
    /*
     * Quicksort algorithm modified for Introsort
     */
    private static void introsortLoop (int[] a, int lo, int hi, int depthLimit) {
        while (hi - lo > SIZE_THRESHOLD) {
            if (depthLimit == 0) {
                heapSort(a, lo, hi);
                return;
            }
            depthLimit -= 1;
            int p = partition(a, lo, hi, medianOfThree(a, lo, lo + ((hi - lo) / 2) + 1, hi - 1));
            introsortLoop(a, p, hi, depthLimit);
            hi = p;
        }
        insertionSort(a, lo, hi);
    }
    private static int partition(int[] a, int lo, int hi, int x) {
        int i = lo, j = hi;
        while (true) {
            while (a[i] < x)
                i++;
                j -= 1;
            while (x < a[j])
                j -= 1;
            if(!(i < j))
                return i;
            exchange(a, i, j);
            i++;
        }
    }
    private static int medianOfThree(int[] a, int lo, int mid, int hi) {
        if (a[mid] < a[lo]) {
            if (a[hi] < a[mid])
                return a[mid];
            else {
                if (a[hi] < a[lo])
                    return a[hi];
                else
                    return a[lo];
            }
        }
        else {
            if (a[hi] < a[mid]) {
                if (a[hi] < a[lo])
                    return a[lo];
                else
                    return a[hi];
            }
            else
                return a[mid];
        }
    }
    /*
     * Heapsort algorithm
     */
    private static void heapSort(int[] a, int lo, int hi) {
        int n = hi - lo;
        for (int i = n / 2; i >= 1; i -= 1) {
            downHeap(a, i, n, lo);
        }
        for (int i = n; i > 1; i -= 1) {
            exchange(a, lo, lo + i - 1);
            downHeap(a, 1, i - 1, lo);
        }
    }
    private static void downHeap(int[] a, int i, int n, int lo) {
        int d = a[lo + i - 1];
        int child;
        while (i <= n / 2) {
            child = 2 * i;
            if (child < n && a[lo + child - 1] < a[lo + child]) {
                child++;
            }
            if (d >= a[lo + child - 1]) break;
            a[lo + i - 1] = a[lo + child - 1];
            i = child;
        }
        a[lo + i - 1] = d;
    }
    /*
     * Insertion sort algorithm
     */
    private static void insertionSort(int[] a, int lo, int hi) {
        int i;
        int j;
        int t;
        for (i = lo; i < hi; i++) {
            j = i;
            t = a[i];
            while(j != lo && t < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }
    }
    /*
     * Common methods for all algorithms
     */
    private static void exchange(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static int floorLog(int a) {
        return (int)(Math.floor(Math.log(a)/Math.log(2)));
    }


}
