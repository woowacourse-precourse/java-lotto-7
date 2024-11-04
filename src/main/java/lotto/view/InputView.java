package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String ERROR_NON_NUMERIC_PURCHASE_AMOUNT_MESSAGE =
            "[ERROR] 구입 금액은 정수 범위의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자로 이루어져 있어야 합니다.";

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String DELIMITER_COMMA = ",";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        try {
            return Arrays.stream(Console.readLine().split(DELIMITER_COMMA))
                    .mapToInt(Integer::parseInt).boxed().toList();
        } catch (IllegalArgumentException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE);
        }
    }

    public static Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE);
        }
    }
}
