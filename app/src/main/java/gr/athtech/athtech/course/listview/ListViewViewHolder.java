package gr.athtech.athtech.course.listview;

import android.view.View;
import android.widget.TextView;

import gr.athtech.athtech.course.R;

public class ListViewViewHolder {

    private View view;

    public ListViewViewHolder(View view) {
        this.view = view;
    }

    public void setValues(String message) {
        TextView textView = view.findViewById(R.id.row_text);
        textView.setText(message);
    }
}
