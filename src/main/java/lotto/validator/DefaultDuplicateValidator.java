package lotto.validator;

import static lotto.constant.ErrorCode.DUPLICATE_WINNIG_NUMBER;

import java.util.List;
import lotto.view.OutputView;

public class DefaultDuplicateValidator implements DuplicateValidator<List<Integer>> {

    @Override
    public void validateDuplicates(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            OutputView.printError(DUPLICATE_WINNIG_NUMBER.getMessage());
        }
    }

}
