package lotto.service;

import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;
import static lotto.constant.LottoConstant.SIZE_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersSelector implements NumbersSelector {

    @Override
    public List<Integer> select() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE_NUMBERS);
    }
}
