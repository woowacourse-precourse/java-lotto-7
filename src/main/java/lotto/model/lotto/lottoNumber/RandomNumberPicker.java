package lotto.model.lotto.lottoNumber;

import static lotto.model.lotto.lottoNumber.LotteryRule.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberPicker implements NumberPicker {
    @Override
    public List<Integer> pick() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, LOTTERY_NUMBER_COUNT);
    }
}
