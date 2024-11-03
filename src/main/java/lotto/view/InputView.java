package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.InputProcessor;

public class InputView {
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static Integer readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return InputProcessor.parseSingleInteger(Console.readLine());
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return InputProcessor.parseIntegerList(Console.readLine());
    }

    public static Integer readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return InputProcessor.parseSingleInteger(Console.readLine());
    }
}