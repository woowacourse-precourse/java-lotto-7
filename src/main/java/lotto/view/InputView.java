package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputPurchaseAmount() {
        while (true) {
            try {
                return Integer.parseInt(readUserInput());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
        }
    }

    public static String inputWinningNumbers() {
        return readUserInput();
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                return Integer.parseInt(readUserInput());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
        }
    }

    private static String readUserInput() {
       return readLine();
    }
}
