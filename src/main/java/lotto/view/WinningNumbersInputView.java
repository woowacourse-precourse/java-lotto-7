package lotto.view;

import static lotto.ExceptionMessage.WINNING_NUMBERS_NOT_NUMERIC_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumbersInputView {
    private static final String WINNING_NUMBERS_INPUT_GUIDE = "\n당첨 번호를 입력해 주세요.";
    private static final String COMMA = ",";

    public void printWinningNumbersInputGuide() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE);
    }


    public List<Integer> getWinningNumbers() {
        String winningNumbers = Console.readLine();
        List<String> parsedWinningNumbers = getParsedWinningNumbers(winningNumbers);
        validateWinningNumbersIsNumeric(parsedWinningNumbers);
        return getIntegerWinningNumbers(parsedWinningNumbers);
    }

    private List<String> getParsedWinningNumbers(String winningNumbers) {
        String[] parsedWinningNumbers = winningNumbers.split(COMMA);
        return List.of(parsedWinningNumbers);
    }

    private void validateWinningNumbersIsNumeric(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (!winningNumber.matches("\\d+")) {
                throw new IllegalArgumentException(WINNING_NUMBERS_NOT_NUMERIC_EXCEPTION.message());
            }
        }
    }

    private List<Integer> getIntegerWinningNumbers(List<String> winningNumbers) {
        List<Integer> integerWinningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            int integerWinningNumber = Integer.parseInt(winningNumber);
            integerWinningNumbers.add(integerWinningNumber);
        }
        return integerWinningNumbers;
    }

}
