package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static int inputTotalPrice() {
        System.out.println("\n구입금액을 입력해 주세요.");
        return inputInt();
    }

    private static int inputInt() {
        return parseInt(Console.readLine());
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        }
    }
}
