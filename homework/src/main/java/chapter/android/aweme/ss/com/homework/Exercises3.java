package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity implements MyAdapt.MyItemClickListener {

    private RecyclerView mNumbersListView;
    private MyAdapt myAdapt;
    private List<Message> messages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        mNumbersListView = findViewById(R.id.rv_list);
        try {
            InputStream assetInput = getAssets().open("data.xml");
             messages = PullParser.pull2xml(assetInput);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        myAdapt=new MyAdapt(messages,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNumbersListView.setLayoutManager(layoutManager);
        mNumbersListView.setHasFixedSize(true);
        mNumbersListView.setAdapter(myAdapt);
    }
    @Override
    public void onListItemClick(int position)
    {
        Intent intent=new Intent(this,ChatroomActivity.class);
        intent.putExtra("message",messages.get(position).getTitle());
        startActivity(intent);
        //Toast.makeText(this, "item"+position, Toast.LENGTH_SHORT).show();
    }

}
