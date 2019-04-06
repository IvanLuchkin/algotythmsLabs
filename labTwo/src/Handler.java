import java.io.FileNotFoundException;
import java.util.Scanner;

public class Handler {
    private final static String file = "/home/ivan/IdeaProjects/algotythmsLabs/labTwo/src/dict.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.inputArrayOfBuckets();
        hashMap.inputVocabulary(file, hashMap);
        System.out.println("Enter a sentence:");
        String line = scanner.nextLine();
        String[] buffer = line.split(" ");
        for (int itter = 0; itter < buffer.length; itter++) {
            System.out.println(hashMap.get(buffer[itter]));
        }
    }
}