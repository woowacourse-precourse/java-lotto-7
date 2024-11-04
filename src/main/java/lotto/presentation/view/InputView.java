package lotto.presentation.view;

import static lotto.common.ExceptionMessage.INVALID_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String IS_DIGIT_PATTERN = "^[0-9]+$";

    public String getValidPurchaseAmount() {
        String inputPurchaseAmount = inputValue("구입금액을 입력해 주세요.");
        isDigit(inputPurchaseAmount);
        return inputPurchaseAmount;
    }

    public List<String> getValidWinningNumbers() {
        String inputWinningNumbers = inputValue("당첨 번호를 입력해 주세요.");
        String[] splitInputWinningNumbers = inputWinningNumbers.split(",");
        validateWinningNumbers(splitInputWinningNumbers);
        return Arrays.stream(splitInputWinningNumbers).toList();
    }

    public String getValidBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = inputValue("보너스 번호를 입력해 주세요.");
        isDigit(inputBonusNumber);
        return inputBonusNumber;
    }

    private String inputValue(String placeholder) {
        System.out.println(placeholder);
        String input = Console.readLine().replace(" ", "");
        return input;
    }

    private void validateWinningNumbers(String[] splitInputWinningNumbers) {
        for (String winningNumber : splitInputWinningNumbers) {
            isDigit(winningNumber);
        }
    }

    private void isDigit(String inputPurchaseAmount) {
        if (!inputPurchaseAmount.matches(IS_DIGIT_PATTERN)) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
