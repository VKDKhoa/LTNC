from typing import override # for override methods
class Book:
    def __init__(self, title: str="Unknown Title", author: str ="Unknown Author", 
                 isbn: str="0000000000", price: float=0.0, stock: int=0):
        self.__title = title
        self.__author = author
        self.__isbn = isbn
        self.__price = price
        self.__stock = stock
    
    # Getter methods
    def get_title(self) -> str:
        return self.__title
    def get_author(self) -> str:
        return self.__author
    def get_isbn(self) -> str:
        return self.__isbn
    def get_price(self) -> float:
        return self.__price
    def get_stock(self) -> int:
        return self.__stock

    # Setter methods
    def set_title(self, title: str) -> None:
        self.__title = title
    def set_author(self, author: str) -> None:
        self.__author = author
    def set_isbn(self, isbn: str) -> None:
        self.__isbn = isbn
    def set_price(self, price: float) -> None:
        self.__price = price
    def set_stock(self, stock: int) -> None:
        self.__stock = stock
    
    def displayDetails(self) -> None:
        print(f"- Title: {self.__title}; Author: {self.__author}; ISBN: {self.__isbn}; Price: ${self.__price}; Stock: {self.__stock}")
    
class EBook(Book):
    def __init__(self, title: str="Unknown Title", author: str ="Unknown Author", 
                 isbn: str="0000000000", price: float=0.0, stock: int=0,
                 fileSize: float=0.0):
        super().__init__(title, author, isbn, price, stock)
        self.__fileSize = fileSize
    
    # Getter methods
    def get_fileSize(self) -> float:
        return self.__fileSize
    # Setter methods
    def set_fileSize(self, fileSize: float) -> None:
        self.__fileSize = fileSize
    
    @override
    def displayDetails(self) -> None:
        super().displayDetails()
        print(f"- File Size: {self.__fileSize}")

class PrintedBook(Book):
    def __init__(self, title: str="Unknown Title", author: str ="Unknown Author", 
                 isbn: str="0000000000", price: float=0.0, stock: int=0,
                 pageCount: int=0):
        super().__init__(title, author, isbn, price, stock)
        self.__pageCount = pageCount
    
    # Getter methods
    def get_pageCount(self) -> int:
        return self.__pageCount

    # Setter methods
    def set_pageCount(self, pageCount: int) -> None:
        self.__pageCount = pageCount
    
    @override
    def displayDetails(self) -> None:
        super().displayDetails()
        print(f"- Page Count: {self.__pageCount}")

class Library:
    def __init__(self):
        self.__books: list[Book] = []
    
    def addBook(self, book: Book) -> None:
        self.__books.append(book)
    
    def searchByTitle(self, title: str) -> Book:
        for book in self.__books:
            if book.get_title() == title:
                return book
        return None
    
    def searchByAuthor(self, author: str) -> Book:
        for book in self.__books:
            if book.get_author() == author:
                return book
        return None

    def borrowBook(self, isbn: str) -> Book | None:
        for book in self.__books:
            if book.get_isbn() == isbn and book.get_stock() > 0:
                print("Book's previous details:")
                book.displayDetails()
                book.set_stock(book.get_stock() - 1)
                return book
        
        return None

    def displayAllBooks(self) -> None:
        for book in self.__books:
            book.displayDetails()
            print() 
def main():
    library: Library = Library()
    library = Library()

    ebook1: Book = EBook("Java Programming", "John Doe", "1234567890123", 25.0, 5, 10.0)
    ebook2: Book = EBook()  # Default EBook
    ebook3: Book = EBook("Python Programming", "Alice Johnson", "1122334455667", 30.0, 2, 15.0)
    ebook4: Book = EBook("C++ Programming", "Bob Brown", "2233445566778", 28.0, 4, 12.0)
    ebook5: Book = EBook("JavaScript Programming", "Charlie Davis", "3344556677889", 22.0, 6, 8.0)
    printedbook1: Book = PrintedBook("Data Structures", "Jane Smith", "0987654321098", 30.0, 3, 200)
    printedbook2: Book = PrintedBook()  # Default PrintedBook
    printedbook3: Book = PrintedBook("Algorithms", "Emily White", "5566778899001", 35.0, 2, 250)
    printedbook4: Book = PrintedBook("Operating Systems", "Michael Green", "6677889900112", 40.0, 5, 300)
    printedbook5: Book = PrintedBook("Database Systems", "Sarah Black", "7788990011223", 32.0, 4, 220)
    
    # Add books to the library
    library.addBook(ebook1)
    library.addBook(printedbook4)
    library.addBook(printedbook5)
    library.addBook(ebook2)
    library.addBook(printedbook1)
    library.addBook(ebook3)
    library.addBook(ebook4)
    library.addBook(printedbook2)
    library.addBook(ebook5)
    library.addBook(printedbook3)

    # Display all books in the library
    print("All books in the library:")
    library.displayAllBooks()

    # Search for a book by title
    search_title: str = "Python Programming"
    print(f"Searching for book with title '{search_title}':")
    found_book: Book = library.searchByTitle(search_title)
    found_book.displayDetails() if found_book else print("Book not found.")
    print()

    # Search for a book by author
    search_author: str = "Jane Smith"
    print(f"Searching for book by author '{search_author}':")
    found_book = library.searchByAuthor(search_author)
    found_book.displayDetails() if found_book else print("Book not found.")
    print()

    # Borrow a book by ISBN
    borrow_isbn: str = "1234567890123"
    print(f"Borrowing book with ISBN '{borrow_isbn}':")
    borrowed_book: Book = library.borrowBook(borrow_isbn)
    if borrowed_book:
        print("Book borrowed successfully. Updated details:")
        borrowed_book.displayDetails()
    else:
        print("Book not available for borrowing.")
if __name__ == "__main__":
    main()