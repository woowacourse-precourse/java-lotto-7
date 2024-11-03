package lotto.io.validator;

import static java.util.Objects.nonNull;

public class InputValidator {

    private InputValidator next;

    public InputValidator doChain(final InputValidator validator) {
        this.next = validator;
        return validator;
    }

    public void check(final String source) {
        if (nonNull(next)) {
            next.check(source);
        }
    }
}
