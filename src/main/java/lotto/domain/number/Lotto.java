package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.constant.LottoRule;
import lotto.util.ListValidator;
import lotto.util.NumberValidator;

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
        final ListValidator<Integer> listValidator = ListValidator.getInstance();
        final NumberValidator<Integer> numberValidator = NumberValidator.getInstance();
        listValidator.validateSize(numbers, LottoRule.WINNING_NUMBER_SIZE)
                .validateRange(numbers,
                        number -> numberValidator.validateRange(number, LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER))
                .validateDuplicate(numbers);
    }

}
