+-------------------+
|     Library       |
+-------------------+
| - instance: Library (static)  |
| - books: List<Book>           |
| - borrowers: Map<Book, User>  |
+-------------------+
| - Library()       |
| + getInstance(): Library (static) |
| + addBook(Book): void           |
| + removeBook(Book): void        |
| + borrowBook(Book, User): boolean |
| + returnBook(Book): boolean     |
| + searchByTitle(String): List<Book> |
| + searchByAuthor(String): List<Book> |
| + searchByGenre(String): List<Book> |
| + getAvailableBooks(): List<Book> |
+-------------------+
           |
           |
           v
+-------------------+
|       Book        |
+-------------------+
| - id: String      |
| - title: String   |
| - author: String  |
| - genre: String   |
| - isAvailable: boolean |
+-------------------+
| + Book(String, String, String, String) |
| + getId(): String |
| + getTitle(): String |
| + getAuthor(): String |
| + getGenre(): String |
| + isAvailable(): boolean |
| + setAvailable(boolean): void |
+-------------------+
           ^
           |
+-------------------+
|       User        |
+-------------------+
| - id: String      |
| - name: String    |
| - borrowedBooks: List<Book> |
+-------------------+
| + User(String, String) |
| + getId(): String |
| + getName(): String |
| + getBorrowedBooks(): List<Book> |
| + borrowBook(Book): void |
| + returnBook(Book): void |
+-------------------+