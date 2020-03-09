package com.zc.netty.server;

import com.zc.netty.server.http.HttpServerInitializer;
import com.zc.netty.server.tcp.TcpServerInitializer;
import com.zc.netty.server.udp.UdpServerInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NettyStart {
    public void init(int httpport,int tcpport,int udpport) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            //http和tcp设置
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG,1024);
            //UDP 设置
            Bootstrap Bootstrap2 = new Bootstrap();//udp不能使用ServerBootstrap
            Bootstrap2.group(workerGroup);
            Bootstrap2 .channel(NioDatagramChannel.class);//设置UDP通道
            Bootstrap2 .option(ChannelOption.SO_BROADCAST, true);// 支持广播
            Bootstrap2 .option(ChannelOption.SO_BACKLOG, 128);
            Bootstrap2 .option(ChannelOption.SO_RCVBUF, 1024 * 1024);// 设置UDP读缓冲区为1M
            Bootstrap2 .option(ChannelOption.SO_SNDBUF, 1024 * 1024);// 设置UDP写缓冲区为1M

            List ports = Arrays.asList(httpport,tcpport,udpport);
            Collection channels = new ArrayList(ports.size());
            for (Object pot : ports) {
                int port=(int)pot;
                Channel serverChannel=null;
                if (port==udpport){
                    Bootstrap2 .handler(new UdpServerInitializer());//初始化处理器
                    serverChannel = Bootstrap2.bind(port).sync().channel();
                }else if (port==httpport){
                    bootstrap.childHandler(new HttpServerInitializer());
                    serverChannel = bootstrap.bind(port).sync().channel();
                }else if (port==tcpport){
                    bootstrap.childHandler(new TcpServerInitializer());
                    serverChannel = bootstrap.bind(port).sync().channel();
                }
                channels.add(serverChannel);
            }
            for (Object ch : channels) {
                Channel channel = (Channel)ch;
                channel.closeFuture().sync();
            }
            //  future.channel().closeFuture().sync();
        }catch(Exception e){
            System.out.println("Server服务端报异常---------"+e.getMessage());
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        NettyStart start = new NettyStart();
        start.init(6666,7777,9999);
    }
}
