package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserGridAdapter extends RecyclerView.Adapter<UserGridAdapter.UserGridViewHolder> {
    UserGridCallback userGridCallback;
    ArrayList<User> listUser;
    Context context;

    public UserGridAdapter(ArrayList<User> listUser, UserGridCallback userGridCallback) {
        this.listUser = listUser;
        this.userGridCallback = userGridCallback;
    }

    @NonNull
    @Override
    public UserGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.layoutitemgrid, parent, false);
        UserGridViewHolder viewHolder = new UserGridViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserGridViewHolder holder, int position) {
        User item = listUser.get(position);
        holder.imAvatar.setImageBitmap(Utils.convertToBitmapFromAssets(context, item.getAvatar()));
        holder.itemView.setOnClickListener(view->userGridCallback.onItemClick(item.getId()));
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class UserGridViewHolder extends RecyclerView.ViewHolder {
        ImageView imAvatar;
        public UserGridViewHolder(@NonNull View itemView) {
            super(itemView);
            imAvatar = itemView.findViewById(R.id.idAvatar);
        }
    }
    public interface UserGridCallback {
        void onItemClick(String id);
    }
}
