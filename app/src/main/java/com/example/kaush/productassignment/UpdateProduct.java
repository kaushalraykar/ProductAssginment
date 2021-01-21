package com.example.kaush.productassignment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UpdateProduct extends AppCompatActivity {
    ImageView mUpdateProductImage;
    EditText mupdateProductImage,mupdateProductName,mupdateProductStock,mupdateProductPrice,mupdateProductDescription;
    Button mUpdateBtnObject;
    Product product;
    private int updateImageProductId;
    private int updateProductImg;
    private boolean mClickFlag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        mUpdateProductImage=findViewById(R.id.updateProductImage);
        mupdateProductName=findViewById(R.id.updateProductName);
        mupdateProductStock=findViewById(R.id.updateProductStock);
        mupdateProductPrice=findViewById(R.id.updateProductPrice);
        mupdateProductDescription=findViewById(R.id.updateProductDescription);

        mUpdateBtnObject=findViewById(R.id.updateProductObjectBtn);

        product= (Product) getIntent().getSerializableExtra("UpdateProductObj");

        mUpdateProductImage.setImageResource(product.getImage());
        mupdateProductName.setText(product.getProductName());
        mupdateProductStock.setText(""+product.getProductStock());
        mupdateProductPrice.setText(""+product.getProductPrice());
        mupdateProductDescription.setText(product.getProductDescription());

        // set image id came from previous activity



        mUpdateBtnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product cloneProduct=product;
                if(mClickFlag==true) {
                    updateProductImg = updateImageProductId;
                }
                else{
                    updateProductImg=product.getImage();
                }
                String updateProductName=mupdateProductName.getText().toString();
                int updateProductStock=Integer.parseInt(mupdateProductStock.getText().toString());
                float updateProductPrice=Float.parseFloat(mupdateProductPrice.getText().toString());
                String updateProductDescription=mupdateProductDescription.getText().toString();

                Product updatedProduct=new Product(updateProductImg,updateProductName,updateProductStock,updateProductPrice,updateProductDescription);

                Intent intent=new Intent();
                intent.putExtra("UpdatedProductObject",updatedProduct);
                intent.putExtra("CloneObject",cloneProduct);
                setResult(3,intent);
                finish();
            }
        });

        mUpdateProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickFlag=true;
                Log.e("Tag1",""+mClickFlag);
                Intent intent=new Intent(UpdateProduct.this,GridViewActivity.class);
                intent.putExtra("from","updte");
                startActivityForResult(intent,5);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==5){
            updateImageProductId=data.getIntExtra("updateImageIndex",1);
                mUpdateProductImage.setImageResource(updateImageProductId);

        }
    }
}
