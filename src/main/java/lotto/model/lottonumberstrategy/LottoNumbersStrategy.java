package lotto.model.lottonumberstrategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersStrategy implements NumberGeneratorStrategy {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = pickUniqueRandomNumbers();
        return sortNumbers(numbers);
    }

    private List<Integer> pickUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }
}
