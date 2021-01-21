package com.example.kaush.productassignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private ArrayList<Product> mProductArrayList;
    private Context mContext;

    public ProductAdapter(ArrayList<Product> ProductArrayList, Context Context) {
        this.mProductArrayList = ProductArrayList;
        this.mContext = Context;
    }

    @Override
    public int getCount() {
        return mProductArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater;
        View view;

        if(convertView==null){
            inflater = LayoutInflater.from(mContext);
            view=inflater.inflate(R.layout.lay_product,null);

        }
        else {
            view=convertView;

        }

        ImageView imageView=view.findViewById(R.id.productImageID);
        TextView productNameTxtView =view.findViewById(R.id.productNameID);
        TextView productDescTxtView=view.findViewById(R.id.productDescriptionID);
        TextView productPriceTxtView=view.findViewById(R.id.productPriceID);
        TextView productStockTxtView=view.findViewById(R.id.productStockID);


        Product product=mProductArrayList.get(i);

        imageView.setImageResource(product.getImage());

        productNameTxtView.setText(product.getProductName());

        productDescTxtView.setText(product.getProductDescription());

        String price=Float.toString(product.getProductPrice());
        productPriceTxtView.setText(price);

        String stock=Integer.toString(product.getProductStock());
        productStockTxtView.setText(stock);

        return view;
    }
}
