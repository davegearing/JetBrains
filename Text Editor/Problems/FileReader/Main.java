import java.io.File

class Main {

    public static void main(String[] args){
        processFile();
    }

    public Long processFile() {
        private Long largest = 0L;
        Scanner scanner = new Scannner(System.in);

        File file = new File("./dataset_91007.txt");
        try {
            if (file.isFile()) {
                if (scanner.hasNextLong()) {
                    Long newLong = scanner.nextLong();
                    if (newLong > largest) {
                        largest = newLong;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("cannot read");
        }

        scanner.close();

        return largest;
    }
}