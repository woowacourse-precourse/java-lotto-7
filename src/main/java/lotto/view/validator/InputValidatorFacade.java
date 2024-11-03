package lotto.view.validator;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.view.validator.bonus.BonusDuplicateValidator;
import lotto.view.validator.bonus.BonusNullValidator;
import lotto.view.validator.bonus.BonusNumberFormatValidator;
import lotto.view.validator.bonus.BonusRangeValidator;
import lotto.view.validator.money.MoneyNullValidator;
import lotto.view.validator.money.MoneyNumberFormatValidator;
import lotto.view.validator.money.MoneyUnitValidator;
import lotto.view.validator.money.MoneyZeroValidator;
import lotto.view.validator.winningNumber.WinningNumCountValidator;
import lotto.view.validator.winningNumber.WinningNumDuplicateValidator;
import lotto.view.validator.winningNumber.WinningNumNullValidator;
import lotto.view.validator.winningNumber.WinningNumNumberFormatValidator;
import lotto.view.validator.winningNumber.WinningNumRangeValidator;

public class InputValidatorFacade {

    private InputValidatorFacade() { }

    public static void moneyValidators(final String input) {
        List<InputValidator> validators = new ArrayList<>();

        validators.add(MoneyNullValidator.initiate());
        validators.add(MoneyNumberFormatValidator.initiate());
        validators.add(MoneyZeroValidator.initiate());
        validators.add(MoneyUnitValidator.initiate());

        validateAll(validators, input);
    }

    public static void winningNumValidators(final String input) {
        List<InputValidator> validators = new ArrayList<>();

        validators.add(WinningNumNullValidator.initiate());
        validators.add(WinningNumNumberFormatValidator.initiate());
        validators.add(WinningNumCountValidator.initiate());
        validators.add(WinningNumRangeValidator.initiate());
        validators.add(WinningNumDuplicateValidator.initiate());

        validateAll(validators, input);
    }

    public static void bonusValidators(final String input, final Lotto lotto) {

        List<InputValidator> validators = new ArrayList<>();

        validators.add(BonusNullValidator.initiate());
        validators.add(BonusNumberFormatValidator.initiate());
        validators.add(BonusRangeValidator.initiate());
        validators.add(BonusDuplicateValidator.initiate(lotto));

        validateAll(validators, input);
    }

    private static void validateAll(List<InputValidator> validators, String input) {
        validators.forEach(validator -> validator.validate(input));
    }
}
