package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class LottoGeneratorImpl implements LottoGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER, LottoConstants.LOTTO_MAX_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT).stream()
                .toList();
        return lottoNumbers;
    }
}
