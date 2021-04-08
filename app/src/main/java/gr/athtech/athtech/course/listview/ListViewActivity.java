package gr.athtech.athtech.course.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import gr.athtech.athtech.course.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(new ListViewAdapter(this, R.layout.row_user_info, new String[]{"", "", "", "", ""}));
    }
}