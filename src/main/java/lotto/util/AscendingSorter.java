package lotto.util;

import java.util.List;

public class AscendingSorter {
    public static List<Integer> run(List<Integer> list) {
        list.sort(Integer::compareTo);
        return list;
    }
}
