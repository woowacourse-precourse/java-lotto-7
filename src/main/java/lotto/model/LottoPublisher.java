package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPublisher {

    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_NUMBERS_COUNT = 6;

    private List<List<Integer>> publishedLotto = new ArrayList<>();

    public LottoPublisher(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_COUNT);
            lotto = lotto.stream().sorted().collect(Collectors.toList());
            publishedLotto.add(lotto);
        }
    }

    public List<List<Integer>> getPublishedLotto() {
        return publishedLotto;
    }

}
