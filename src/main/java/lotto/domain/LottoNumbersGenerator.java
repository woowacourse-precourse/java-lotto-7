package lotto.domain;

import static lotto.domain.LottoInfo.END_NUMBER;
import static lotto.domain.LottoInfo.PICK_COUNT;
import static lotto.domain.LottoInfo.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class LottoNumbersGenerator {

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
