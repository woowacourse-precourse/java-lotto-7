package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constant;
import lotto.validator.WinningNumberValidator;
import lotto.validator.LottoPurchaseValidator;

public class InputView {

    // 구입 금액
    public static String inputPurchasePrice() {
        System.out.println(Constant.LOTTO_PURCHASE_PRICE_MESSAGE);
        String purchasePrice = readLine();

        LottoPurchaseValidator.validate(purchasePrice);
        return purchasePrice;
    }

    // 사용자 입력 당첨 번호
    public static String inputWinningNumbers() {
        System.out.println(Constant.LOTTO_WINNING_NUMBERS_MESSAGE);
        String winningNumbers = readLine();

        WinningNumberValidator.validate(winningNumbers);
        return winningNumbers;
    }

    // 사용자 입력 보너스 번호
    public static String inputBonusNumber() {
        System.out.println(Constant.LOTTO_BONUS_MESSAGE);
        String bonusNumber = readLine();

        LottoPurchaseValidator.validate(bonusNumber);
        return bonusNumber;
    }

    public static String readLine() {
        return Console.readLine();
    }
}
