package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputPurchaseAmount() {
        int result = 0;
            try {
                result = Integer.parseInt(readUserInput());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
        return result;
    }

    public static String inputWinningNumbers() {
        return readUserInput();
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(readUserInput());
    }

    private static String readUserInput() {
       return readLine();
    }
}
