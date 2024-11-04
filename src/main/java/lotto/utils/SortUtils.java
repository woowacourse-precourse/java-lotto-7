package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SortUtils {
    public static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> mutableList = new ArrayList<>(numbers);
        Collections.sort(mutableList);
        return mutableList;
    }
}

