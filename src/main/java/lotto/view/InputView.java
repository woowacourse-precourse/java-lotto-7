package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoConstants;

public class InputView {

    public static String requestPurchaseAmount() {
        System.out.println(LottoConstants.REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static List<String> requestWinningNumbers() {
        System.out.println(LottoConstants.REQUEST_WINNING_NUMBERS);
        String inputWinningNumbers = Console.readLine();
        return Arrays.asList(inputWinningNumbers.split(LottoConstants.WINNING_NUMBER_DELIMITER));
    }

    public static String requestBonusNumber() {
        System.out.println(LottoConstants.REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
