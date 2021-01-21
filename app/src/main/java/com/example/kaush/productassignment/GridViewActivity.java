package com.example.kaush.productassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {
    GridView mGridView;
    private int []mArrayProductImage={
            R.drawable.cpu,
            R.drawable.ele1,
            R.drawable.gym1,
            R.drawable.gym2,
            R.drawable.lap1,
            R.drawable.lap3,
            R.drawable.mob1,
            R.drawable.mob2,
            R.drawable.mob3,
            R.drawable.mob4,
            R.drawable.product1,
    };
    private ImageAdapter mAdatpter;
    private String fromKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGridView=findViewById(R.id.grid_view);

        // read addflag
        fromKey=getIntent().getStringExtra("from");



        mAdatpter=new ImageAdapter(mArrayProductImage,this);
        mGridView.setAdapter(mAdatpter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(fromKey!=null && fromKey.equals("add")) {
                    Intent intent = new Intent();
                    intent.putExtra("ImageIndex", mArrayProductImage[i]);
                    setResult(4, intent);
                    finish();  // activity finish
                }

                //update

                Intent intent1=new Intent();
                intent1.putExtra("updateImageIndex",mArrayProductImage[i]);
                setResult(5,intent1);
                finish();
            }
        });
    }
}
