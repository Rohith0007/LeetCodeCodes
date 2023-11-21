class ZigZag {
    public static void main(String[] args) {
        ZigZag zg = new ZigZag();
        System.out.println(zg.convert("PAYPALISHIRING", 4));
    }
    public String convert(String s, int numRows) {
        StringBuilder s1 = new StringBuilder();
        int len = s.length();
        int skip = (numRows * 2)  - 2;
        int k;
        for(int i=0; i<numRows; i++) {
            if(i==0 || i==numRows-1) {
                k = i;
                while(k<len) {
                    s1.append(s.charAt(k));
                    k = k + skip;
                }
            } else {
                k = i;
                while(k<len) {
                    s1.append(s.charAt(k));
                    k = k + (numRows-i-1)*2;
                    if(k < len) {
                        s1.append(s.charAt(k));
                    }
                    k = k + i*2;
                }
            }
        }
        return s1.toString();
    }
}