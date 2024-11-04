package lotto.model;

import static lotto.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_SIZE);
    }
}
