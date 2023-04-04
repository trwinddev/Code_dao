package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    UserCallback userCallback;
    ArrayList<User> listUser;
    Context context;

    public UserAdapter(ArrayList<User> listUser, UserCallback userCallback) {
        this.listUser = listUser;
        this.userCallback = userCallback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.layoutitem, parent, false);
        UserViewHolder viewHolder = new UserViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User item = listUser.get(position);
        holder.imAvatar.setImageBitmap(Utils.convertToBitmapFromAssets(context, item.getAvatar()));
        holder.tvName.setText(item.getName());

        holder.itemView.setOnClickListener(view->userCallback.onItemClick(item.getId()));
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView imAvatar;
        TextView tvName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imAvatar = itemView.findViewById(R.id.idAvatar);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }

    public interface UserCallback {
        void onItemClick(String id);
    }
}
