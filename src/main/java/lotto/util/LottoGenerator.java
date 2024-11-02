package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.RANDOM_LOWER_BOUND,
                LottoConstants.RANDOM_UPPER_BOUND,
                LottoConstants.NUMBER_OF_LOTTO
        );
        return lottoNumbers.stream().sorted().toList();
    }
}
