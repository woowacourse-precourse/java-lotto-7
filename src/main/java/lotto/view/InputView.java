package lotto.view;

import static lotto.constant.message.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getLottoPurchaseAmountInput() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getWinningTicketInput() {
        System.out.println(WINNING_TICKET_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
