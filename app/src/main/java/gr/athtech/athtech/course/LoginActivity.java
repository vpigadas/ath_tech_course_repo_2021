package gr.athtech.athtech.course;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import gr.athtech.athtech.course.listview.ListViewActivity;
import gr.athtech.athtech.course.recyclerView.RecyclerViewActivity;

public class LoginActivity extends AbstractActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    int getLayout() {
        return R.layout.activity_login_v2;
    }

    @Override
    void initLayout() {
        Button btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
//                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
//                String url = "https://api.themoviedb.org/3/configuration?api_key=9bb33d52c77a0f94a17eafe4c83b4988";
//
//                // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                Log.i("COMM", response);
//
//                                JsonResponse json = new Gson().fromJson(response, JsonResponse.class);
//
//                                Log.i("COMM", json.toString());
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("COMM", error.getMessage());
//                    }
//                });
//
//                // Add the request to the RequestQueue.
//                queue.add(stringRequest);

                Intent intent = new Intent(LoginActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

//        btnLogin.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                //make an action
//                return false;
//            }
//        });

        Button btnCancel = findViewById(R.id.cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

    }

    @Override
    void runOperations() {

    }

    @Override
    void stopOperations() {

    }
}