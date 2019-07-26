Now that you have a working app, let's recap what you've built. Here is the app structure again, from the beginning:

You have an app that displays words in a list (MainActivity, RecyclerView, WordListAdapter).
You can add words to the list (NewWordActivity).
A word is an instance of the Word entity class.
The words are cached in the RecyclerViewAdapter as a List of words (mWords). The list is automatically updated and redisplayed when the data changes.
The automatic update happens because in the MainActivity, there is an Observer that observes the words and is notified when the words change. When there is a change, the observer's onChange() method is executed and updates mWords in the WordListAdapter.
The data can be observed because it is LiveData. And what is observed is the LiveData<List<Word>> that is returned by the WordViewModel object.
The WordViewModel hides everything about the backend from the user interface. It provides methods for accessing the UI data, and it returns LiveData so that MainActivity can set up the observer relationship. Views, activities, and fragments only interact with the data through the ViewModel. As such, it doesn't matter where the data comes from.
In this case, the data comes from a Repository. The ViewModel does not need to know what that Repository interacts with. It just needs to know how to interact with the Repository, which is through the methods exposed by the Repository.
The Repository manages one or more data sources. In the RoomWordsSample app, that backend is a Room database. Room is a wrapper around and implements an SQLite database. Room does a lot of work for you that you used to have to do yourself. For example, Room does everything that you used to use an SQLiteOpenHelper class to do.
The DAO maps method calls to database queries, so that when the Repository calls a method such as getAllWords(), Room can execute SELECT * from word_table ORDER BY word ASC.
The result returned from the query is observed LiveData. Therefore, every time the data in Room changes, the Observer interface's onChanged() method is executed and the UI is updated.