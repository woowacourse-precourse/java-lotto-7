package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        String inputAmount = Console.readLine();
        return Integer.parseInt(inputAmount);
    }

    public WinningNumbers inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        String input = Console.readLine();
        return new WinningNumbers(input);
    }

    public BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        System.out.println(BONUS_NUMBER_PROMPT);
        String input = Console.readLine();
        return new BonusNumber(Integer.parseInt(input.trim()), winningNumbers);
    }
}
