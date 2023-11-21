public class DecodeWays_91 {
    public int numDecodings(String s) {
        if(s.length() == 1 && s.charAt(0) == '0') {
            return 0;
        } else if(s.length() == 2) {
            if(s.charAt(0) == '0') {
                return 0;
            } else if(s.charAt(0) == '1' || s.charAt(0) == '2'){
                if(s.charAt(1) == '0') {
                    return 1;
                } if(s.charAt(0) == '2') {
                    if(s.charAt(1) == '7' || s.charAt(1) == '8' || s.charAt(1) == '9') {
                        return 0;
                    }
                }
                return 2;
            }
            return 1;
        } else {
            return helperClass(s, 0);
        }
    }

    public int helperClass(String s, float res) {
        if(s.length() == 1) {
            return (int) (2*res + 1);
        } else if(s.length() > 1) {
            String sub = s.substring(0,2);
            char c = sub.charAt(0);
            if(c != '0' && !sub.matches("/^(?!2)([0-9]|(?<=6)[0-9])$/")) {
                if(s.length()>2 && s.charAt(2) != '0') {
                    res += 1;
                } else {
                    res += 0.5;
                }
            }
            if(sub.equals("10") || sub.equals("20")) {
                return 1;
            }
            return helperClass(s.substring(2), res);
        } else {
            return (int) (2 * res);
        }
    }

    public static void main(String[] args) {
        DecodeWays_91 dw = new DecodeWays_91();
        System.out.println(dw.numDecodings("2101"));
    }
}
