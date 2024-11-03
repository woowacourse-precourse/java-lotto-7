package lotto.validate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoValidate {

    public static boolean isNotDuplicateNumber(List<Integer> list) {
        List<Integer> ascendingList = new ArrayList<>(list);
        HashSet<Integer> set = new HashSet<>(ascendingList);

        return set.size() == 6;
    }
}
