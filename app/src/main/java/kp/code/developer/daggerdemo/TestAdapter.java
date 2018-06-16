package kp.code.developer.daggerdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyHolder> {

    private int position;
    private ArrayList<String >arrayList;
    private Context context;

    public TestAdapter(Context context, ArrayList<String >arrayList){

        this.arrayList = arrayList;
        this.context = context;


    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_layout, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        this.position = holder.getAdapterPosition();
        holder.textView.setText(arrayList.get(position));

    }

    public int getItemPosition(){
        return position;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
