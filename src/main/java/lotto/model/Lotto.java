package lotto.model;

import java.util.List;
import lotto.model.exception.DomainExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream().distinct().count();
        if (distinctNumberCount != numbers.size()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage()
            );
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_LOTTO_SIZE.getMessage()
            );
        }
    }

    public WinningType match(AnswerNumbers answer, BonusNumber bonusNumber) {
        int matchCount = match(answer);
        boolean matchBonus = matchBonus(bonusNumber);
        return WinningType.of(matchCount, matchBonus);
    }

    private int match(AnswerNumbers answer) {
        return (int)answer.getAnswerNumbers().stream()
                .map(LottoNumber::getNumber)
                .filter(numbers::contains)
                .count();
    }

    private boolean matchBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

}
