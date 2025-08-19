import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetReader {

    public static List<Book> readDataset(String filePath) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                try {
                    Book book = parseBookFromLine(line);
                    if (book != null) {
                        books.add(book);
                    }
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + line);
                    System.err.println("Error message: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }

        return books;
    }

    private static Book parseBookFromLine(String line) {
        List<String> values = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentValue = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                values.add(currentValue.toString().trim());
                currentValue = new StringBuilder();
            } else {
                currentValue.append(c);
            }
        }
        values.add(currentValue.toString().trim());

        if (values.size() != 7) {
            System.err.println("Invalid line format, expected 7 columns: " + line);
            return null;
        }

        try {
            String title = values.get(0).replace("\"", "");
            String author = values.get(1).replace("\"", "");
            double userRating = Double.parseDouble(values.get(2));
            int reviews = Integer.parseInt(values.get(3).replace(",", ""));
            double price = Double.parseDouble(values.get(4));
            int year = Integer.parseInt(values.get(5));
            String genre = values.get(6).replace("\"", "");

            return new Book(title, author, userRating, reviews, price, year, genre);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values in line: " + line);
            e.printStackTrace();
            return null;
        }
    }
}
