package view.validator;

import java.util.ArrayList;
import java.util.List;
import view.validator.money.MoneyNullValidator;
import view.validator.money.MoneyNumberFormatValidator;
import view.validator.money.MoneyUnitValidator;
import view.validator.money.MoneyZeroValidator;

public class InputValidatorFacade {

    private InputValidatorFacade() { }

    public static void MoneyValidators(final String input) {
        List<InputValidator> validators = new ArrayList<InputValidator>();

        validators.add(MoneyNullValidator.initiate());
        validators.add(MoneyNumberFormatValidator.initiate());
        validators.add(MoneyZeroValidator.initiate());
        validators.add(MoneyUnitValidator.initiate());

        validateAll(validators, input);
    }

    private static void validateAll(List<InputValidator> validators, String input) {
        validators.forEach(validator -> validator.validate(input));
    }
}
