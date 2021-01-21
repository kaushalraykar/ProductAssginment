package com.example.kaush.productassignment;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private Button mAddBtn;
    private ListView mProductListView;
    private ArrayList<Product> mArrayProductList;
    private ProductAdapter mProductAdapter;
    Product product,cloneProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddBtn = findViewById(R.id.addBtn);
        mProductListView=findViewById(R.id.productListView);

        mArrayProductList=new ArrayList<>();

        mProductAdapter=new ProductAdapter(mArrayProductList,this);
        mProductListView.setAdapter(mProductAdapter);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddProduct.class);
                startActivityForResult(intent, 1);

            }
        });

        mProductListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(MainActivity.this,DetailProduct.class);
                intent.putExtra("porductInfo",mArrayProductList.get(i));
                startActivityForResult(intent,2);


            }
        });




    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==1) {
            product = (Product) data.getExtras().getSerializable("productValue");
            mArrayProductList.add(new Product(product.getImage(), product.getProductName(), product.getProductStock(), product.getProductPrice(), product.getProductDescription()));
            mProductAdapter.notifyDataSetChanged();

        }
        else if(resultCode==2)
        {
            product = (Product) data.getExtras().getSerializable("DeleteProductObject");

            for(int i=0;i<mArrayProductList.size();i++){
                if(mArrayProductList.get(i).equals(product)){
                    mArrayProductList.remove(mArrayProductList.get(i));
                    mProductAdapter.notifyDataSetChanged();
                    break;
                }
            }

        }

        else if(resultCode==3){
            Product cloneProductObj;
            Log.e("TAGG","MAIN"+resultCode);

            product= (Product) data.getExtras().getSerializable("UpdatedProductObject");
            cloneProductObj= (Product) data.getExtras().getSerializable("CloneObject");

            for(int i=0;i< mArrayProductList.size();i++){
                if(mArrayProductList.get(i).equals(cloneProductObj)){
                    mArrayProductList.get(i).setImage(product.getImage());
                    mArrayProductList.get(i).setProductName(product.getProductName());
                    mArrayProductList.get(i).setProductStock(product.getProductStock());
                    mArrayProductList.get(i).setProductPrice(product.getProductPrice());
                    mArrayProductList.get(i).setProductDescription(product.getProductDescription());
                    mProductAdapter.notifyDataSetChanged();
                    break;
                }

            }

        }
    }

}
