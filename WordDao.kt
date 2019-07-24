@Dao
public interface WordDao {

   @Insert
   void insert(Word word);

   @Query("DELETE FROM word_table")
   void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
   LiveData<List<Word>> getAllWords();
}

