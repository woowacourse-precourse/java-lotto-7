package lotto.service;

import java.util.Comparator;
import java.util.List;

public class SortLottoNumberService {
    public List<Integer> sortLottoNumber(List<Integer> lotto) {
        lotto.sort(Comparator.naturalOrder());
        return lotto;
    }
}
