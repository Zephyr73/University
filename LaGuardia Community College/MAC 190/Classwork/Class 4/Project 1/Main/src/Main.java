import java.util.Scanner;

class Book {
    private int book_no;
    private String book_title;
    private float book_price;
    private static Scanner input = new Scanner(System.in);

    private float total_cost(int n) {
        return book_price * n;
    }

    public Book() {
        this.book_no = 0;
        this.book_title = "";
        this.book_price = 0.0f;
    }

    public Book(int book_no, String book_title, float book_price) {
        this.book_no = book_no;
        this.book_title = book_title;
        this.book_price = book_price;
    }

    public void Input() {
        System.out.print("Enter Book number: ");
        book_no = input.nextInt();
        input.nextLine();
        System.out.print("Enter Book title: ");
        book_title = input.nextLine();
        if (book_title.length() > 20) {
            book_title = book_title.substring(0, 20);
        }
        System.out.print("Enter Book price: ");
        book_price = input.nextFloat();
    }

    public void Purchase() {
        System.out.print("How many books do you want to buy?: ");
        int n = input.nextInt();
        float cost = total_cost(n);

        System.out.println();
        Details();
        System.out.println("Number of copies: " +n);
        System.out.println("Total cost: $" +cost +"\n");
    }

    public void Details() {
        System.out.println("Book No: " +book_no);
        System.out.println("Book Title: " +book_title);
        System.out.println("Price per copy: $" +book_price );
    }
}

public class Main {
    public static void main(String[] args) {
        Book myBook = new Book(1, "Hello world", 79.99f);
        System.out.println("Created a new book");
        System.out.println("\nDetails of book: ");
        myBook.Details();
        myBook.Purchase();

        Book myBook2 = new Book();
        myBook2.Input();
        myBook2.Purchase();
    }
}