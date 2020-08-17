import java.util.ArrayList;
import java.util.Iterator;
/*
* 给定一串字符串，输出其中的IP地址
* */

public class IpUtil {
    public static ArrayList<String> strings = new ArrayList<>();
    public static boolean finished = false;
    public static ArrayList<String> validateIp = new ArrayList<>();

    public static void main(String[] args) {
        String inputStr = "rer2.32r.3.rewr534.t5re.5t.2.3.6.8.retre6t6tewr.tre6t.et662tret3.2365.23..216.r.218.33.23.0.23.2.21.tret520tret056tre";
        IpUtil ipUtil = new IpUtil();
        String[] split = inputStr.split("\\.");
        for (int i = 0; i < split.length; i++) {
            try {
                Integer integer = Integer.valueOf(split[i]);
                if (0 <= integer && integer <= 255) {
                    strings.add(String.valueOf(integer));
                }

                if (strings.size() == 4) {
                    ipUtil.format();
                    ipUtil.resetConfig();
                }
            } catch (NumberFormatException e) {
                ipUtil.resetConfig();
            }
        }
        System.out.println(validateIp);

    }

    public void resetConfig() {
        finished = false;
        strings.clear();
    }

    public void format() {
        StringBuffer ip =  new StringBuffer();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            ip.append(next).append(".");
        }
        validateIp.add(ip.substring(0,ip.length()-1));
    }
}
