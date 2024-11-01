package lotto;

import java.util.Collections;
import java.util.List;
import lotto.common.LottoNumber;
import lotto.exception.LottoArgumentException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LottoNumber.SIZE.getNumber()) {
            throw new LottoArgumentException("로또 번호는 " + LottoNumber.SIZE.getNumber() + "개여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(final List<Integer> numbers) {
        final Long elementCount = numbers.stream()
                .distinct()
                .count();
        if (elementCount != numbers.size()) {
            throw new LottoArgumentException("로또 번호는 중독되어선 안됩니다.");
        }
    }

    private void validateNumberRange(final List<Integer> range) {
        final boolean outOfRange = range.stream()
                .anyMatch(number -> number < LottoNumber.START.getNumber() || number > LottoNumber.END.getNumber());
        if (outOfRange) {
            throw new LottoArgumentException("로또 숫자 범위를 벗어났습니다.");
        }
    }

    public boolean containsNumber(final int number) {
        return this.numbers.contains(number);
    }

    protected List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }
}
