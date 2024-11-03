package lotto.utils.inputValidator.comparison;

import java.util.List;
import lotto.utils.inputValidator.InputValidator;

public interface ComparisonValidator extends InputValidator<String> {
    void validateWithComparison(String validationTarget, List<Integer> comparisons);
}
