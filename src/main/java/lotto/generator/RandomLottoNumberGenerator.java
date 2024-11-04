package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class RandomLottoNumberGenerator implements RandomValueGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER, LottoConstants.LOTTO_MAX_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .toList();
    }
}
