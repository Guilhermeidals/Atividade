package eventelecom.com.example.atividade4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eventelecom.com.example.atividade4.model.Comments;
import eventelecom.com.example.atividade4.R;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>{

    private List<Comments> listaComments;

    public CommentsAdapter(List<Comments> listaComments) {
        this.listaComments = listaComments;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comments_viewholder, parent, false);

        return new CommentsViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaComments.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        holder.layout.findViewById(R.id.CVBackground).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        ((TextView) holder.layout.findViewById(R.id.ComId)).setText(listaComments.get(position).getId()+"");
        ((TextView) holder.layout.findViewById(R.id.ComMent)).setText(listaComments.get(position).getComment());
        ((TextView) holder.layout.findViewById(R.id.ComName)).setText(listaComments.get(position).getName());
        ((TextView) holder.layout.findViewById(R.id.ComEmail)).setText(listaComments.get(position).getEmail());
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}