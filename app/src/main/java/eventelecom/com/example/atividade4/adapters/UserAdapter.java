package eventelecom.com.example.atividade4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import eventelecom.com.example.atividade4.databinding.LayoutUsersViewholderBinding;
import eventelecom.com.example.atividade4.model.User;
import eventelecom.com.example.atividade4.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    public interface ClickListener {
        void OnClick(User user);
    }

    private List<User> listaUsers = new ArrayList<>();
    private ClickListener clickListener;

    public UserAdapter(ClickListener clickListener) {
        this.listaUsers = listaUsers;
        this.clickListener = clickListener;
    }

    public void setUsers(List<User> users){
        this.listaUsers = users;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutUsersViewholderBinding layoutUsersViewholderBinding = LayoutUsersViewholderBinding.inflate(layoutInflater,parent,false);
        return new UserViewHolder(layoutUsersViewholderBinding);
    }

    @Override
    public int getItemCount() {
        return listaUsers.size();
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listaUsers.get(position);
        holder.layoutUsersViewholderBinding.setVarUser(user);
        holder.layoutUsersViewholderBinding.getRoot().setOnClickListener(v -> clickListener.OnClick(user));
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        LayoutUsersViewholderBinding layoutUsersViewholderBinding;

        public UserViewHolder(@NonNull LayoutUsersViewholderBinding layoutUsersViewholderBinding) {
            super(layoutUsersViewholderBinding.getRoot());
            this.layoutUsersViewholderBinding = layoutUsersViewholderBinding;
        }
    }
}