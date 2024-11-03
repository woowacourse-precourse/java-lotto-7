package lotto.domain.lottoForm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoConstants.*;
import static lotto.message.ErrorMessage.*;

public abstract class LottoForm {

    protected List<Integer> validateAndSort(List<Integer> numbers) {
//        validateScope(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
        return numbers.stream().sorted().toList();
    }

//    private void validateScope(List<Integer> numbers) {
//        boolean result = numbers.stream()
//                .allMatch(number -> number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX);
//        if (!result) {
//            throw new IllegalArgumentException(LOTTO_SCOPE_ERROR.getMessage());
//        }
//    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
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
