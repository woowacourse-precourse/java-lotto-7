package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static List<Integer> sort(List<Integer> list) {
        List<Integer> mutableList = new ArrayList<>(list);
        Collections.sort(mutableList);
        return mutableList;
    }
}
