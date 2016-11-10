package com.jtsw.sharedfloor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jtsw.sharedfloor.ApplicationsTests.Home_listUsersHome;
import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.model.User;

import java.util.ArrayList;
import java.util.List;

public class HomeUsersAdapter extends RecyclerView.Adapter<HomeUsersAdapter.HomeUsersVewHolder> {

    private List<User> usersList;
    private Context context;
    public  HomeUsersAdapter(Context context)
    {
        this.context=context;
        this.usersList= new ArrayList<User>(Home_listUsersHome.getExpenseslist());
    }

    @Override
    public HomeUsersVewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.home_user_item,null);
        return new HomeUsersVewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeUsersVewHolder holder, int position) {
        holder.txvUserName.setText(usersList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    //the holder pattern
    public static class HomeUsersVewHolder extends RecyclerView.ViewHolder{

        TextView txvUserName;

        public HomeUsersVewHolder(View itemView) {
            super(itemView);

            txvUserName=(TextView) itemView.findViewById(R.id.homeTXVUsername);
        }
    }
}
