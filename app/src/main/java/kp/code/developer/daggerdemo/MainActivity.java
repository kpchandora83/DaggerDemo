package kp.code.developer.daggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> arrayList;
    private TestAdapter testAdapter;
    private String string;
    private int count = 0;
    private String TAG = "MainAcivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        string = "This is a new line ";
        arrayList.add(string + " " + count);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        testAdapter = new TestAdapter(this, arrayList);
        recyclerView.setAdapter(testAdapter);
    }

    public void onCLick(View view) {

        int position = ((TestAdapter) recyclerView.getAdapter()).getItemPosition();

        Log.i(TAG, "onCLick: " + position);

        switch (view.getId()) {

            case R.id.button:
                arrayList.add(string + " " + count++);
                testAdapter.notifyItemInserted(0);
                testAdapter.notifyItemRangeChanged(0, arrayList.size());
                recyclerView.smoothScrollToPosition(0);
                break;

            case R.id.button2:
                if (arrayList.size() > 0) {
                    arrayList.remove(arrayList.size() - 1);
                    testAdapter.notifyItemRemoved(0);
                    testAdapter.notifyItemRangeChanged(0, arrayList.size());
                }

                break;

        }
    }
}
