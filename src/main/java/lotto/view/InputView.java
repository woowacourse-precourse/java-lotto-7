package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberRequestDTO;
import lotto.dto.PurchaseMoneyRequestDTO;
import lotto.dto.WinningNumberRequestDTO;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public PurchaseMoneyRequestDTO readMoneyInput() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String moneyInput = Console.readLine();
        return new PurchaseMoneyRequestDTO(moneyInput);
    }

    public WinningNumberRequestDTO readWinningNumberInput() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String winningNumberInput = Console.readLine();
        return new WinningNumberRequestDTO(winningNumberInput);
    }

    public BonusNumberRequestDTO readBonusNumberInput() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumberInput = Console.readLine();
        return new BonusNumberRequestDTO(bonusNumberInput);
    }
}
