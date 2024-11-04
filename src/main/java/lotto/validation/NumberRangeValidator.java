package lotto.validation;

public class NumberRangeValidator implements Validator<Integer> {
    private final int min;
    private final int max;
    private final String errorMessage;

    public NumberRangeValidator(int min, int max, String errorMessage) {
        this.min = min;
        this.max = max;
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(Integer value) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
