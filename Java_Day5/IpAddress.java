import java.util.regex.*;
public class IpAddress {
    public static boolean validation(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
                     + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);   
        return matcher.matches();
    }
    public static void main(String[] args) {
        String[] testIPs = {"192.168.0.1", "255.255.255.255", "256.100.50.0", "192.168.1", "01.02.03.04"};
        for (String ip : testIPs) {
            System.out.println(ip + " --> " + (validation(ip) ? "Valid" : "Invalid"));
        }
    }
}
