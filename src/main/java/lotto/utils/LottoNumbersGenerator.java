package lotto.utils;

import static lotto.constant.LottoGameRule.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.NUMBER_OF_PICKS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    public static List<Integer> generate() {
        List<Integer> numbers = pickUniqueLottoNumbers();
        return sortNumbers(numbers);
    }

    private static List<Integer> pickUniqueLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), NUMBER_OF_PICKS.getValue());
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
