package lotto.viewHandler.validator.validatorImpl;

import lotto.viewHandler.validator.Validator;

public class RemoveWhiteSpace implements Validator<String, String> {
    private static final String SPACE = " ";

    @Override
    public String validate(String input) {
        if (input.startsWith(SPACE)) {
            return input.stripLeading();
        }
        return input;
    }
}
