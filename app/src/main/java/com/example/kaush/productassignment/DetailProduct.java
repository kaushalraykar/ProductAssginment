package com.example.kaush.productassignment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailProduct extends AppCompatActivity {

    private  Product product;
    private ImageView mDetailProductImage;
    private TextView mDetailProductName,mDetailProductStock,mDetailProductPrice,mDetailProductDescription;
    private Button mupdateBtn,mdeleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        mDetailProductImage=findViewById(R.id.productDetailIamge);
        mDetailProductName=findViewById(R.id.productDetailName);
        mDetailProductStock=findViewById(R.id.productDetailStock);
        mDetailProductPrice=findViewById(R.id.productDetailPrice);
        mDetailProductDescription=findViewById(R.id.productDetailDescription);
        mupdateBtn=findViewById(R.id.updateBtn);
        mdeleteBtn=findViewById(R.id.deleteBtn);


        product= (Product) getIntent().getSerializableExtra("porductInfo");

        mDetailProductImage.setImageResource(product.getImage());
        mDetailProductName.setText(product.getProductName());
        mDetailProductStock.setText(""+product.getProductStock());
        mDetailProductPrice.setText(""+product.getProductPrice());
        mDetailProductDescription.setText(product.getProductDescription());

        mdeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("DeleteProductObject",product);
                setResult(2,intent);
                finish();
            }
        });

        mupdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailProduct.this,UpdateProduct.class);
                intent.putExtra("UpdateProductObj",product);
                startActivityForResult(intent,3);
                setResult(3,intent);


            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==3) {
            Log.e("BBBB", "" + resultCode);

            Product updtedProduct= (Product) data.getExtras().getSerializable("UpdatedProductObject");
            Product cloneProduct= (Product) data.getExtras().getSerializable("CloneObject");

            Log.e("TAG",""+updtedProduct.getProductName());
            setResult(3,data);
            this.finish();

        }

    }
}
