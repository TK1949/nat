package upnp;

public class UPnPBoot {

    public static void main(String[] args) {

        boolean upnpAvailable = UPnP.isUPnPAvailable();
        System.out.print("UPnPAvailable\t->\t");
        System.out.println(upnpAvailable);

        String localIP = UPnP.getLocalIP();
        System.out.print("LocalIP\t->\t");
        System.out.println(localIP);

        String externalIP = UPnP.getExternalIP();
        System.out.print("ExternalIP\t->\t");
        System.out.println(externalIP);

        for (int port = 20000; port <= 25000; port++) {

            boolean openPortUDP = UPnP.openPortUDP(port);
            if (openPortUDP) {
                System.out.print("OpenPortUDP\t->\t");
                System.out.print(openPortUDP);
                System.out.print(",\tport\t->\t");
                System.out.println(port);
            }

            boolean openPortTCP = UPnP.openPortTCP(port);
            if (openPortTCP) {
                System.out.print("OpenPortTCP\t->\t");
                System.out.print(openPortTCP);
                System.out.print(",\tport\t->\t");
                System.out.println(port);
            }
        }
    }
}