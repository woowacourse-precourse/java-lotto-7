package lotto.system.lottoGetter;

import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.system.unit.LottoNumber;

public class LottoGenerator {

    protected static List<LottoNumber> generateUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND, LOTTO_NUMBER_COUNT)
                .stream()
                .map(LottoNumber::of)
                .sorted()
                .collect(Collectors.toList());
    }
}