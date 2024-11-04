package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;

public class InputView {
    private static InputView instance;
    private static final String PRICE_INPUT_INFO = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_INFO = "\n당첨 번호를 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }

        return instance;
    }

    public int readPurchasePrice() {
        while (true) {
            try {
                System.out.println(PRICE_INPUT_INFO);
                String inputPrice = Console.readLine();
                int price = parsePrice(inputPrice);
                validatePrice(price);

                return price;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private int parsePrice(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.PARSING_ERROR.getMessage());
        }
    }

    private void validatePrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_UNIT_ERROR.getMessage());
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNITS_ERROR.getMessage());
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_INPUT_INFO);
                List<Integer> winningNumbers = parseWinningNumbers(Console.readLine());
                validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(NUMBER_DELIMITER))
                .map(this::parseNumber)
                .sorted()
                .toList();
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getMessage());
        }

        winningNumbers.stream()
                .filter(number -> number < 0)
                .findFirst()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ErrorMessage.UNDER_ZERO_ERROR.getMessage());
                });
    }
}
