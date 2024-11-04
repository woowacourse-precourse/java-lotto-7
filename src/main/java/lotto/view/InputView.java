package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.MessageSource;

public class InputView {

    public static String getPurchaseAmount() {
        System.out.println(MessageSource.getMessage("message.purchase_amount"));
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println("\n" + MessageSource.getMessage("message.winning_numbers"));
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println("\n" + MessageSource.getMessage("message.bonus_number"));
        return Console.readLine();
    }
}
