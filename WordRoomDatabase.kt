@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

   public abstract WordDao wordDao();
   private static WordRoomDatabase INSTANCE;

   static WordRoomDatabase getDatabase(final Context context) {
       if (INSTANCE == null) {
           synchronized (WordRoomDatabase.class) {
               if (INSTANCE == null) {
                   INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                           WordRoomDatabase.class, "word_database")
                             // Wipes and rebuilds instead of migrating 
                             // if no Migration object.
                            // Migration is not part of this practical.
                           .fallbackToDestructiveMigration()
                           .addCallback(sRoomDatabaseCallback)
                           .build();                
               }
               
/**
* Populate the database in the background.
*/
private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

   private final WordDao mDao;
   String[] words = {"dolphin", "crocodile", "cobra"};

   PopulateDbAsync(WordRoomDatabase db) {
       mDao = db.wordDao();
   }

   @Override
   protected Void doInBackground(final Void... params) {
       // Start the app with a clean database every time.
       // Not needed if you only populate the database
       // when it is first created
       mDao.deleteAll();

       for (int i = 0; i <= words.length - 1; i++) {
           Word word = new Word(words[i]);
           mDao.insert(word);
       }
       return null;
   }
}
 
           }
       }
       return INSTANCE;
   }
   
    private static RoomDatabase.Callback sRoomDatabaseCallback = 
    new RoomDatabase.Callback(){

    @Override
    public void onOpen (@NonNull SupportSQLiteDatabase db){
        super.onOpen(db);
       new PopulateDbAsync(INSTANCE).execute();
     }
  };
}



