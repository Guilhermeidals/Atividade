package eventelecom.com.example.atividade4.adapters;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import eventelecom.com.example.atividade4.model.Posts;
import eventelecom.com.example.atividade4.R;



public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder>{
    private List<Posts> listaPosts;
    private int selectedItemPosition = -1;

    public PostsAdapter(List<Posts> listaPosts) {
        this.listaPosts = listaPosts;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_posts_viewholder, parent, false);

        return new PostsViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaPosts.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.layout.findViewById(R.id.TVBackground).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedItemPosition = position;
                notifyDataSetChanged();
            }
        });
        ((TextView) holder.layout.findViewById(R.id.TVId)).setText(listaPosts.get(position).getId()+"");
        ((TextView) holder.layout.findViewById(R.id.TVUserId)).setText(listaPosts.get(position).getUserId()+"");
        ((TextView) holder.layout.findViewById(R.id.TVtitle)).setText(listaPosts.get(position).getTitle());
        ((TextView) holder.layout.findViewById(R.id.TVPost)).setText(listaPosts.get(position).getPost());

        if(selectedItemPosition == position)
            holder.layout.findViewById(R.id.TVBackground).setBackgroundColor(Color.parseColor("#87CEFA"));
        else
            holder.layout.findViewById(R.id.TVBackground).setBackgroundColor(Color.WHITE);
    }

    class PostsViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}