package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Parser.parsePurchaseAmount(Console.readLine());
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Parser.parseWinningNumber(Console.readLine());
    }

    public static Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Parser.parseBonusNumber(Console.readLine());
    }
}
