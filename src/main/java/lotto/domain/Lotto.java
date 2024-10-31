package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.util.LottoListValidator;
import lotto.util.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        lottoNumbers.sort(Comparator.naturalOrder());
        this.numbers = lottoNumbers;
    }

    public boolean isContainsNumber(final int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        final LottoListValidator lottoListValidator = new LottoListValidator();
        final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        lottoListValidator.validateSize(numbers)
                .validateRange(numbers, number -> lottoNumberValidator.validateRange(number, 1, 45))
                .validateDuplicate(numbers);
    }

}
