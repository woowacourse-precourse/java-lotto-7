package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SystemLotto {
    private final List<Integer> numbers;

    public SystemLotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_NUMBER_COUNT);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getSortedNumbers() {
        Collections.sort(numbers);

        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Constants.DELIMITER_COMMA));
    }
}
