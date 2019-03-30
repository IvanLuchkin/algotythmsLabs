public class Handler {

    public static void main(String[] args) {
        long m = System.currentTimeMillis();

        int[] array = new int[100];
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = array.length - 1 - i;
            if(i % 10 == 0)
                System.out.println();
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        IntroSort.sort(array);
        for (int i = 0; i <= array.length - 1; i++) {
            if(i % 10 == 0)
                System.out.println();
            System.out.print(array[i] + ", ");
        }
        System.out.println();
       System.out.println(IntroSort.exchanges);
        System.out.println(IntroSort.comparisons);

        System.out.println((double) (System.currentTimeMillis() - m));
    }
}
