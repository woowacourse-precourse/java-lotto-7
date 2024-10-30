package lotto.utils.parser;

import java.util.List;
import lotto.utils.validator.BonusNumberValidator;

public class BonusNumberParser {
    private final BonusNumberValidator validator;

    public BonusNumberParser(BonusNumberValidator validator) {
        this.validator = validator;
    }

    public int parse(String userInput, List<Integer> winningNumbers) {
        validator.validate(userInput);

        int bonusNumber = Integer.parseInt(userInput);
        validator.validateNumberInRange(bonusNumber);
        validator.validateDuplicateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }
}
