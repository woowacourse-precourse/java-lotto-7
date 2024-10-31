package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String REGEX = ",|, ";

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return inputNumberValue();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return convertToList(inputValue());
    }

    private static List<Integer> convertToList(String inputValue) {
        List<String> values = Arrays.stream(inputValue.split(REGEX)).toList();
        for (String value : values) {
            validateNumberValue(value);
        }
        return values.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static String inputValue() {
        return Console.readLine();
    }

    private static int inputNumberValue() {
        String inputValue = inputValue();
        validateNumberValue(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validateNumberValue(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 입력가능합니다.");
        }
    }
}
