package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoSortService {

    public List<List<Integer>> sortLottos(List<Lotto> lottos) {
        List<List<Integer>> sortedNumbers = new ArrayList<>();

        for (Lotto lotto : lottos) {
            sortedNumbers.add(lotto.sortedNumbers());
        }

        return sortedNumbers;
    }
}
