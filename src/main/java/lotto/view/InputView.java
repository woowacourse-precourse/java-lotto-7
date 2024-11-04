package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GUIDE_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GUIDE_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GUIDE_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NEWLINE = "\n";


    public String inputPurchase() {
        System.out.println(GUIDE_PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(GUIDE_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(NEWLINE + GUIDE_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
