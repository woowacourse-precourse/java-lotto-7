package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers
                = Randoms.pickUniqueNumbersInRange(Lotto.RANDOM_LOWER_BOUND, Lotto.RANDOM_UPPER_BOUND, Lotto.NUMBER_OF_LOTTO);

        return lottoNumbers.stream().sorted().toList();
    }

}
