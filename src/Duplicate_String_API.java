import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicate_String_API {
    public static void main(String[] args) {
        String[] s = {"Java", "java", "Spring", "spring boot"};
        List<String> s1 = List.of("Java", "java");
        System.out.println(s1.stream().map(String :: toLowerCase).distinct().collect(Collectors.toList()));
        System.out.println(Arrays.stream(s).distinct().collect(Collectors.toList()));
    }
}
