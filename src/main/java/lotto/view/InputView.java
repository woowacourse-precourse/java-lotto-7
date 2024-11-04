package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.Validator.EMPTY_STRING;
import static lotto.utils.Validator.WHITESPACE_PATTERN;

public class InputView {

    public static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static String getPrice() {
        System.out.println(PRICE_INPUT_MESSAGE);
        return readLine();
    }

    public static String getWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        return readLine().replaceAll(WHITESPACE_PATTERN, EMPTY_STRING);
    }

    public static String getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return readLine().replaceAll(WHITESPACE_PATTERN, EMPTY_STRING);
    }
}
