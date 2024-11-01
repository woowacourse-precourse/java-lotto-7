package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {
    private List<Integer> publisheddLotto = new ArrayList<>();

    public LottoPublisher() {
        publisheddLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getPublishedNumbers() {
        return publisheddLotto;
    }
}
