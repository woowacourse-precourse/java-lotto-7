package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);

        return Console.readLine().trim();
    }

    public String readWinningNumber() {
        System.out.println(WINNING_NUMBER_PROMPT);
        String winningNumber = Console.readLine().trim();
        printBlankLine();
        return winningNumber;
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        String bonusNumber = Console.readLine().trim();
        printBlankLine();
        return bonusNumber;
    }

    private void printBlankLine() {
        System.out.println();
    }
}
