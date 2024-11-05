package lotto.model;

import static lotto.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean containsBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }

    public String formatNumbers() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
