import java.util.*;
public class lever {

    private Map<String, Integer> map;

    public lever() {
        map = new HashMap<>();
        map.put("foo", 1);
        map.put("bar", 3);
    }

    public int getValue(String input, int numRetries) throws Exception {
        try {
            return map.get(input);
        }
        catch (Exception e) {
            if (numRetries > 3) {
                throw e;
            }
            return getValue(input, numRetries + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        lever mc = new lever();
        mc.getValue("foo", 0);
        mc.getValue("bar", 2);
//        mc.getValue("baz", 0);
        mc.getValue("fubar", 1);
    }
}