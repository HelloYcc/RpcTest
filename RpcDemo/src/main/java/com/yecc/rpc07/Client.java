package com.yecc.rpc07;

import com.yecc.rpc.common.IProductService;
import com.yecc.rpc.common.IUserService;

public class Client {
    public static void main(String[] args) throws Exception {
        IProductService service = (IProductService) Stub.getStub(IProductService.class);
        System.out.println(service.getProductById(321));
    }
}