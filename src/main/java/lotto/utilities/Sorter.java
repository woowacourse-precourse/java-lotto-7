package lotto.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static List<Integer> inAscendingOrder(List<Integer> listOfLottoNumbers) {
        List<Integer> mutableList = new ArrayList<>(listOfLottoNumbers);
        Collections.sort(mutableList);
        return mutableList;
    }
}
