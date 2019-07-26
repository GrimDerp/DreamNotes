RecyclerView recyclerView = findViewById(R.id.recyclerview);
final WordListAdapter adapter = new WordListAdapter(this);
recyclerView.setAdapter(adapter);
recyclerView.setLayoutManager(new LinearLayoutManager(this));

private WordViewModel mWordViewModel;

