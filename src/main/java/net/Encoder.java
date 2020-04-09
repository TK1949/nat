//package net;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.socket.DatagramPacket;
//import io.netty.handler.codec.MessageToMessageEncoder;
//
//import java.net.SocketAddress;
//import java.util.List;
//
//public class Encoder extends MessageToMessageEncoder<DatagramPacket>
//{
//    @Override
//    protected void encode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
//        SocketAddress socketAddress = ctx.channel().remoteAddress();
//        SocketAddress socketAddress1 = ctx.channel().localAddress();
//
//        System.err.println(this);
//    }
//}