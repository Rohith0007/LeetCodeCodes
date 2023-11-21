
import java.util.*;
public class Pascals_Triangle_II_109 {

    public static void main(String[] args) {
        Pascals_Triangle_II_109 p = new Pascals_Triangle_II_109();
        System.out.println(p.getRow(6));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(1);
        int len = res.size();

        if(rowIndex == 0) {
            return res;
        }

        for(int i =1; i< rowIndex+1; i++) {
            for(int j = 0; j<i+1; j++) {
                if(j == 0){
                    temp.add(res.get(0));
                } else if(j == res.size()){
                    temp.add(res.get(len-1));
                } else{
                    temp.add(res.get(j-1) + res.get(j));
                }
            }
            res.clear();
            for (int k = 0; k<temp.size(); k++) {
                res.add(temp.get(k));
            }
            temp.clear();
        }

        return res;
    }
}
