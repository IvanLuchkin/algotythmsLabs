public class Handler {

    public static void main(String[] args) {
        long m = System.currentTimeMillis();

        int[] array = new int[5000];
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = (int) (Math.random() * 10000);
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        /*
        IntroSort.sort(array);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        */


        System.out.println((double) (System.currentTimeMillis() - m));
    }
}
