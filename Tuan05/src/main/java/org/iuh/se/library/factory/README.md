+---------------------+
|     <<abstract>>    |
|        Book         |
+---------------------+
| - id: String        |
| - title: String     |
| - author: String    |
| - genre: String     |
| - available: boolean|
+---------------------+
| + Book(String, String, String, String) |
| + getId(): String   |
| + getTitle(): String|
| + getAuthor(): String |
| + getGenre(): String |
| + isAvailable(): boolean |
| + setAvailable(boolean) |
| + display(): void |
+---------------------+
^
|
|
+--------+---------+-------------+---------+
|                  |             |         |
+---------------------+ +--------------------+ +--------------------+
|     PhysicalBook    | |    ElectronicBook  | |    AudioBook       |
+---------------------+ +--------------------+ +--------------------+
| - pages: int        | | - format: String   | | - duration: int    |
| - publisher: String | | - fileSizeMB: int  | | - narrator: String |
+---------------------+ +--------------------+ +--------------------+
| + getPages(): int   | | + getFormat()      | | + getDuration()    |
| + getPublisher()    | | + getFileSize()    | | + getNarrator()    |
| + display(): void   | | + display(): void  | | + display(): void  |
+---------------------+ +--------------------+ +--------------------+

+------------------------+
|   BookFactory          |
+------------------------+
| + createBook(String type, |
|   String id,           |
|   String title,        |
|   String author,       |
|   String genre,        |
|   Map<String,Object> attributes): Book |
+------------------------+
^
|
+--------+--------+-------------+--------+
|                 |             |        |
+------------------------+ +------------------------+ +------------------------+
| PhysicalBookFactory    | | ElectronicBookFactory  | | AudioBookFactory       |
+------------------------+ +------------------------+ +------------------------+
| + createBook(String id,| | + createBook(String id,| | + createBook(String id,|
|   String title,        | |   String title,        | |   String title,        |
|   String author,       | |   String author,       | |   String author,       |
|   String genre,        | |   String genre,        | |   String genre,        |
|   Map<String,Object>   | |   Map<String,Object>   | |   Map<String,Object>   |
|   attributes): Book    | |   attributes): Book    | |   attributes): Book    |
+------------------------+ +------------------------+ +------------------------+