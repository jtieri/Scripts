import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String outputFile = "output\\output.txt"; // default output file location/name

        Scanner keyboard = new Scanner(System.in);
        Scanner inputFileReader;
        File inputFile;
        String inputFileName;
        int functionalityOp;

        System.out.println("Enter the file whose contents you want to QuoteDump.");

        inputFileName = keyboard.nextLine();
        inputFile = new File(inputFileName);

        try {
            inputFileReader = new Scanner(inputFile);
        } catch (IOException ex) {
            throw new RuntimeException("The file " + inputFileName + "was not found on the filesystem");
        }

        System.out.println("Enter 1 to strip quotes or 2 to reinsert quotes.");

        functionalityOp = keyboard.nextInt();

        if (functionalityOp == 1) {
            inputFileReader.useDelimiter("\""); // Scanner will read up till the first " instead of default whitespace

            try (BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFile))){
                while (inputFileReader.hasNext()) {
                    String nextString = inputFileReader.next();

                    if (! (nextString.equals(" "))) {
                        outputFileWriter.write(nextString + "\n");
                    }
                }
            } catch (IOException ex) {
                System.out.printf("There was an error writing to the output file %s", outputFile);
            }

        } else if (functionalityOp == 2) {
            try (BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFile))){
                while (inputFileReader.hasNext()) {
                    String nextString = inputFileReader.next();

                    if (! (nextString.equals(" "))) {
                        outputFileWriter.write("\"" + nextString + "\"" + " ");
                    }
                }
            } catch (IOException ex) {
                System.out.printf("There was an error writing to the output file %s", outputFile);
            }
        }

        keyboard.close();
        inputFileReader.close();
    }


}
