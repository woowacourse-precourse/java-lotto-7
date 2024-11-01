package lotto.io.validator.money;

import static java.util.Objects.nonNull;

public class InputValidator {

    private InputValidator next;

    public InputValidator doChain(InputValidator validator) {
        this.next = validator;
        return validator;
    }

    public void check(String source) {
        if (nonNull(next)) {
            next.check(source);
        }
    }
}
