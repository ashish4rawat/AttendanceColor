package com.technialrj.attendancemaster;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class TTSubjectsAdapter extends RecyclerView.Adapter<TTSubjectsAdapter.ViewHolder>{


        ArrayList<String> myNames ;

        public TTSubjectsAdapter(ArrayList<String> names) {
                myNames = names;
        }

        @Override
        public TTSubjectsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tt_subject_row,parent,false);
                return  new TTSubjectsAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TTSubjectsAdapter.ViewHolder holder, int position) {

                holder.singleName.setText(myNames.get(position));

        }

        @Override
        public int getItemCount() {
                return myNames.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

                public TextView singleName;

                public ViewHolder(View itemView) {

                        super(itemView);
                        singleName  = (TextView) itemView.findViewById(R.id.singleName) ;
                }
        }

}
