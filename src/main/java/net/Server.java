package net;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.epoll.EpollDatagramChannel;
import io.netty.channel.epoll.EpollEventLoopGroup;

public class Server {

    private static final int PORT = 7686;

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new EpollEventLoopGroup(processors))
                 .channel(EpollDatagramChannel.class)
                 .option(EpollChannelOption.SO_REUSEPORT, true)
                 .option(ChannelOption.SO_BROADCAST,      true)
                 .option(ChannelOption.SO_REUSEADDR,      true)
                 .option(ChannelOption.SO_RCVBUF,         1024 * 1024)
                 .option(ChannelOption.SO_SNDBUF,         1024 * 1024)
                 .option(ChannelOption.RCVBUF_ALLOCATOR,  new FixedRecvByteBufAllocator(1024 * 1024));
        for (int i = 0; i < processors; i++) {
            bootstrap.handler(new Handler()).bind(PORT);
        }
    }
}