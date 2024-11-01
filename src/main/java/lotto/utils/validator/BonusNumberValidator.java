package lotto.utils.validator;

import java.util.List;

import static lotto.exception.ErrorMessages.NUMBER_DUPLICATION;

public class BonusNumberValidator implements ComparisonValidator {
    private final Validator<String> positiveIntValidator;
    private final Validator<Integer> lottoNumberValidator;

    public BonusNumberValidator(
            Validator<String> positiveIntValidator
            , Validator<Integer> lottoNumberValidator ){

        this.positiveIntValidator = positiveIntValidator;
        this.lottoNumberValidator = lottoNumberValidator;
    }

    @Override
    public void validateWithComparison(String rawBonusNumber,  List<Integer> winningNumbers){
        validate(rawBonusNumber);
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        validateNoDuplication( bonusNumber, winningNumbers);
    }

    @Override
    public void validate(String rawBonusNumber) {

        positiveIntValidator.validate(rawBonusNumber);

        int bonusNumber = Integer.parseInt(rawBonusNumber);

        lottoNumberValidator.validate(bonusNumber);
    }

    private static void validateNoDuplication(
            int bonusNumber
            ,List<Integer> winningNumbers) {

        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(String.format(NUMBER_DUPLICATION.getMessage(), bonusNumber));
        }

    }
}
