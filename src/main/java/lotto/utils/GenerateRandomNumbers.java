package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.LottoRange.*;

public class GenerateRandomNumbers {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_RANGE.getValue(),
                MAX_LOTTO_RANGE.getValue(),
                LOTTO_SIZE.getValue());
    }
}
