package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.ArrayList;
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
        List<Integer> sortNumbers = new ArrayList<>(this.numbers);
        Collections.sort(sortNumbers);

        return sortNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Constants.DELIMITER_COMMA_SPACE));
    }
}
