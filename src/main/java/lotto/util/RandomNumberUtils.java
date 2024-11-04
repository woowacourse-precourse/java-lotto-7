package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.constants.LottoNumbers.*;

public class RandomNumberUtils {
    public static List<Integer> getRandomNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
        setAscendingNumbers(numbers);
        return numbers;
    }

    public static void setAscendingNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

}
