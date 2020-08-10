package com.keeppeng.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /**
     * 绑定端口，暴露服务的端口
     */
    public void bind(int port) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(port);
            //循环监听客户端请求
            while (true) {
                socket = serverSocket.accept();
                outputStream = socket.getOutputStream();
                inputStream = socket.getInputStream();

                //
                byte[] req = new byte[1024];
                while (inputStream.read(req) > 0) {
                    //接受RpcContext的反序列化对象
                    RpcContext context = null;
                    Class clazz = null;
                    //查看容器中是否包含这个类,有的话，通过反射调用
                    if (Registry.map.contains(context.getClassName())) {
                        clazz = Registry.map.get(context.getClassName());
                    }
                    try {
                        Method clazzMethod = clazz.getMethod(context.getClassName(), context.getTypes());
                        Object invoke = clazzMethod.invoke(clazz.newInstance(), context.getParams());//反射调用方法
                        outputStream.write(null);//实际上需要返回这个invoke对象的序列化对象
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源

        }
    }
}
