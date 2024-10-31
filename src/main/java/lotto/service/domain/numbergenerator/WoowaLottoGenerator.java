package lotto.service.domain.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class WoowaLottoGenerator implements RandomNumberGenerator {
    private static final int LOTTO_MIN_RANGE = 1;
    private static final int LOTTO_MAX_RANGE = 45;
    private static final int PICK_UNIQUE_SIX = 6;

    @Override
    public int makeLottoBonusNumber() {
        return Randoms.pickNumberInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE);
    }

    @Override
    public List<Integer> makeLottoRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, PICK_UNIQUE_SIX);
    }
}
