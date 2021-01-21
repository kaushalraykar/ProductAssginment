package com.example.kaush.productassignment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddProduct extends AppCompatActivity {

   private ImageView mProductImage;
  private EditText mProductName,mProductStock,mProductPrice,mProductDescription;
  private Button mProductAddButton;
  private int productImageIndex;
  private int ImageId;
  private boolean mClickFlag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        mProductImage=findViewById(R.id.prodctImage);
        mProductImage.setImageResource(R.mipmap.ic_launcher);

        mProductName=findViewById(R.id.edtProductName);
        mProductStock=findViewById(R.id.edtProductStock);
        mProductPrice=findViewById(R.id.edtProductPrice);
        mProductDescription=findViewById(R.id.edtProductDescription);
        mProductAddButton=findViewById(R.id.addProductButton);

        mProductAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mClickFlag==true) {
                    ImageId = productImageIndex;
                }
                else {
                    ImageId=R.mipmap.ic_launcher;
                }
                String productName=mProductName.getText().toString();
                int productStock=Integer.parseInt(mProductStock.getText().toString());
                float productPrice=Float.parseFloat(mProductPrice.getText().toString());
                String productDescription=mProductDescription.getText().toString();

                    Product product = new Product(ImageId, productName, productStock, productPrice, productDescription);
                    Log.e("Full Object", "OOO" + product);

                Intent intent=new Intent();
                intent.putExtra("productValue",product);
                setResult(1,intent);
                finish();



            }
        });

        mProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickFlag=true;
                Intent intent=new Intent(AddProduct.this,GridViewActivity.class);
                intent.putExtra("from","add");
                startActivityForResult(intent,4);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==4 && requestCode==4){
             productImageIndex=data.getIntExtra("ImageIndex",1);
            mProductImage.setImageResource(productImageIndex);

        }
    }
}
