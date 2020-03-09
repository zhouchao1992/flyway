package com.zc.netty.server.udp;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.timeout.IdleStateHandler;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class UdpServerInitializer extends ChannelInitializer<NioDatagramChannel> {
   /* @Resource
    private  UdpChatServerHandler udpChatServerHandler ;*/
   /* @Autowired
    private  UdpHeartBeatServerHandler udpHeartBeatServerHandler;*/
    @Override
    protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
        ChannelPipeline pipeline = nioDatagramChannel.pipeline();
        pipeline.addLast("handler",new UdpChatServerHandler());//消息处理器
       // pipeline.addLast("ackHandler", new UdpAckServerHandler());//ack处理器

        pipeline.addLast("timeout", new IdleStateHandler(180, 0, 0, TimeUnit.SECONDS));// //此两项为添加心跳机制,60秒查看一次在线的客户端channel是否空闲
       // pipeline.addLast("hearbeat",new UdpHeartBeatServerHandler());// 心跳处理handler
    }
}
