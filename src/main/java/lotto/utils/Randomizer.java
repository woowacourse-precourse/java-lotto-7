package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.models.constants.LottoValues;

import java.util.List;

public class Randomizer {
    public static List<Integer> getRandomLottoNumbers() {
        int startInclusive = LottoValues.MIN_NUMBER.getValue();
        int endInclusive = LottoValues.MAX_NUMBER.getValue();
        int count = LottoValues.LOTTO_SIZE.getValue();
        List<Integer> randomValues = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        return randomValues.stream().sorted().toList();
    }
}
