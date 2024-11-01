package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.LottoConstants;

public class LottoNumberGenerator {

    private static final int NUMBER_COUNT = LottoConstants.NUMBER_COUNT.getValue();
    private static final int MAX_NUMBER = LottoConstants.MAX_NUMBER.getValue();
    private static final int MIN_NUMBER = LottoConstants.MIN_NUMBER.getValue();

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
}
