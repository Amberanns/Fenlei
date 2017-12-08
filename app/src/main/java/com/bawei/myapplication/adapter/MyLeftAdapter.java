package com.bawei.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.myapplication.R;
import com.bawei.myapplication.api.Meventss;
import com.bawei.myapplication.bean.Leftbean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class MyLeftAdapter extends RecyclerView.Adapter {
    List<Leftbean.DataBean> list;
    Context context;

    public MyLeftAdapter(List<Leftbean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.left, parent, false);
        return new MyViewHolderleft(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolderleft myViewHolderleft = (MyViewHolderleft) holder;
        myViewHolderleft.textView.setText(list.get(position).getName());
        myViewHolderleft.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new Meventss(list.get(position).getCid()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolderleft extends RecyclerView.ViewHolder {


        private final TextView textView;

        public MyViewHolderleft(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textleft);
        }
    }


}
