import java.util.List;

public class Driver {

    public static void main(String[] args) {
        String datasetPath = "data/data.csv";

        System.out.println("Reading dataset from: " + datasetPath);
        List<Book> books = DatasetReader.readDataset(datasetPath);
        System.out.println("Successfully loaded " + books.size() + " books from the dataset.\n");

        System.out.println("Sample books from the dataset:");
        for (int i = 0; i < Math.min(3, books.size()); i++) {
            books.get(i).printDetails();
        }

        String author1 = "J.K. Rowling";
        int bookCount = BookAnalyzer.countBooksByAuthor(books, author1);
        System.out.println("\nTask 1: Total number of books by " + author1 + ": " + bookCount);

        System.out.println("\nTask 2: All authors in the dataset:");
        BookAnalyzer.printAllAuthors(books);

        String author2 = "George Orwell";
        System.out.println("\nTask 3: Books by " + author2 + ":");
        BookAnalyzer.printBooksByAuthor(books, author2);

        double rating = 4.8;
        System.out.println("\nTask 4: Books with user rating " + rating + ":");
        BookAnalyzer.printBooksByRating(books, rating);

        String author3 = "Jeff Kinney";
        System.out.println("\nTask 5: Prices of books by " + author3 + ":");
        BookAnalyzer.printBookPricesByAuthor(books, author3);
    }
}
