package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorCode;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_PATTERN = "\\d+";
    private static final int REQUIRED_NUMBER_COUNT = 6;

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        validateInputNumbers(input);
        List<Integer> numbers = parseWinningNumbers(input);
        validateWinningNumbers(numbers);
        return numbers;
    }

    public int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateNumberFormat(input);
        int number = Integer.parseInt(input);
        new Lotto(List.of(number, 1, 2, 3, 4, 5));
        return number;
    }

    private void validateInputNumbers(String input) {
        String[] numbers = input.split(",");
        validateNumberCount(numbers);
        validateNumbersFormat(numbers);
    }

    private void validateNumberCount(String[] numbers) {
        if (numbers.length != REQUIRED_NUMBER_COUNT) {
            throw ErrorCode.INVALID_WINNING_NUMBERS_SIZE.throwError();
        }
    }

    private void validateNumbersFormat(String[] numbers) {
        boolean isValidFormat = Arrays.stream(numbers)
                .map(String::trim)
                .allMatch(number -> number.matches(NUMBER_PATTERN));

        if (!isValidFormat) {
            throw ErrorCode.INVALID_NUMBER_FORMAT.throwError();
        }
    }

    private void validateNumberFormat(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw ErrorCode.INVALID_NUMBER_FORMAT.throwError();
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        new Lotto(numbers);
    }
}