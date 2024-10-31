package lotto.global.exception;

import java.util.function.Predicate;

public class ValidatorBuilder {
    private String inputValue;
    private int numericValue;

    private ValidatorBuilder(String StringValue) {
        this.inputValue = StringValue;
    }

    public static ValidatorBuilder from(String inputValue) {
        return new ValidatorBuilder(inputValue);
    }

    public ValidatorBuilder validateIsInteger() {
        try {
            numericValue = Integer.parseInt(inputValue);
            return this;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.NOT_INTEGER.message);
        }
    }

    public ValidatorBuilder validate(Predicate<Integer> condition, Exception exception) {
        if (!condition.test(numericValue)) {
            throw new IllegalArgumentException(exception.message);
        }
        return this;
    }

    public int get() {
        return this.numericValue;
    }

}
