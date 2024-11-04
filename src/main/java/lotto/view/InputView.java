package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputMoney() {
        return validateInteger(Console.readLine());
    }

    public static int validateInteger(String input) {
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 정수를 입력해주세요.");
                input = Console.readLine();
            }
        }
    }
}