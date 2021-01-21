package com.example.kaush.productassignment;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private int mImage;
    private String mProductName;
    private int mProductStock;
    private float mProductPrice;
    private String mProductDescription;

    public Product(int Image, String ProductName, int ProductStock, float ProductPrice, String ProductDescription) {
        this.mImage = Image;
        this.mProductName = ProductName;
        this.mProductStock = ProductStock;
        this.mProductPrice = ProductPrice;
        this.mProductDescription = ProductDescription;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return mImage == product.mImage &&
                mProductStock == product.mProductStock &&
                Float.compare(product.mProductPrice, mProductPrice) == 0 &&
                Objects.equals(mProductName, product.mProductName) &&
                Objects.equals(mProductDescription, product.mProductDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mImage, mProductName, mProductStock, mProductPrice, mProductDescription);
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int Image) {
        this.mImage = Image;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String ProductName) {
        this.mProductName = ProductName;
    }

    public int getProductStock() {
        return mProductStock;
    }

    public void setProductStock(int ProductStock) {
        this.mProductStock = ProductStock;
    }

    public float getProductPrice() {
        return mProductPrice;
    }

    public void setProductPrice(float ProductPrice) {
        this.mProductPrice = ProductPrice;
    }

    public String getProductDescription() {
        return mProductDescription;
    }

    public void setProductDescription(String ProductDescription) {
        this.mProductDescription = ProductDescription;
    }
}
