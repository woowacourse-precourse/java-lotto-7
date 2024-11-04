package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.Constants;

public class LottoFactory {
    private int lottoCount;
    private final Lottos lottos;

    public LottoFactory(int lottoCount, Lottos lottos) {
        this.lottoCount = lottoCount;
        this.lottos = lottos;

        createLottos();
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Constants.RANDOM_MIN_NUM,
                Constants.RANDOM_MAX_NUM,
                Constants.LOTTO_NUMBER_COUNT);
        return randomNumbers;
    }

    private void createLottos() {
        for(int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lottos.addLotto(lotto);
        }
    }
}
