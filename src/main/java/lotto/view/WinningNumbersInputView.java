package lotto.view;

import static lotto.ExceptionMessage.PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION;
import static lotto.ExceptionMessage.WINNING_NUMBERS_NOT_NUMERIC_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class WinningNumbersInputView {
    private static final String WINNING_NUMBERS_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";

    public void printWinningNumbersInputGuide() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE);
    }

    public List<String> getWinningNumbers() {
        String winningNumbers = Console.readLine();
        List<String> parsedWinningNumbers = getParsedWinningNumbers(winningNumbers);
        validateWinningNumbersIsNumeric(parsedWinningNumbers);
        return parsedWinningNumbers;
    }

    private List<String> getParsedWinningNumbers(String winningNumbers) {
        String[] parsedWinningNumbers =  winningNumbers.split(",");
        return List.of(parsedWinningNumbers);
    }

    private void validateWinningNumbersIsNumeric(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (!winningNumber.matches("\\d+")) {
                throw new IllegalArgumentException(WINNING_NUMBERS_NOT_NUMERIC_EXCEPTION.message());
            }
        }
    }
}
