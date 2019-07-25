public class WordViewModel extends AndroidViewModel {
  
  private WordRepository mRepository;
  
   private LiveData<List<Word>> mAllWords;
  
   public WordViewModel (Application application) {
       super(application);
       mRepository = new WordRepository(application);
       mAllWords = mRepository.getAllWords();
   }
   
   LiveData<List<Word>> getAllWords() { return mAllWords; }
   
   public void insert(Word word) { mRepository.insert(word); }
  
}


