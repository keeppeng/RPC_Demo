package com.keeppeng.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private String ip;//访问IP
    private int port;//访问端口
    private static Client client = null;//单例对象
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    private Client() {
    }

    public static Client getInstance() {
        if (client == null) {
            client = new Client("localhost", 8080);
        }
        return client;
    }

    private Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    private boolean isConnection() {
        if (socket != null && inputStream != null && !socket.isClosed() && socket.isBound()) {
            return true;
        }
        try {
            socket = new Socket(ip, port);//三次握手
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 省去序列化和反序列化
     *
     * @param rpcContext
     * @return
     * @throws IOException
     */
    public Object invokeServer(RpcContext rpcContext) throws IOException {
        if (isConnection()) {
            //写数据，可以理解为请求
            outputStream.write(null);//此处应该为rpcContext的序列化对象
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) > 0) {
                return bytes;//此处应返回读到的数据的反序列化对象
            }
        }
        return null;
    }
}
