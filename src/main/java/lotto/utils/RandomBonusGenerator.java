package lotto.utils;

import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomBonusGenerator implements BonusNumberGenerator {
    @Override
    public int generateNumber(List<Integer> lottoNumbers) {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
