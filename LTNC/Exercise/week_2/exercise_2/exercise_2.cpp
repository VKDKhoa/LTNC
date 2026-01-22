#include <iostream>
#include <string>

class Book {
    private:
        std::string title;
        std::string author;
        std::string isbn;
        float price;
        int stock;
    public:
        Book(std::string t = "Unknown Title", std::string a = "Unknown Author", std::string i = "0000000000", float p = 0.0f, int s = 0) :
        title(t), author(a), isbn(i), price(p), stock(s) {}

        // Getter methods
        std::string get_title() const { return title; }
        std::string get_author() const { return author; }
        std::string get_isbn() const { return isbn; }
        float get_price() const { return price; }
        int get_stock() const { return stock; }

        // Setter methods
        void set_title(const std::string& t) { title = t; }
        void set_author(const std::string& a) { author = a; }
        void set_isbn(const std::string& i) { isbn = i; }
        void set_price(float p) { price = p; }
        void set_stock(int s) { stock = s; }
        virtual void displayDetails() const{
            std::cout << "- Title: " << title 
            << "; Author: "  << author 
            << "; ISBN: " << isbn
            << "; Price: " << price 
            << "; Stock: " << stock << std::endl;
        }
};

class EBook : public Book {
    private:
        float fileSize;
    public:
        EBook(std::string t = "Unknown Title", std::string a = "Unknown Author", std::string i = "0000000000", float p = 0.0f, int s = 0, float fs = 0.0f) :
        Book(t, a, i, p, s), fileSize(fs) {}

        // Getter methods
        float get_fileSize() const { return fileSize; }

        // Setter methods
        void set_fileSize(float fs) { fileSize = fs; }

        void displayDetails() const override {
            Book::displayDetails();
            std::cout << "- File Size: " << fileSize << std::endl;
        }
};

class printedBook : public Book {
    private:
        int pageCount;
    public:
        printedBook(std::string t = "Unknown Title", std::string a = "Unknown Author", std::string i = "0000000000", float p = 0.0f, int s = 0, int pg = 0) :
        Book(t, a, i, p, s), pageCount(pg) {}

        // Getter methods
        int get_numberOfPages() const { return pageCount; }

        // Setter methods
        void set_numberOfPages(int pg) { pageCount = pg; }

        void displayDetails() const override {
            Book::displayDetails();
            std::cout << "- Pages: " << pageCount << std::endl;
        }
};

class Library{
    private:
        Book **books_list = nullptr;
        int size = 0;
        public:
        void addBook(Book *book)
        {
            if(books_list == nullptr){
                books_list = new Book*[1];
                books_list[0] = book;
                size++;
                return;
            };
            Book** new_books_list = new Book*[size + 1]; // Create a new array with increased size
            for(int i = 0; i < size; i++){
                new_books_list[i] = books_list[i]; // Copy existing books to the new array
            }
            delete[] books_list; // Free the old array memory
            new_books_list[size] = book; // Add the new book
            books_list = new_books_list; // Update the pointer to the new array
            size++;
        }
        Book *searchByTitle(std::string title)
        {
            for(int i = 0; i < size; i++){
                if(books_list[i]->get_title() == title){
                    return books_list[i];
                }
            }
            return nullptr;
        }
        Book *searchByAuthor(std::string author)
        {
            for(int i = 0; i < size; i++){
                if(books_list[i]->get_author() == author){
                    return books_list[i];
                }
            }
            return nullptr;
        }
        
        Book borrowBook(std::string isbn)
        {
            for(int i = 0; i < size; i++){
                if(books_list[i]->get_isbn() == isbn && books_list[i]->get_stock() > 0){
                    std::cout << "Book's previous details:" << std::endl;
                    books_list[i]->displayDetails();
                    books_list[i]->set_stock(books_list[i]->get_stock() - 1);
                    return *books_list[i];
                }
            }
            return Book(); // return default Book if not found or out of stock
        }
        void displayAllBooks() const
        {
            for(int i = 0; i < size; i++){
                books_list[i]->displayDetails();
                std::cout << "------------------------" << std::endl;
            }
        }
        void delLibrary()
        {
            for(int i = 0; i < size; i++){
                delete books_list[i];
            }
            delete[] books_list;
            books_list = nullptr;
        }
};
int main(){
    Library library;

    EBook *ebook1 = new EBook("Java Programming", "John Doe", "1234567890123", 25.0f, 5, 10.0f);
    EBook *ebook2 = new EBook();
    EBook *ebook3 = new EBook("Python Programming", "Alice Johnson", "1122334455667", 30.0f, 2, 15.0f);
    EBook *ebook4 = new EBook("C++ Programming", "Bob Brown", "2233445566778", 28.0f, 4, 12.0f);
    EBook *ebook5 = new EBook("JavaScript Programming", "Charlie Davis", "3344556677889", 22.0f, 6, 8.0f);
    printedBook *printedbook1 = new printedBook("Data Structures", "Jane Smith", "0987654321098", 30.0f, 3, 200);
    printedBook *printedbook2 = new printedBook();
    printedBook *printedbook3 = new printedBook("Algorithms", "Emily White", "5566778899001", 35.0f, 2, 250);
    printedBook *printedbook4 = new printedBook("Operating Systems", "Michael Green", "6677889900112", 40.0f, 5, 300);
    printedBook *printedbook5 = new printedBook("Database Systems", "Sarah Black", "7788990011223", 32.0f, 4, 220);

    // Add books to the library
    library.addBook(ebook1);
    library.addBook(printedbook4);
    library.addBook(printedbook5);
    library.addBook(ebook3);
    library.addBook(printedbook1);
    library.addBook(ebook4);
    library.addBook(printedbook3);
    library.addBook(ebook5);
    library.addBook(ebook2);
    library.addBook(printedbook2);
    
    // Display all books
    std::cout << "All books in the library:" << std::endl;
    library.displayAllBooks();

    // Search by title
    std::string search_title = "Data Structures";
    std::cout << std::endl << "Searching for book with title '" << search_title << "':" << std::endl;
    Book *found_book = library.searchByTitle(search_title);
    if (found_book) {
        std::cout << "Book found  :" << std::endl;
        found_book->displayDetails();
    } else {
        std::cout << "No book found '" << std::endl;
    }

    // Search by author
    std::string search_author = "Alice Johnson";
    std::cout << std::endl << "Searching for book by author '" << search_author << "':" << std::endl;
    found_book = library.searchByAuthor(search_author);
    if (found_book) {
        std::cout << "Book found :" << std::endl;
        found_book->displayDetails();
    } else {
        std::cout << "No book found '" << std::endl;
    }

    // Borrow a book by ISBN
    std::string borrow_isbn = "1234567890123";
    std::cout << std::endl << "Borrowing book with ISBN '" << borrow_isbn << "':" << std::endl;
    Book borrowed_book = library.borrowBook(borrow_isbn);
    if (borrowed_book.get_isbn() != "0000000000") {
        std::cout << "Book borrowed successfully. Updated details:" << std::endl;
        borrowed_book.displayDetails();
    } else {
        std::cout << "Book not available for borrowing." << std::endl;
    }

    // delete library
    library.delLibrary();
    return 0;
}