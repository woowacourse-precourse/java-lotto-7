package lotto;

import java.util.Comparator;
import lotto.domain.prizelotto.PrizeLotto;

public class SortComparator implements Comparator<PrizeLotto> {
    @Override
    public int compare(PrizeLotto o1, PrizeLotto o2) {
        return o2.getRank() - o1.getRank();
    }
}
