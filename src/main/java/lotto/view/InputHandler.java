package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoConfig;

public class InputHandler {
    private static final String DELIMITER = ",";

    public int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 입력받은 값이 숫자가 아닙니다.");
        }
    }

    public void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] null이 입력되었습니다.");
        }
    }

    public List<Integer> parsedNumbers(String input) {
        final List<Integer> parsedNumbers = new ArrayList<>();
        final String[] numbers = input.split(DELIMITER);
        for (final String number : numbers) {
            parsedNumbers.add(validateNumber(number));
        }
        return parsedNumbers;
    }

    public void checkNumberRange(int number) {
        if (number < LottoConfig.MINIMUM.getValue() || number > LottoConfig.MAXIMUM.getValue()) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45이어야 합니다.");
        }
    }
}
