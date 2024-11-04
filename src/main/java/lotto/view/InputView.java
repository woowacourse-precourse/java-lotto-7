package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoInputMessage;

public class InputView {
    public static String getLottoPurchaseAmount() {
        System.out.println(LottoInputMessage.LOTTO_PURCHASE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println(LottoInputMessage.LOTTO_WINNING_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println(LottoInputMessage.LOTTO_BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

}
