package gr.athtech.athtech.course.recyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import gr.athtech.athtech.course.R;

public class RecDynamicAdapterV2 extends ListAdapter<String, RecyclerView.ViewHolder> {

    protected RecDynamicAdapterV2() {
        super(new DiffUtilsForRec());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_info, parent, false);
            return new RecViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_info_rev, parent, false);
            return new RecViewHolderRev(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i("RECYCLER", "current position -> " + String.valueOf(position));

        if (holder instanceof RecViewHolder) {
            RecViewHolder _holder = (RecViewHolder) holder;
            _holder.bind(getItem(position));
        } else if (holder instanceof RecViewHolderRev) {
            RecViewHolderRev _holder = (RecViewHolderRev) holder;
            _holder.bind(getItem(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 1;
        } else {
            return super.getItemViewType(position);
        }
    }
}
