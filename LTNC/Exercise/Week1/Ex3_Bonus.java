class Book{
    private
        String title;
        String author;
        String ISBN;
        double price;
        int stock;
    public
        Book(){ // Default constructor
            this.title = "DefaultTitle";
            this.author = "DefaultAuthor";
            this.ISBN = "0000000000000";
            this.price = 20.0;
            this.stock = 10;
        }
        Book(String ttl, String auth, String isbn, double prc, int stk){ // Parameter constructor
            this.title = ttl;
            this.author = auth;
            this.ISBN = isbn;
            this.price = prc;
            this.stock = stk;
        }
        Book(Book bkl){ // Copy
            this.title = bkl.title;
            this.author = bkl.author;
            this.ISBN = bkl.ISBN;
            this.price = bkl.price;
            this.stock = bkl.stock;
        }
        String Get_Author(){
            return this.author;
        }
        String Get_Title(){
            return this.title;
        }
        int Get_stock(){
            return this.stock;
        }
        void Set_stock(int stk){
            this.stock = stk;
        }
        void display(){
            System.out.println("- Title: " + this.title + "; Author: " + this.author + "; ISBN: " + this.ISBN + "; Price: " + this.price + "; Stock: " + this.stock);
        }

}

class Library{
    private Book[] booklist;

    public
        Library(Book[] bklst){
            this.booklist = bklst;
        }
        // i. add new book
        void addNewBook(Book newbook){
           Book book2add = new Book(newbook);
            for(int i = 0; i < this.booklist.length; i++)
                {
                if(this.booklist[i] == null){
                    booklist[i] = book2add;
                    return;
                }
            }
        }

        // ii. search book by title or author
        // search by title
        Book searchByTitle(String titleSearch){
            for (Book bk:this.booklist){
                if(bk != null && bk.Get_Title().equals(titleSearch)) return bk;
            }
            return null;
        }

        // search by author
        Book searchByAuthor(String authorSearch){
            for (Book bk : this.booklist){
                if (bk != null && bk.Get_Author().equals(authorSearch)) return bk;
            }
            return null;
        }
        // search by title or author
        Book searchBook(String Inform){
            Book bk = searchByAuthor(Inform);
            if(bk != null) return bk;
            bk = searchByTitle(Inform);
            if (bk != null) return bk;
            System.out.println("Book not found!");
            return null;
        }

        //iii. borrow book
        Book borrowBook(String Inform){
            
            // search book
            Book bk = searchBook(Inform);
            if(bk == null) return null;
            int current_stock = bk.Get_stock();
            
            // check stock
            if(current_stock <= 0){
                System.out.println("Book out of stock!");
                return null;
            }

            // borrow book
            bk.Set_stock(current_stock - 1);
            return bk;
        }
        void displayBooks(){
            for (Book bk: this.booklist){
                if (bk != null)
                    bk.display();
                else break;
            }
        }
}

public class Ex3_Bonus {
    public static void main(String[] args) {
        // Create book objects
        Book book1 = new Book("How to Program (9th edition)", "Paul Deitel", "9780132990448", 50.0, 23);
        Book book2 = new Book("Java: How to Program (10th edition)", "Paul Deitel", "9780133761312", 50.0, 8);
        Book book3 = new Book("Introduction to Java Programming and Data Structures (Comprehensive Version)", "Y. Daniel Liang", "9780134670942", 45.0, 20);
        Book book4 = new Book("Operating System Concepts","John Wiley & Sons", "9781119439257", 60.0, 3 );
        Book book5 = new Book( "Computer Networking: A Top-Down Approach", "James F. Kurose", "9780133594140", 70.0, 2);
        // create library
        Book[] booklist = new Book[10];
        booklist[0] = book1;
        booklist[1] = book2;
        booklist[2] = book3;
        booklist[3] = book4;
        booklist[4] = book5;
        Library library = new Library(booklist);

        // ========= simulate library operations ==================
        System.out.println("============= Initial Book List ==================");
        library.displayBooks();
        
        // ========= add new book ==================
        System.out.println("\n================= Add New Book =================");
        System.out.println("Inform before adding:");
        library.displayBooks();

        Book newBook = new Book("Software Engineering (10th ed.)", "Ian Sommerville", " 9780133943030", 55.0, 25);
        System.out.println("\nbook's info to add:");
        newBook.display();
        library.addNewBook(newBook);
        System.out.println("\nInform after adding:");
        library.displayBooks();

        // ========= search operations ==================
        // search book by tiltle 
        System.out.println("\n==================== Search Book by Title ======================");
        String searchTitle = "Operating System Concepts";
        System.out.println("Title book for search: " + searchTitle);
        Book searchResult = library.searchBook(searchTitle);
        System.out.println("Search Result:");
        if (searchResult != null) {
            searchResult.display();
        }

        // search book by author
        System.out.println("\n================== Search Book by Author =======================");
        String searchAuthor = "James F. Kurose";
        System.out.println("Author book for search: " + searchAuthor);
        searchResult = library.searchBook(searchAuthor);
        System.out.println("Search Result:");
        if (searchResult != null) {
            searchResult.display();
        } 

        // ========= borrow operations ==================
        // borrow book simulation
        System.out.println("\n================== Borrow Book Simulation =========================");
        Book borrowResult = library.searchBook("How to Program (9th edition)");
        if (borrowResult != null) {
            System.out.println("Inform Before borrowing:");
            borrowResult.display();
            library.borrowBook("How to Program (9th edition)");
            System.out.println("Inform After borrowing:");
            borrowResult.display();
        }
    }
}