package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_IS_BLANK_ERROR = "[ERROR] 입력이 공백입니다.";

    private void validateInputIsBlank(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(INPUT_IS_BLANK_ERROR);
        }
    }

    public String getPurchaseAmount() {
        String input = Console.readLine();
        validateInputIsBlank(input);
        return input;
    }

    public String getWinningNumbers() {
        String input = Console.readLine();
        validateInputIsBlank(input);
        return input;
    }

    public String getBonusNumber() {
        String input = Console.readLine();
        validateInputIsBlank(input);
        return input;
    }
}
