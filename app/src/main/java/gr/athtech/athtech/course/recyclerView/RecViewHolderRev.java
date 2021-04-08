package gr.athtech.athtech.course.recyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.athtech.athtech.course.R;

public class RecViewHolderRev extends RecyclerView.ViewHolder {

    public RecViewHolderRev(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String message) {
        TextView textView = itemView.findViewById(R.id.row_text);
        textView.setText(message);
    }
}
