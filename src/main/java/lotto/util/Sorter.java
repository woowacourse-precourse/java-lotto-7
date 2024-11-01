package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    private Sorter(){
    }

    public static List<Integer> ascendingOrder(final List<Integer> list) {
        List<Integer> mutableList = new ArrayList<>(list);
        Collections.sort(mutableList);
        return mutableList;
    }
}