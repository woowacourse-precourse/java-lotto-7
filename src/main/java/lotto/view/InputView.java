package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ViewConstants;

public class InputView {
    public static String getPurchaseAmount() {
        System.out.println(ViewConstants.PRICE_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println();
        System.out.println(ViewConstants.NUMBER_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println();
        System.out.println(ViewConstants.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
