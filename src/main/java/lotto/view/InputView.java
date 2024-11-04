package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요.";

    public int getLottoCost() {
        System.out.println(PURCHASE_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public String getWinningLotto() {
        System.out.println(WINNING_LOTTO_MESSAGE);
        return Console.readLine();
    }
}
