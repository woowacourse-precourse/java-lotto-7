package lotto.model.evaluate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersMatchCounter {

    public int countMatches(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }
}
