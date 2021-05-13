package gr.athtech.athtech.course.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.athtech.course.R;
import gr.athtech.athtech.course.storage.database.Movies;

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

//                SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreference.edit();
//                editor.putString("name", "Vassilis");
//                editor.putString("name", "Orfeas");
//                editor.putInt("age", 100);
//                editor.putBoolean("gender", true);
//                editor.apply();

                saveDataToDatabase();
            }
        });

        showSavedData();
        retrieveDataFromDatabase();
    }

    private void saveDataToDatabase() {
        InsertDataToDatabaseAsync task = new InsertDataToDatabaseAsync(this, new InsertDataCallback() {
            @Override
            public void onResult(Boolean result) {
                if (result) {
                    Toast.makeText(StorageActivity.this, "Everything are ok", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StorageActivity.this, "We have a problem", Toast.LENGTH_SHORT).show();

                }
            }
        });
        task.execute("A", "B", "C", "D", "E", "F");
    }

    private void retrieveDataFromDatabase() {
        DatabaseTaskAsync task = new DatabaseTaskAsync(this, new DatabaseTaskCallback() {
            @Override
            public void retrieveDatabaseMovies(List<Movies> array) {
                presentThemToUi(array);
            }

            @Override
            public void retrieveOnlyOneItem(Movies item) {
                List array = new ArrayList();
                array.add(item);
                presentThemToUi(array);
            }
        });
        task.execute("First");
    }

    private void presentThemToUi(List<Movies> array) {
        TextView textView = findViewById(R.id.storage_text);

        StringBuilder stringBuilder = new StringBuilder();
        for (Movies movies : array) {
            stringBuilder.append(movies.getName()).append(System.lineSeparator());
        }

        textView.setText(stringBuilder.toString());
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