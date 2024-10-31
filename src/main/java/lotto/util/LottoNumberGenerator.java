package lotto.util;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoNumberGenerator {
    public List<Integer> generate() {
        int minNumber = LottoConstant.MIN_NUMBER.getIntValue();
        int maxNumber = LottoConstant.MAX_NUMBER.getIntValue();
        int lottoSize = LottoConstant.LOTTO_SIZE.getIntValue();

        return pickUniqueNumbersInRange(minNumber, maxNumber, lottoSize).stream()
                .sorted()
                .toList();
    }
}
