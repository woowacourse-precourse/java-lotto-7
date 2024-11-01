package lotto.model.match;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetBasedLottoNumbersMatchCounter<T extends Integer> implements MatchCounter<T> {

    @Override
    public int countMatches(List<T> list1, List<T> list2) {
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }
}
