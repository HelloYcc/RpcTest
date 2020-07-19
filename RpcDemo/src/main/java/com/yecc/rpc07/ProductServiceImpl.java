package com.yecc.rpc07;

import com.yecc.rpc.common.IProductService;
import com.yecc.rpc.common.Product;

public class ProductServiceImpl implements IProductService {
    @Override
    public Product getProductById(Integer id) {
        return new Product(id,"james");
    }
}
