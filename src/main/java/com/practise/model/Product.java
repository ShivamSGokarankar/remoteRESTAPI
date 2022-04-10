package com.practise.model;

public class Product
{
    private long product_code;
    private String product_name;
    private String product_type;

    public Product(long product_code, String product_name, String product_type) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_type = product_type;
    }

    public long getProduct_code() {
        return product_code;
    }

    public void setProduct_code(long product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}
