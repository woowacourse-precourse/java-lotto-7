package lotto.controller.util;

import java.util.function.Supplier;
import lotto.validator.Validator;
import lotto.view.OutputView;

public class InputValidatorUtil {

    public static String inputValidate(Supplier<String> inputSupplier, Validator validator) {
        while (true) {
            try {
                String input = inputSupplier.get();
                validator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printException(e.getMessage());
            }
        }
    }
}
