public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

   private final LayoutInflater mInflater;
   private List<Word> mWords; // Cached copy of words

   WordListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

   @Override
   public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
       return new WordViewHolder(itemView);
     
     mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
     
     mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
   @Override
   public void onChanged(@Nullable final List<Word> words) {
       // Update the cached copy of the words in the adapter.
       adapter.setWords(words);
   }
});
     
   }

   @Override
   public void onBindViewHolder(WordViewHolder holder, int position) {
       if (mWords != null) {
           Word current = mWords.get(position);
           holder.wordItemView.setText(current.getWord());
       } else {
           // Covers the case of data not being ready yet.
           holder.wordItemView.setText("No Word");
       }
   }

   void setWords(List<Word> words){
       mWords = words;
       notifyDataSetChanged();
   }

   // getItemCount() is called many times, and when it is first called,
   // mWords has not been updated (means initially, it's null, and we can't return null).
   @Override
   public int getItemCount() {
       if (mWords != null)
           return mWords.size();
       else return 0;
   }

   class WordViewHolder extends RecyclerView.ViewHolder {
       private final TextView wordItemView;

       private WordViewHolder(View itemView) {
           super(itemView);
           wordItemView = itemView.findViewById(R.id.textView);
       }
   }
}