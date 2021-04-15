package gr.athtech.athtech.course.recyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import gr.athtech.athtech.course.R;

public class RecDynamicAdapter extends ListAdapter<String, RecViewHolder> {
    private Context context;

    protected RecDynamicAdapter(Context context) {
        super(new DiffUtilsForRec());
        this.context = context;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_user_info, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        Log.i("RECYCLER", "current position -> " + String.valueOf(position));
        holder.bind(getItem(position));
    }
}
