import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String outputFile = "output\\output.txt";

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the file whose contents you want to QuoteDump.");

        String fileName = keyboard.nextLine();
        File inputFile = new File(fileName);

        Scanner inputFileReader = null;
        try {
            inputFileReader = new Scanner(inputFile);
        } catch (IOException ex) {
            System.out.printf("The file %s was not found on the filesystem", inputFile);
        }

        inputFileReader.useDelimiter("\""); // Scanner will read up till the first " instead of default whitespace

        while (inputFileReader.hasNext()) {
            String nextString = inputFileReader.next();

            System.out.println(nextString);
        }

        keyboard.close();
        inputFileReader.close();
    }


}
