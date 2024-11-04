package lotto;

import java.util.Collections;
import java.util.List;
import lotto.common.LottoNumbers;
import lotto.exception.LottoArgumentException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(final List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicatedNumbers(numbers);
    }

    private void validateSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LottoNumbers.SIZE.get()) {
            throw new LottoArgumentException("로또 번호는 " + LottoNumbers.SIZE.get() + "개여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(final List<LottoNumber> numbers) {
        final Long elementCount = numbers.stream()
                .distinct()
                .count();
        if (elementCount != numbers.size()) {
            throw new LottoArgumentException("로또 번호는 중독되어선 안됩니다.");
        }
    }

    public boolean containsNumber(final LottoNumber number) {
        return this.numbers.contains(number);
    }

    protected List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }
}
