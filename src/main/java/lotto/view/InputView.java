package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readPurchasePrice() {
        String buffer = readInput();
        try {
            return Integer.parseInt(buffer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    private static String readInput() {
        String buffer = Console.readLine();
        validateInput(buffer);
        return buffer;
    }

    private static void validateInput(String buffer) {
        if(buffer == null || buffer.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다");
        }
    }

}
