package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.OutputView.printInputBonusNumber;
import static lotto.view.OutputView.printInputPrice;
import static lotto.view.OutputView.printWinningLotto;

public class InputView {
    private static final String BLINK_INPUT_ERROR = "입력된 값이 없습니다.";
    private static final String DELIMETER = ",";

    public static String inputPrice() {
        printInputPrice();
        String price = readLine();
        return price;
    }

    public static String[] inputWinningLotto() {
        printWinningLotto();
        String winningLotto = readLine();
        return splitInput(winningLotto);
    }

    public static String[] splitInput(String input) {
        validateNotNull(input);
        String[] stringNumbers = input.split(DELIMETER);
        return stringNumbers;
    }


    private static void validateNotNull(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }


    public static String inputBonusNumber() {
        printInputBonusNumber();
        String price = readLine();
        return price;
    }
}
