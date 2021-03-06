package com.yecc.rpc02;


import com.yecc.rpc.common.IUserService;
import com.yecc.rpc.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running =true;

    public static void main(String[] args)throws Exception {
        ServerSocket ss=new ServerSocket(10086);
        while (running){
            Socket s=ss.accept();
            process(s);
            s.close();
        }

    }

    private static void process(Socket s) throws Exception{
        InputStream in=s.getInputStream();
        OutputStream out=s.getOutputStream();
        DataInputStream dis=new DataInputStream(in);
        DataOutputStream dos=new DataOutputStream(out);

        int id=dis.readInt();
        IUserService service=new UserServiceImpl();
        User user=service.findUserById(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}
