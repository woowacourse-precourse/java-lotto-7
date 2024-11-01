package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_NUMBERS_COUNT = 6;

    private List<Integer> publisheddLotto = new ArrayList<>();

    public LottoPublisher() {
        publisheddLotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_COUNT);
    }

    public List<Integer> getPublishedNumbers() {
        return publisheddLotto;
    }
}
