package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoInfo.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoInfo.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoInfo.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = generateRandomLottoNumbers();
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDistinction(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateDistinction(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public List<String> toSortedStrings() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .toList();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatch(Lotto toCheck) {
        return (int) numbers.stream()
                .filter(toCheck::contains)
                .count();
    }
}
