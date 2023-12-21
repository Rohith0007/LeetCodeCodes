import java.util.HashMap;

public class Word_Pattern_290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr =s.split(" ");
        if(arr.length != pattern.length()) return false;
        HashMap<Character,String> h1=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            char ch=pattern.charAt(i);
            String word=arr[i];
            if(!h1.containsKey(ch))
            {
                if(h1.containsValue(word))
                {
                    return false;
                }
                h1.put(ch,word);

            }
            else if(!h1.get(ch).equals(word))
            {
                return false;
            }
        }
        return true;
    }
}
