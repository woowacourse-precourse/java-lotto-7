package lotto.Config;
import lotto.Validator.InputValidator;

public class ValidatorFactory {
    public static InputValidator getInputValidator() {
        return new InputValidator();
    }
}
