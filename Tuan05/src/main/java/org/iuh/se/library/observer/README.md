┌─────────────────────┐       ┌─────────────────────┐
│     <<interface>>   │       │    <<interface>>    │
│       Observer      │       │       Subject       │
├─────────────────────┤       ├─────────────────────┤
│                     │       │                     │
├─────────────────────┤       ├─────────────────────┤
│ + update(event,     │       │ + addObserver()     │
│   data): void       │       │ + removeObserver()  │
└────────┬────────────┘       │ + notifyObservers() │
│                    └─────────┬───────────┘
│                              │
│                              │
┌────────┴────────────┐                 │
│                     │                 │
│    LibraryStaff     │                 │
├─────────────────────┤                 │
│ - name: String      │                 │
│ - position: String  │                 │
├─────────────────────┤                 │
│ + update()          │                 │
└─────────────────────┘                 │
│
┌─────────────────────┐                 │
│                     │                 │
│    LibraryUser      │                 │
├─────────────────────┤                 │
│ - id: String        │                 │
│ - name: String      │                 │
│ - email: String     │                 │
├─────────────────────┤                 │
│ + update()          │                 │
└─────────────────────┘                 │
│
┌───────────┴───────────┐
│                       │
│       Library         │
├───────────────────────┤
│ - books: List<Book>   │
│ - observers: List<Obs>│
│ - topicObservers: Map │
├───────────────────────┤
│ + addObserver()       │
│ + removeObserver()    │
│ + notifyObservers()   │
│ + subscribeToTopic()  │
│ + unsubscribeFromTopic│
│ + addBook()           │
│ + checkForOverdueBooks│
│ + getBooks()          │
│ + findBookById()      │
└───────────┬───────────┘
│
│ uses
▼
┌───────────────────────┐
│                       │
│         Book          │
├───────────────────────┤
│ - id: String          │
│ - title: String       │
│ - author: String      │
│ - genre: String       │
│ - available: boolean  │
│ - dueDate: Date       │
├───────────────────────┤
│ + getId()             │
│ + getTitle()          │
│ + getAuthor()         │
│ + getGenre()          │
│ + isAvailable()       │
│ + setAvailable()      │
│ + getDueDate()        │
│ + setDueDate()        │
│ + toString()          │
└───────────────────────┘