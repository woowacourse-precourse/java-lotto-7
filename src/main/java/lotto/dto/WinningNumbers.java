package lotto.dto;

import lotto.Utils.Convertor;
import lotto.validation.Validator;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> selectedNumbers;

    public WinningNumbers(String selectedNumbers) {
        this.selectedNumbers = Convertor.convert(selectedNumbers);
        validateNumbers();
    }

    private void validateNumbers() {
        Validator.validateDuplicatedNumbers(selectedNumbers);
        Validator.validateNumberCount(selectedNumbers);
        Validator.validateNegativeNumbers(selectedNumbers);
        Validator.validteNumbersInRange(selectedNumbers);
    }

    public int checkMatchingCount(List<Integer> numbers) {
        return  (int) numbers.stream()
                .filter(selectedNumbers::contains)
                .count();
    }
}
