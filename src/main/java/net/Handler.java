package net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

public class Handler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) {
        String message = packet.content().toString(CharsetUtil.UTF_8);
//        System.err.println(packet);
        System.err.println(this);
//        System.err.println(message);
//        System.err.println(message.length());
//        ctx.write(new DatagramPacket(Unpooled.copiedBuffer(message, CharsetUtil.UTF_8), packet.sender()));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
    }
}