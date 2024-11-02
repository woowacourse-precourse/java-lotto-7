package lotto.validator;

import lotto.view.Outputs;

public abstract class Validator {

    abstract void validate();

    String combineMessages(String message) {
        return String.join(Outputs.SPACE.getMessage(),
                Errors.ERROR.getMessage(),
                message,
                Errors.NUMBER_REQUEST.getMessage());
    }
}
