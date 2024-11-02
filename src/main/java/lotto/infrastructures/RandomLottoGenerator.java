package lotto.infrastructures;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.constant.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoCreator;
import lotto.domain.LottoGenerator;

public class RandomLottoGenerator implements LottoGenerator {

    private final LottoCreator lottoCreator;

    public RandomLottoGenerator(LottoCreator lottoCreator) {
        this.lottoCreator = lottoCreator;
    }

    @Override
    public Lotto generateLotto() {
        List<Integer> randomNumbers = makeRandomNumber();
        return lottoCreator.createLotto(randomNumbers);
    }

    private List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_SIZE);
    }
}
