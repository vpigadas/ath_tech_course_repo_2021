package gr.athtech.athtech.course.recyclerView;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gr.athtech.athtech.course.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        random = new Random();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        findViewById(R.id.buttonDynamic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshList();
            }
        });
        findViewById(R.id.buttonDynamic).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                useDynamicAdapter();
                return true;
            }
        });

        findViewById(R.id.buttonManual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshManualList();
            }
        });

    }

    private String createRandomNumbers() {
        return String.valueOf(random.nextInt(10000));
    }

    private void refreshList() {
        List<String> array = new ArrayList<>();

        while (array.size() < 100) {
            String value = createRandomNumbers();
            if (!array.contains(value)) {
                array.add(value);
            }

        }

        adapter.submitList(array);
    }

    private void refreshManualList() {
        List<String> array = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            array.add(createRandomNumbers());
        }

        useDefaultAdapter(array);
    }

    private RecDynamicAdapterV2 adapter;

    private void useDynamicAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        adapter = new RecDynamicAdapterV2();
        recyclerView.setAdapter(adapter);

    }

    private void useDefaultAdapter(List<String> array) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(new RecAdapter(this, array));
    }
}