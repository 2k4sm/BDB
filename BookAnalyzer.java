import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookAnalyzer {

    public static int countBooksByAuthor(List<Book> books, String author) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    public static Set<String> getAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    public static void printAllAuthors(List<Book> books) {
        Set<String> authors = getAllAuthors(books);
        System.out.println("All Authors in the Dataset:");
        System.out.println("---------------------------");
        int counter = 1;
        for (String author : authors) {
            System.out.println(counter + ". " + author);
            counter++;
        }
        System.out.println("Total number of authors: " + authors.size());
    }

    public static void printBooksByAuthor(List<Book> books, String author) {
        System.out.println("Books by " + author + ":");
        System.out.println("---------------------------");

        boolean found = false;
        int counter = 1;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(counter + ". " + book.getTitle());
                counter++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for author: " + author);
        } else {
            System.out.println("Total books by " + author + ": " + (counter - 1));
        }
    }

    public static void printBooksByRating(List<Book> books, double rating) {
        System.out.println("Books with rating " + rating + ":");
        System.out.println("---------------------------");

        boolean found = false;
        int counter = 1;

        for (Book book : books) {
            if (book.getUserRating() == rating) {
                System.out.println(counter + ". " + book.getTitle() + " by " + book.getAuthor());
                counter++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with rating: " + rating);
        } else {
            System.out.println("Total books with rating " + rating + ": " + (counter - 1));
        }
    }

    public static void printBookPricesByAuthor(List<Book> books, String author) {
        System.out.println("Books and prices by " + author + ":");
        System.out.println("---------------------------");

        boolean found = false;
        int counter = 1;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.printf("%d. %s - $%.2f%n", counter, book.getTitle(), book.getPrice());
                counter++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for author: " + author);
        }
    }
}
