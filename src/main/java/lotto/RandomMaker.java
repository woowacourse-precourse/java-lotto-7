package lotto;

import static lotto.LottoConstants.MAX_RANDOM_NUMBER;
import static lotto.LottoConstants.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomMaker {
    public static List<Integer> generateLottoNumbers(int count) {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, count));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}