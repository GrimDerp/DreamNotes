



// put this into the android manifest:
<activity android:name=".NewWordActivity"></activity>
  
  
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   android:background="@color/colorScreenBackground"
   android:orientation="vertical"
   android:padding="24dp">

   <EditText
       android:id="@+id/edit_word"
       style="@style/text_view_style"
       android:hint="@string/hint_word"
       android:inputType="textAutoComplete" />

   <Button
       android:id="@+id/button_save"
       style="@style/button_style"
       android:text="@string/button_save" />
</LinearLayout>