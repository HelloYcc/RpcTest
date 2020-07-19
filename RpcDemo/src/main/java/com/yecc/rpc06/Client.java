package com.yecc.rpc06;

import com.yecc.rpc.common.IUserService;

public class Client {
    public static void main(String[] args) throws Exception {
        IUserService service = (IUserService) Stub.getStub(IUserService.class);
        System.out.println(service.findUserById(123));
    }
}