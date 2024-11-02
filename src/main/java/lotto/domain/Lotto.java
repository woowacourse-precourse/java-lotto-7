package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER = LottoRule.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = LottoRule.MAX_NUMBER.getValue();
    private static final int NUMBER_COUNT = LottoRule.NUMBER_COUNT.getValue();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", NUMBER_COUNT));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getMatchNumberCount(List<Integer> numbers) {
        List<Integer> matchingNumbers = new ArrayList<>(numbers);
        matchingNumbers.retainAll(this.numbers);

        return matchingNumbers.size();
    }

    public Boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }

    public static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
}
