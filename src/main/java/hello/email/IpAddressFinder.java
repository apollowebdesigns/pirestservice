//package hello.email;
//
//import java.io.*;
//
//public class IpAddressFinder {
//
//    private static IpAddressFinder instance = new IpAddressFinder();
//
//    private IpAddressFinder() {
//
//    }
//
//    public static IpAddressFinder getInstance() {
//        return instance;
//    }
//
//    public void test() {
//
//        String s = null;
//
//        try {
//            Process p = Runtime.getRuntime().exec("dig TXT +short o-o.myaddr.l.google.com @ns1.google.com | awk");
//
//            BufferedReader stdInput = new BufferedReader(new
//                    InputStreamReader(p.getInputStream()));
//
//            BufferedReader stdError = new BufferedReader(new
//                    InputStreamReader(p.getErrorStream()));
//
//            // read the output from the command
//            System.out.println("Here is the standard output of the command:\n");
//            while ((s = stdInput.readLine()) != null) {
//                System.out.println(s);
//            }
//
//            // read any errors from the attempted command
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((s = stdError.readLine()) != null) {
//                System.out.println(s);
//            }
//        }
//        catch (IOException e) {
//            System.out.println("exception happened - here's what I know: ");
//            e.printStackTrace();
//            System.exit(-1);
//        }
//    }
//}