package gr.athtech.athtech.course;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import gr.athtech.athtech.course.json.JsonResponse;

public class MainActivity extends AbstractActivity {

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    void initLayout() {
        Bundle parameter = getIntent().getExtras();
        if (parameter != null) {
            String name = parameter.getString("name");
            int date = parameter.getInt("date");
            JsonResponse json = (JsonResponse) parameter.getSerializable("json");
            JsonResponse json1 = parameter.getParcelable("json1");
            Log.i("DEMO", name);
        }


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
                Bundle parameter = new Bundle();
                if (getIntent().getExtras() != null) {
                    parameter.putAll(getIntent().getExtras());
                }

                Intent intent = new Intent();
                intent.putExtras(parameter);
                setResult(-1, intent);
                finish();
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

    @Override
    public void onBackPressed() {

    }
}