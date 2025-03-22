+---------------------+
|   <<interface>>     |
|    IBorrowable      |
+---------------------+
| + borrow(): String  |
| + calculateBorrowingFee(): double |
| + getBorrowingDays(): int |
+---------------------+
^
|
|
+---------------------+     +---------------------+
|     BasicBook       |     |   BookDecorator     |
+---------------------+     +---------------------+
| - title: String     |     | # decoratedBook: IBorrowable |
| - author: String    |     +---------------------+
| - genre: String     |     | + BookDecorator(decoratedBook: IBorrowable) |
| - isbn: String      |     | + borrow(): String  |
+---------------------+     | + calculateBorrowingFee(): double |
| + getTitle(): String|     | + getBorrowingDays(): int |
| + getAuthor(): String|    +---------------------+
| + getGenre(): String|              ^
| + getIsbn(): String |              |
| + borrow(): String  |        +-----+------+------+------+
| + calculateBorrowingFee(): double |     |           |           |
| + getBorrowingDays(): int |        |           |           |
+---------------------+        |           |           |
+------+      +------+    +------+    +------+
|ExtendedBor..|  |BrailleVersion| |TranslatedVer.| |Insurance|
|Decorator    |  |Decorator     | |Decorator     | |Decorator|
+-------------+  +-------------+ +-------------+ +--------+
|- additionalDays:|                |- targetLanguage:| |- insurance|
|  int          |                |  String       | |  Amount: double|
+-------------+  +-------------+ +-------------+ +--------+
|+ ExtendedBor..|  |+ BrailleVersion| |+ TranslatedVer.| |+ Insurance|
|  Decorator(...)|  |  Decorator(...)|  |  Decorator(...)|  |  Decorator(...)|
|+ borrow()     |  |+ borrow()      | |+ borrow()      | |+ borrow() |
|+ calculateBor.|  |+ calculateBor. | |+ calculateBor. | |+ calculate|
|  rowingFee()  |  |  rowingFee()   | |  rowingFee()   | |  BorrowingFee()|
|+ getBorrowingD|  +-------------+ +-------------+ |+ getBorrow|
|  ays()        |                                  |  ingDays()|
+-------------+                                  +--------+

