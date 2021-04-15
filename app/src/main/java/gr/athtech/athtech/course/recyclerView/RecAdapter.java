package gr.athtech.athtech.course.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.athtech.athtech.course.R;

public class RecAdapter extends RecyclerView.Adapter<RecViewHolder> {

    private Context context;
    private List<String> array;

    public RecAdapter(Context context, List<String> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_user_info, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        holder.bind(array.get(position));
    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
