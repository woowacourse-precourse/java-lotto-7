package view.validator;

import java.util.ArrayList;
import java.util.List;
import model.lotto.Lotto;
import view.validator.bonus.BonusDuplicateValidator;
import view.validator.bonus.BonusNullValidator;
import view.validator.bonus.BonusNumberFormatValidator;
import view.validator.bonus.BonusRangeValidator;
import view.validator.money.MoneyNullValidator;
import view.validator.money.MoneyNumberFormatValidator;
import view.validator.money.MoneyUnitValidator;
import view.validator.money.MoneyZeroValidator;
import view.validator.winningNumber.WinningNumCountValidator;
import view.validator.winningNumber.WinningNumDuplicateValidator;
import view.validator.winningNumber.WinningNumNullValidator;
import view.validator.winningNumber.WinningNumNumberFormatValidator;
import view.validator.winningNumber.WinningNumRangeValidator;

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
