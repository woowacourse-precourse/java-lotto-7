package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomBonusGenerator implements BonusNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public int generateNumber(List<Integer> lottoNumbers) {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
