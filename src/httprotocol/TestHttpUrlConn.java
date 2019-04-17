package httprotocol;

import java.net.*;
import java.util.Enumeration;

public class TestHttpUrlConn {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress inetAddress = addresses.nextElement();
                    if (((inetAddress instanceof Inet4Address))) {
                        System.out.println(inetAddress.getHostAddress());
                        System.out.println("canonical:" + inetAddress.getCanonicalHostName());
                        System.out.println("hostName:" + inetAddress.toString());
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }

        System.out.println(System.getenv().get("JAVALOCALMCHIP"));
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
