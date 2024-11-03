package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.LottoErrorMessage;

public class WinningNumbers {

    private static final List<Integer> winningNumbers = new ArrayList<>();

    private static final WinningNumbers instance = new WinningNumbers();

    private WinningNumbers() {
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public static WinningNumbers getInstance() {
        return instance;
    }

    public static void initialInstance(List<Integer> numbers) {
        if (winningNumbers.isEmpty()) {
            validate(numbers);
            winningNumbers.addAll(numbers);
        }
    }

    private static void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.IS_NOT_CORRECT_COUNT.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LottoErrorMessage.IS_NOT_POSSIBLE_RANGE.getMessage());
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.HAVE_DUPLICATED_NUMBER.getMessage());
        }
    }

}
