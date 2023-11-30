import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Library {
    private Map<Integer, Book> books;
    private Map<Integer, String> issuedBooks;

    public Library() {
        books = new HashMap<>();
        issuedBooks = new HashMap<>();
    }

    public void addBook(int bookId, String bookTitle) {
        books.put(bookId, new Book(bookId, bookTitle));
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void issueBook(int candidateId, int bookId, String issueDate) {
        if (books.containsKey(bookId) && !issuedBooks.containsKey(bookId)) {
            issuedBooks.put(bookId, issueDate);
            System.out.println("Book issued successfully to Candidate ID " + candidateId);
        } else {
            System.out.println("Book not available for issuance.");
        }
    }

    public void returnBook(int bookId, String returnDate) {
        if (issuedBooks.containsKey(bookId)) {
            issuedBooks.remove(bookId);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not issued yet or already returned.");
        }
    }
}

class Book {
    private int bookId;
    private String title;

    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title;
    }
}

public class LibraryM{
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(1, "The Java Programming Language");
        library.addBook(2, "Clean Code");
        library.addBook(3, "Design Patterns");

        library.displayBooks();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Candidate ID: ");
        int candidateId = scanner.nextInt();

        System.out.print("Enter Book ID to issue: ");
        int issueBookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Issue Date (YYYY-MM-DD): ");
        String issueDate = scanner.nextLine();

        library.issueBook(candidateId, issueBookId, issueDate);

        System.out.print("Enter Book ID to return: ");
        int returnBookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Return Date (YYYY-MM-DD): ");
        String returnDate = scanner.nextLine();

        library.returnBook(returnBookId, returnDate);

        scanner.close();
    }
}
