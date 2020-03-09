package com.zc.netty.server.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
   /* private HttpServerHandler httpServerHandler;*/
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        /* 处理http处理 */
        if (socketChannel.localAddress().getPort()==6666){
            socketChannel.pipeline().addLast(new HttpServerCodec());/*HTTP 服务的解码器*/
            socketChannel.pipeline().addLast(new HttpObjectAggregator(2048));/*HTTP 消息的合并处理*/
            socketChannel.pipeline().addLast(new HttpServerHandler());
            //处理tcp请求
        }else{
            System.out.println("请求端口出错："+socketChannel.localAddress().getPort());
        }
    }
}
