package gr.athtech.athtech.course.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import gr.athtech.athtech.course.R;

public class ListViewAdapter extends ArrayAdapter<String> {
    private Context context;

    public ListViewAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_user_info, parent,false);

        ListViewViewHolder holder = new ListViewViewHolder(view);
        holder.setValues("Success");

        return view;
    }
}
