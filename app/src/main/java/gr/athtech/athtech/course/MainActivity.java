package gr.athtech.athtech.course;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AbstractActivity {

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    void initLayout() {
        TextView text = findViewById(R.id.text_one_1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "User pressed the textArea", Toast.LENGTH_SHORT).show();
                Log.i("TEXT", "single click");
            }
        });
        text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i("TEXT", "long click");
                return true;
            }
        });


        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoTheLoginScreen();
            }
        });

        LinearLayout linearLayout = findViewById(R.id.linerLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void gotoTheLoginScreen() {
        Toast.makeText(MainActivity.this, "User pressed the button", Toast.LENGTH_SHORT).show();
        Log.i("BUTTON", "button clicked");
    }

    @Override
    void runOperations() {

    }

    @Override
    void stopOperations() {

    }
}