import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zillow{

public static void main(String[] args) {
    List<String> savedSearches = new ArrayList<>();
    savedSearches.add("/SanFrancisco,CA/1230_2500_sft");
    savedSearches.add("/SanFrancisco,CA/1400_1550_sft");
    savedSearches.add("/SanFrancisco,CA/1550_sft");
    savedSearches.add("/Austin.TX/2000_2500_sft");
    System.out.println(match_saved_search(123, "SanFrancisco", "CA", 1450, 50000000, "Condo", savedSearches));
}
public static List<String> match_saved_search(int property_id, String property_city, String property_state, int property_sft, int property_price, String property_type, List<String> saved_searches) {
        List<String> result = new ArrayList<String>() ;
        for (String s1 : saved_searches) {
            boolean flag = checkifPropertyExists(s1, property_city, property_state, property_sft);
            if (flag) {
                result.add(s1);
            }
        }
        return result;
}

public static boolean checkifPropertyExists(String s1,String property_city,String property_state, int property_sft) {
        String parts[]=s1.split("/");
        String citystate[]=parts[1].split(",");
        String sft[]=parts[2].split("_");
        int sft_lo=Integer.valueOf(sft[0]);
        int sft_hi;
        if(Objects.equals(sft[1], "sft")) {
            sft_hi = sft_lo;
        } else {
            sft_hi=Integer.parseInt(sft[1]);
        }
        if (citystate[0].equals(property_city) && citystate[1].equals(property_state) && property_sft > sft_lo && property_sft < sft_hi) {
            return true;
        }
        return false;
    }
}
