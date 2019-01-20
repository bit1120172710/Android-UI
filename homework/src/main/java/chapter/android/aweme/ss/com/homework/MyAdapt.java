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
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapt extends RecyclerView.Adapter<MyAdapt.MyViewHolder> {
   private List<Message>messages;
    private MyItemClickListener listener;
    public MyAdapt(List<Message> messages,MyItemClickListener listener) {
    this.messages=messages;
    this.listener=listener;
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title;
        private TextView description;
        private TextView time;
        private CircleImageView pic;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title);
            description=itemView.findViewById(R.id.tv_description);
            time=itemView.findViewById(R.id.tv_time);
            pic=itemView.findViewById(R.id.iv_avatar);
            itemView.setOnClickListener(this);
        }
        public void bind(int position)
        {
            title.setText(messages.get(position).getTitle());
            description.setText(messages.get(position).getDescription());
            time.setText(messages.get(position).getTime());
            Message msg=messages.get(position);
            if(msg.getIcon().equals("TYPE_ROBOT")){
            pic.setImageResource(R.drawable.session_robot);
            }else if(msg.getIcon().equals("TYPE_SYSTEM"))
            {
                pic.setImageResource(R.drawable.session_system_notice);
            }else if(msg.getIcon().equals("TYPE_GAME"))
            {
                pic.setImageResource(R.drawable.icon_micro_game_comment);
            }else if(msg.getIcon().equals("TYPE_STRANGER"))
            {
                pic.setImageResource(R.drawable.session_stranger);
            }
        }
        @Override
        public void onClick(View v)
        {
            int position =getAdapterPosition();
            if(listener!=null)
            {
                listener.onListItemClick(position);
            }
        }
    }
    public interface MyItemClickListener{
        void onListItemClick(int position);
    }
}