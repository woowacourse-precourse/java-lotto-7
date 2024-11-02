package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoPublisher {

    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_NUMBERS_COUNT = 6;

    private List<List<Integer>> publishedLotto = new ArrayList<>();
    private List<Integer> publishedBonusLotto = new ArrayList<>();

    public LottoPublisher(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                    LOTTO_NUMBERS_COUNT);
            Collections.sort(lotto);
            publishedLotto.add(lotto);
        }
        publishedBonusLotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER,repeatCount);
    }

    public List<List<Integer>> getPublishedLotto() {
        return publishedLotto;
    }

    public List<Integer> getPublishedBonusLotto() {
        return publishedBonusLotto;
    }
}
