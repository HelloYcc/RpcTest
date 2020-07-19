package com.yecc.rpc05;

import com.yecc.rpc.common.IUserService;

public class Client {
    public static void main(String[] args) throws Exception {
        IUserService service = Stub.getStub();
        System.out.println(service.findUserById(123));
    }
}