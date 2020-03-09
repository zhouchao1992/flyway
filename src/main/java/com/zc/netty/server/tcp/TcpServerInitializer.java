package com.zc.netty.server.tcp;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class TcpServerInitializer  extends ChannelInitializer<SocketChannel> {
   /* @Resource
    private TcpServerHandler tcpServerHandler;*/
    /*@Resource
    private TcpHeartBeatServerHandler tcpHeartBeatServerHandler;*/

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        /* 处理tcp处理 */
        if (socketChannel.localAddress().getPort()== 7777){
            socketChannel.pipeline().addLast(new ByteArrayDecoder());
            socketChannel.pipeline().addLast(new ByteArrayEncoder());
            socketChannel.pipeline().addLast(new TcpServerHandler());
            //心跳包
            socketChannel.pipeline().addLast(new IdleStateHandler(300,0,0, TimeUnit.SECONDS));
            //socketChannel.pipeline().addLast("hearbeata",tcpHeartBeatServerHandler); //心跳事件
        }else{
        }

    }
}
