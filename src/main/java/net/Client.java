package net;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SocketUtils;

public class Client {

    static final int PORT = 7686;

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        String message = "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history" +
                        "Every wiki page of this repository is automatically exported to the official Netty documentation site. Unless you're here to edit these pages, use the official site for a better reading experience.\n" +
                        "\n" +
                        "Other resources:\n" +
                        "\n" +
                        "Netty home page\n" +
                        "Documentation home\n" +
                        "All documents\n" +
                        "3rd-party articles\n" +
                        "3rd-party projects\n" +
                        "Adopters\n" +
                        "Wiki history";
        for (int i = 0; i < 100; i++) {
            Bootstrap b = new Bootstrap();
            b.group(eventExecutors)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(EpollChannelOption.SO_REUSEPORT, true)
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(64 * 1024))
                    .handler(new Handler());

            Channel ch = b.bind(0).sync().channel();

            new Thread(() -> {
                try {
                    while (true)
                        ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(message, CharsetUtil.UTF_8), SocketUtils.socketAddress("127.0.0.1", PORT))).sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}