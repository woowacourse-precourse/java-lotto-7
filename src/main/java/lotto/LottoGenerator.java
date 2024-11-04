package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * 로또번호를 생성한다
 */

public class LottoGenerator {
    private static final int LOTTO_NUM_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    public List<Integer> getWinnerNumberAndBonusNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUM_SIZE);
    }
}
