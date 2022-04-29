package eventelecom.com.example.atividade4.adapters;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eventelecom.com.example.atividade4.R;
import eventelecom.com.example.atividade4.model.Photos;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    private List<Photos> photosList;

    public PhotosAdapter(List<Photos> photosList) {
        this.photosList = photosList;
    }

    @NonNull
    @Override
    public PhotosAdapter.PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_photos_viewholder,parent,false);
        return new PhotosViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.PhotosViewHolder holder, int position) {
        holder.layout.findViewById(R.id.PhotosBackground).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            }
        });

        Picasso.get().load(photosList.get(position).getUrl()).into((ImageView) holder.layout.findViewById(R.id.PhotosImage));
        ((TextView) holder.layout.findViewById(R.id.PhotosId)).setText(photosList.get(position).getId()+"");
        ((TextView) holder.layout.findViewById(R.id.PhotosTitle)).setText(photosList.get(position).getTitle());
    }

    class PhotosViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public PhotosViewHolder(@NonNull View itemView){
            super(itemView);
            this.layout = itemView;
        }
    }
}
