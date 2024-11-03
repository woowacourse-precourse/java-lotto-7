package lotto.domain.lottoForm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.LottoValues.LOTTO_SIZE;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;

public abstract class LottoForm {

    protected List<Integer> validateAndSort(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        return numbers.stream().sorted().toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.value()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }
}
