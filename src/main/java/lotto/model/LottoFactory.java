package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.Constants;

public class LottoFactory {
    private int lottoCount;

    public LottoFactory(int lottoCount) {
        this.lottoCount = lottoCount;

        for(int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
        }
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Constants.RANDOM_MIN_NUM,
                Constants.RANDOM_MAX_NUM,
                Constants.LOTTO_NUMBER_COUNT);
        return randomNumbers;
    }
}
