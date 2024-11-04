package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputUserAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> inputUserWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return parseNumber(Console.readLine());
    }

    public static int inputUserBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return validateNumber(Console.readLine());
    }

    private static List<Integer> parseNumber(String inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String inputNumber : inputWinningNumber.split(",")) {
            winningNumber.add(validateNumber(inputNumber));
        }
        return winningNumber;
    }

    private static int validateNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
