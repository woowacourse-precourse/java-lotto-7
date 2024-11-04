package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.RetryUtil;
import java.util.List;

public class InputView {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String requestPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
        return RetryUtil.retryReadPurchaseAmount(this::readPurchaseAmountInput);
    }

    public String requestWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        String winningNumbers = RetryUtil.retryReadWinningNumber(this::readWinningNumbersInput);
        printNewLine();
        return winningNumbers;
    }

    public String requestBonusNumber(List<Integer> winningNumbers) {
        System.out.println(PROMPT_BONUS_NUMBER);
        String bonusNumber = RetryUtil.retryReadBonusNumber(this::readBonusNumberInput, winningNumbers);
        printNewLine();
        return bonusNumber;
    }

    private String readPurchaseAmountInput() {
        return Console.readLine().trim();
    }

    private String readWinningNumbersInput() {
        return Console.readLine().trim();
    }

    private String readBonusNumberInput() {
        return Console.readLine().trim();
    }

    private void printNewLine() {
        System.out.println();
    }
}
