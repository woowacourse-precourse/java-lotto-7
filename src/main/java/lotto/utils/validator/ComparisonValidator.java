package lotto.utils.validator;

import java.util.List;

public interface ComparisonValidator extends InputValidator<String> {
    void validateWithComparison(String validationTarget, List<Integer> comparisons);
}
