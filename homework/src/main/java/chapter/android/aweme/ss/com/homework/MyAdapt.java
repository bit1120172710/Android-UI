package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;

public class MyAdapt extends RecyclerView.Adapter<MyAdapt.MyViewHolder> {
   private List<Message>messages;

    public MyAdapt(List<Message> messages) {
    this.messages=messages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);
       // viewHolder.time.setText("s:"+i);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView description;
        private TextView time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title);
            description=itemView.findViewById(R.id.tv_description);
            time=itemView.findViewById(R.id.tv_time);
        }
        public void bind(int postion)
        {
            title.setText(messages.get(postion).getTitle());
            description.setText(messages.get(postion).getDescription());
            time.setText(messages.get(postion).getTime());
        }
    }
}
