package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String ASK_MONEY_INPUT = "구입금액을 입력해 주세요.";
    public static final String ASK_LOTTO_NUM_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String ASK_LOTTO_BONUS_NUM_INPUT = "보너스 번호를 입력해 주세요.";

    public String lottoMoneyInput() {
        System.out.println(ASK_MONEY_INPUT);
        return Console.readLine();
    }

    public String lottoNumsInput() {
        System.out.println(ASK_LOTTO_NUM_INPUT);
        return Console.readLine();
    }

    public String lottoBonusNumInput() {
        System.out.println(ASK_LOTTO_BONUS_NUM_INPUT);
        return Console.readLine();
    }
}
