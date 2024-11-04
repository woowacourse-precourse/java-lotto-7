package lotto.application.validation;

import java.util.List;

public interface BonusNumberValidation extends BaseValidation<Integer> {

    Integer validateBonusNumber(String input, List<Integer> winningNumbers);

    int parseNumber(String input);

    void validateBonusNumberRange(int bonusNumber);

    void validateNoOverlap(int bonusNumber, List<Integer> winningNumbers);
}
