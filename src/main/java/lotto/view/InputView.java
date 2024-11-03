package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String NEW_LINE = System.getProperty("line.separator");
    private final static String INPUT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    public String getMoney() {
        System.out.println(INPUT_MONEY_AMOUNT);
        return Console.readLine();
    }

    public String getWinningLottoNumber() {
        System.out.println(NEW_LINE + INPUT_WINNING_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(NEW_LINE + INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
