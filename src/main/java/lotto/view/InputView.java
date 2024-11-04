package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.RequestMessage;

public class InputView {
    public static String inputPurchaseAmount() {
        System.out.println(RequestMessage.REQUEST_LOTTO_PURCHASE_AMOUNT.getMessage());
        return Console.readLine().trim();
    }

    public static String inputWinningNumbers() {
        System.out.println(RequestMessage.REQUEST_LOTTO_TICKET_NUMBER.getMessage());
        return Console.readLine().trim();
    }

    public static String inputBonusNumber() {
        System.out.println(RequestMessage.REQUEST_LOTTO_BONUS_NUMBER.getMessage());
        return Console.readLine().trim();
    }
}
