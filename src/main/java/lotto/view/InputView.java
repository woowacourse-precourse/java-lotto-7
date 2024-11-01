package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import javax.xml.stream.events.Comment;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUM_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String readWinningNums() {
        System.out.println(WINNING_NUMS_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String readBonusNum() {
        System.out.println(BONUS_NUM_INPUT_MESSAGE);
        return Console.readLine();
    }
}
