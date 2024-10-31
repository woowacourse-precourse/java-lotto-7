package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumbersInputView {
    private static final String WINNING_NUMBERS_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";

    public void printWinningNumbersInputGuide() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE);
    }
    
    public String getWinningNumbers() {
        return Console.readLine();
    }
}
