package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class WinningNumbersInputView {
    private static final String WINNING_NUMBERS_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";

    public void printWinningNumbersInputGuide() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE);
    }

    public List<String> getWinningNumbers() {
        String winningNumbers = Console.readLine();
        return getParsedWinningNumbers(winningNumbers);
    }

    private List<String> getParsedWinningNumbers(String winningNumbers) {
        String[] parsedWinningNumbers =  winningNumbers.split(",");
        return List.of(parsedWinningNumbers);
    }
}
