package gr.athtech.athtech.course.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import gr.athtech.athtech.course.R;
import gr.athtech.athtech.course.storage.database.ApplicationDatabase;

public class StorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        findViewById(R.id.storage_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("name", "Vassilis");
                editor.putString("name", "Orfeas");
                editor.putInt("age", 100);
                editor.putBoolean("gender", true);
                editor.apply();
            }
        });

        showSavedData();
        retrieveDataFromDatabase();
    }

    private void retrieveDataFromDatabase() {
        ApplicationDatabase applicationDatabase = Room.databaseBuilder(this, ApplicationDatabase.class, "storage").build();


    }

    private void showSavedData() {
        SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(sharedPreference.getBoolean("gender", false));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(sharedPreference.getInt("age", 0));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(sharedPreference.getString("name", ""));

        TextView textView = findViewById(R.id.storage_text);
        textView.setText(stringBuilder.toString());

    }
}