package lotto.utils.validator;

import java.util.Collections;
import java.util.List;

import static lotto.exception.ErrorMessages.NUMBER_DUPLICATION;

public class BonusNumberValidator implements Validator<String> {
    private final Validator<String> positiveIntValidator;
    private final Validator<Integer> lottoNumberValidator;
    private final List<Integer> winningNumbers;

    public BonusNumberValidator(
            Validator<String> positiveIntValidator
            , Validator<Integer> lottoNumberValidator
            , List<Integer> winningNumbers) {

        this.positiveIntValidator = positiveIntValidator;
        this.lottoNumberValidator = lottoNumberValidator;
        this.winningNumbers = Collections.unmodifiableList(winningNumbers); //불변성 확보
    }

    @Override
    public void validate(String rawBonusNumber) {

        positiveIntValidator.validate(rawBonusNumber);

        int bonusNumber = Integer.parseInt(rawBonusNumber);

        lottoNumberValidator.validate(bonusNumber);
        validateNoDuplication(bonusNumber, winningNumbers);
    }

    private static void validateNoDuplication(
            int bonusNumber
            ,List<Integer> winningNumbers) {

        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(String.format(NUMBER_DUPLICATION.getMessage(), bonusNumber));
        }

    }
}
