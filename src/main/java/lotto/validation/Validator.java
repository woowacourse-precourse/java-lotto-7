package lotto.validation;

import java.util.List;

public interface Validator {
    int validate(String input);
    int parseInput(String input);
    void winningNumbers(List<Integer> winningNumbers);
    void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers);
}
