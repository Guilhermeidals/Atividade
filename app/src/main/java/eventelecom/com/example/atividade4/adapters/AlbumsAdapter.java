package eventelecom.com.example.atividade4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eventelecom.com.example.atividade4.R;
import eventelecom.com.example.atividade4.model.Albums;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder> {

    private List<Albums> albumsList = new ArrayList<>();

    public AlbumsAdapter(List<Albums> list){
        this.albumsList = list;
        notifyDataSetChanged();
    }

    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_albums_viewholder,parent,false);
        return new AlbumsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, int position) {
        holder.layout.findViewById(R.id.AlbumsBackground).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.layout.findViewById(R.id.StarOn).getVisibility() == View.INVISIBLE) {
                    holder.layout.findViewById(R.id.StarOn).setVisibility(View.VISIBLE);
                    holder.layout.findViewById(R.id.StarOff).setVisibility(View.INVISIBLE);
                }else{
                    holder.layout.findViewById(R.id.StarOn).setVisibility(View.INVISIBLE);
                    holder.layout.findViewById(R.id.StarOff).setVisibility(View.VISIBLE);
                }

            }

        });
        ((TextView) holder.layout.findViewById(R.id.AlbumVHTitle)).setText(albumsList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return albumsList.size();
    }


    class AlbumsViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public AlbumsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
