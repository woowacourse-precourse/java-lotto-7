package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.utils.Constants;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        return new Lotto(generateRandomNumbers());
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUMBER,
                Constants.LOTTO_MAX_NUMBER,
                Constants.LOTTO_NUMBER_LENGTH
        );
    }
}
