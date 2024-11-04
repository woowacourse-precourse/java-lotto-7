package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String getBudget() {
        System.out.println(ASK_BUDGET_MESSAGE);
        return Console.readLine();
    }

    public String getWinningLottoNumbers() {
        System.out.println(ASK_WINNING_LOTTO_MESSAGE);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
