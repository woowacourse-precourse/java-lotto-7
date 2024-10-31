package lotto.domain.numberlotto.lotto;

import lotto.domain.numberlotto.constants.value.LottoRule;
import lotto.domain.numberlotto.constants.message.InputError;
import lotto.domain.numberlotto.constants.message.RangeError;

import java.util.HashSet;
import java.util.List;

public abstract class NumberCombination {

    protected void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoRule.COMBINATION_LENGTH.getValue()) {
            System.out.println(RangeError.LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }

    protected void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            System.out.println(InputError.DUPLICATE_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
