import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args){
        processFile();
    }

    public static void processFile() {
        Long largest = 0L;
        Long populationIncrease = 0L;
        long lastPopulation = 0L;
        long populationYear = 0L;

        //File file = new File("C:\\Users\\dgearing\\IdeaProjects\\Text Editor\\Problems\\FileReader\\dataset_91007.txt");
        File file = new File("C:\\Users\\dgearing\\IdeaProjects\\Text Editor\\Problems\\FileReader\\dataset_91069.txt");
        boolean isFile = file.exists();
        try (Scanner scanner = new Scanner(file)) {
            //while (scanner.hasNextLong()) {     // for file 91007.txt
            //    Long newLong = scanner.nextLong();
            //    if (newLong > largest) {
            //        largest = newLong;
            //    }
            //}                                   // for file 91007.txt

            String fileHeader = scanner.nextLine(); // for file 91069.txt ignore the header line

            while (scanner.hasNextLine()) {     // for file 91069.txt
                String newStr = scanner.nextLine().replace(",", "");
                String[] yearAndPopulation = newStr.split("\t");

                if (lastPopulation == 0L) {
                    lastPopulation = Long.parseLong(yearAndPopulation[1]);
                } else {
                    Long newIncrease = Long.parseLong(yearAndPopulation[1]) - lastPopulation;
                    if (newIncrease > populationIncrease) {
                        populationIncrease = newIncrease;
                        populationYear = Long.parseLong(yearAndPopulation[0]);
                    }
                    lastPopulation = Long.parseLong(yearAndPopulation[1]);
                }
            }                                   // for file 91069.txt

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " );
        }

        System.out.println("Largest = " + largest);

        System.out.println("Year: " + populationYear);
    }
}

