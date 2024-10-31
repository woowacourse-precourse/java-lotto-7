package lotto.global.exception;

import java.util.List;
import java.util.function.Predicate;

public class ValidatorBuilder {
    private String inputValue;
    private int numericValue;
    private List<Integer> numericValues;

    private ValidatorBuilder(String StringValue) {
        this.inputValue = StringValue;
    }

    public ValidatorBuilder(List<Integer> inputValues) {
        this.numericValues = inputValues;
    }

    public static ValidatorBuilder from(String inputValue) {
        return new ValidatorBuilder(inputValue);
    }

    public static ValidatorBuilder from(List<Integer> inputValues) {
        return new ValidatorBuilder(inputValues);
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
        if (condition.test(numericValue)) {
            throw new IllegalArgumentException(exception.message);
        }
        return this;
    }

    public ValidatorBuilder validateGroup(Predicate<List<Integer>> condition, Exception exception) {
        if (condition.test(numericValues)) {
            throw new IllegalArgumentException(exception.message);
        }
        return this;
    }

    public int get() {
        return this.numericValue;
    }

    public List<Integer> gets() {
        return this.numericValues;
    }

}
