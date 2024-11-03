package lotto.model.draw;

import static lotto.constant.ErrorMessage.INVALID_DRAW_NUMBER_COUNT;
import static lotto.constant.ErrorMessage.INVALID_DRAW_NUMBER_FORMAT;
import static lotto.constant.ErrorMessage.INVALID_DUPLICATE;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DrawNumbers {
    private final List<Integer> drawNumbers;

    public DrawNumbers(final String drawNumberInput) {
        List<String> splitDrawNumbers = splitInput(drawNumberInput);
        validateDrawNumberCount(splitDrawNumbers);
        this.drawNumbers = splitDrawNumbers.stream()
                .map(this::validateIsPositiveInteger)
                .map(Integer::parseInt)
                .map(this::validateInRange)
                .toList();
        validateNoDuplicates();
    }

    private List<String> splitInput(final String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip).toList();
    }

    private void validateDrawNumberCount(final List<String> splitDrawNumbers) {
        if (splitDrawNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_DRAW_NUMBER_COUNT.getFormatMessage());
        }
    }

    private String validateIsPositiveInteger(final String drawNumber) {
        if (!drawNumber.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_DRAW_NUMBER_FORMAT.getFormatMessage());
        }
        return drawNumber;
    }

    private int validateInRange(final int drawNumber) {
        if (drawNumber < MIN_LOTTO_NUMBER || drawNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_DRAW_NUMBER_FORMAT.getFormatMessage());
        }
        return drawNumber;
    }

    private void validateNoDuplicates() {
        Set<Integer> uniqueNumbers = new HashSet<>(drawNumbers);
        if (drawNumbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE.getFormatMessage());
        }
    }

    public List<Integer> getDrawNumbers() {
        return drawNumbers;
    }
}
