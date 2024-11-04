package lotto.validation;

import java.util.List;

public class NumberCountValidator implements Validator<List<Integer>> {
    private final int requiredCount;
    private final String errorMessage;

    public NumberCountValidator(int requiredCount, String errorMessage) {
        this.requiredCount = requiredCount;
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(List<Integer> numbers) {
        if (numbers.size() != requiredCount) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
