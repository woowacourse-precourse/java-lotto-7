package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortLottoNumberService {
    public static List<Integer> sortLottoNumber(List<Integer> lotto) {
        List<Integer> sortedLotto = new ArrayList<>(lotto);
        Collections.sort(sortedLotto);
        return sortedLotto;
    }
}
