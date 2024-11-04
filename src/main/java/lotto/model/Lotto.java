package lotto.model;

import static lotto.util.validator.LottoNumberValidator.validateDuplicated;
import static lotto.util.validator.LottoNumberValidator.validateNumberCount;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicated(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().toList();
    }

    public Boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public LottoRank checkRank(final List<Integer> winningNumber, final Integer bonusNumber) {
        int sameNumberCounts = countSameNumber(winningNumber);

        return LottoRank.findRank(sameNumberCounts, isSecondRank(sameNumberCounts, bonusNumber));
    }

    Integer countSameNumber(final List<Integer> winningNumber) {
        return numbers.stream()
                .filter(winningNumber::contains)
                .map(number -> 1)
                .reduce(0, Integer::sum);
    }

    Boolean isSecondRank(Integer sameNumberCounts, Integer bonusNumber) {
        return sameNumberCounts == 5 && this.contains(bonusNumber);
    }
}
