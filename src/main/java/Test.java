import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        List<String> list2 = Arrays.asList("banana", "kiwi");

        list1.retainAll(list2);
        System.out.println(list1); // [banana] (list1과 list2의 교집합)


    }
}
