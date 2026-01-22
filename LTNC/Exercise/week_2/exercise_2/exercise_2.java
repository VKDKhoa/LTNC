import java.util.ArrayList; // for using dynamic arrays
class Book{
        private String title;
        private String author;
        private String ISBN;
        private double price;
        private int stock;
        public Book(){ // Default constructor
            this.title = "DefaultTitle";
            this.author = "DefaultAuthor";
            this.ISBN = "0000000000000";
            this.price = 20.0;
            this.stock = 10;
        }
        public Book(String ttl, String auth, String isbn, double prc, int stk){ // Parameter constructor
            this.title = ttl;
            this.author = auth;
            this.ISBN = isbn;
            this.price = prc;
            this.stock = stk;
        }
        
        // getter methods
        public String Get_Author(){
            return this.author;
        }
        public String Get_Title(){
            return this.title;
        }
        public String Get_ISBN(){
            return this.ISBN;
        }
        public double Get_Price(){
            return this.price;
        }

        public int Get_stock(){
            return this.stock;
        }

        // setter methods
        public void Set_Title(String ttl){
            this.title = ttl;
        }
        public void Set_Author(String auth){
            this.author = auth;
        }
        public void Set_ISBN(String isbn){
            this.ISBN = isbn;
        }
        public void Set_Price(double prc){
            this.price = prc;
        }
        public void Set_stock(int stk){
            this.stock = stk;
        }

        void displayDetails(){
            System.out.println("- Title: " + this.title + "; Author: " + this.author + "; ISBN: " + this.ISBN + "; Price: " + this.price + "; Stock: " + this.stock);
        }

}

class EBook extends Book{
    private double fileSize; //MB
    public EBook(){ // Default constructor
        super();
        this.fileSize = 5.0;
    }
    public EBook(String ttl, String auth, String isbn, double prc, int stk, double fSize){ // Parameter constructor
        super(ttl, auth, isbn, prc, stk);
        this.fileSize = fSize;
    }
    @Override
    void displayDetails(){
        System.out.println("E-Book Details:");
        super.displayDetails();
        System.out.println("- File Size: " + this.fileSize + " MB");
    }
}

class PrintedBook extends Book{
    private int pageCount;
    public PrintedBook(){ // Default constructor
        super();
        this.pageCount = 100;
    }
    public PrintedBook(String ttl, String auth, String isbn, double prc, int stk, int fSize){ // Parameter constructor
        super(ttl, auth, isbn, prc, stk);
        this.pageCount = fSize;
    }
    @Override
    void displayDetails(){
        System.out.println("Printed Book Details:");
        super.displayDetails();
        System.out.println("- Page Count: " + this.pageCount);
    }
}

class Library{
    private ArrayList<Book> books_List;
    
    public Library()
    {
        books_List = new ArrayList<Book>();
    }

    public void addBook(Book book){
        this.books_List.add(book);
    }
    
    public Book searchByTitle(String title){
        for(Book book : books_List){
            if(book.Get_Title().equals(title)) return book;
        }
        return null;
    }

    public Book searchByAuthor(String author){
        for (Book book : books_List){
            if(book.Get_Author().equals(author)) return book;
        }
        return null;
    }

    public Book borrowBook(String ISBN){
        for(Book book : books_List)
        {
            if(book.Get_ISBN().equals(ISBN)){
                if(book.Get_stock() < 0) return null; 
                System.out.println("Book details before borrowing: ");
                book.displayDetails();
                book.Set_stock(book.Get_stock() - 1);
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks(){
        for(Book book : books_List){
            book.displayDetails();
        }
    }
}

public class exercise_2 {
    public static void main(String[] args) {
        Library library = new Library();
        Book ebook1 = new EBook("Java Programming", "John Doe", "1234567890123", 25.0, 5, 10.0);
        Book ebook2 = new EBook(); // Default EBook
        Book ebook3 = new EBook("Python Programming", "Alice Johnson", "1122334455667", 30.0, 2, 15.0);
        Book ebook4 = new EBook("C++ Programming", "Bob Brown", "2233445566778", 28.0, 4, 12.0);
        Book ebook5 = new EBook("JavaScript Programming", "Charlie Davis", "3344556677889", 22.0, 6, 8.0);
        
        Book printedbook1 = new PrintedBook("Data Structures", "Jane Smith", "0987654321098", 30.0, 3, 200);
        Book printedbook2 = new PrintedBook(); // Default PrintedBook
        Book printedbook3 = new PrintedBook("Algorithms", "Emily White", "5566778899001", 35.0, 2, 250);
        Book printedbook4 = new PrintedBook("Operating Systems", "Michael Green", "6677889900112", 40.0, 5, 300);
        Book printedbook5 = new PrintedBook("Database Systems", "Sarah Black", "7788990011223", 32.0, 4, 220);
        
        // Adding books to the library
        library.addBook(ebook1);
        library.addBook(printedbook1);
        library.addBook(ebook2);
        library.addBook(printedbook3);
        library.addBook(ebook3);
        library.addBook(ebook4);
        library.addBook(printedbook4);
        library.addBook(printedbook5);
        library.addBook(ebook5);
        library.addBook(printedbook2);
        
        // Display all books in the library
        System.out.println("All books in the library:");
        library.displayAllBooks();

        System.out.println();
        // Searching for a book by title
        System.out.println("Searching for a book by title:");
        Book foundBook = library.searchByTitle("Python Programming");
        if (foundBook != null) foundBook.displayDetails();
        else System.out.println("Book not found.");

         // Searching for a book by author
        System.out.println();
        System.out.println("Searching for a book by author:");
        foundBook = library.searchByAuthor("Jane Smith");
        if (foundBook != null) foundBook.displayDetails();
        else System.out.println("Book not found.");

        // Borrowing a book by ISBN
        System.out.println();
        System.out.println("Borrowing a book by ISBN:");
        Book borrowedBook;
        borrowedBook = library.borrowBook("1234567890123");
        if(borrowedBook != null) borrowedBook.displayDetails();
        else System.out.println("Book is out of stock or not found.");
    }
}