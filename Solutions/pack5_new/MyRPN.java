package Solutions.pack5_new;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            System.out.println(t);
        }
        return 0.0;
    }
    
}

