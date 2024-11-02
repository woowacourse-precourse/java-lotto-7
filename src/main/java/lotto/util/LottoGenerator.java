package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoGenerator {

    private static final int RANDOM_LOWER_BOUND = 1;
    private static final int RANDOM_UPPER_BOUND = 45;

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers
                = Randoms.pickUniqueNumbersInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND, Lotto.NUMBER_OF_LOTTO);

        return lottoNumbers.stream().sorted().toList();
    }

}
