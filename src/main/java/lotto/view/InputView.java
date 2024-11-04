package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exceptions.ArgumentException;

public class InputView {
    private static final String MONEY_INPUT_REQUEST_TEXT = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_INPUT_REQUEST_TEXT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_REQUEST_TEXT = "보너스 번호를 입력해 주세요.";
    private static final Pattern IS_NUMBER = Pattern.compile("[0-9]+");
    private static final Pattern IS_NUMBER_AND_COMMA = Pattern.compile("[0-9,]+");

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public static void printMoneyInputRequestMessage() {
        System.out.println(MONEY_INPUT_REQUEST_TEXT);
    }

    public String inputMoney() {
        return Console.readLine();
    }

    public static void printWinningLottoInputRequestMessage() {
        System.out.println(WINNING_LOTTO_INPUT_REQUEST_TEXT);
    }

    public String inputWinningLotto() {
        return Console.readLine();
    }

    public static void printBonusBallInputRequestMessage() {
        System.out.println(BONUS_BALL_INPUT_REQUEST_TEXT);
    }

    public String inputBonusBall() {
        return Console.readLine();
    }

    public void validateIsBlank(final String userInput) {
        if (userInput.isBlank()) {
            throw ArgumentException.EMPTY_INPUT_VALUE;
        }
    }

    public void validateIsNumber(final String userInput) {
        boolean ok = IS_NUMBER.matcher(userInput).matches();
        if (!ok) {
            throw ArgumentException.ONLY_NUMBER;
        }
    }

    public void validateIsNumberAndComma(final String userInput) {
        boolean ok = IS_NUMBER_AND_COMMA.matcher(userInput).matches();
        if (!ok) {
            throw ArgumentException.ONLY_NUMBER_AND_COMMA;
        }
    }
}
