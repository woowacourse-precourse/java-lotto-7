package lotto.validation;

import java.util.HashSet;
import java.util.List;

public class UniqueNumberValidator implements Validator<List<Integer>> {
    private final String errorMessage;

    public UniqueNumberValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
