package com.yecc.rpc07;




import com.yecc.rpc.common.IUserService;
import com.yecc.rpc.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 但是这里仅仅实现了findByUserId的方法代理，如果要实现其他方法的代理该怎么做呢？
 * 这里就要从协议层做出改进
 *
 * 服务器端也要做出对应处理
 */

public class Stub {
    public static Object getStub(Class clazz) {
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                String clazzName=clazz.getName();
                String methodName = method.getName();
                Class[] parametersTypes = method.getParameterTypes();

                oos.writeUTF(clazzName);
                oos.writeUTF(methodName);
                oos.writeObject(parametersTypes);
                oos.writeObject(args);
                oos.flush();


                ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
                Object oo = (Object)ois.readObject();
                oos.close();
                s.close();
                return oo;
            }
        };
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, h);
        return o;
    }




}