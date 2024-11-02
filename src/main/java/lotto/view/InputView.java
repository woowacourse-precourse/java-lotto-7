package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parse;
import java.util.List;

public class InputView {

    public static int readPurchasePrice() {
        String buffer = readInput();
        try {
            return Integer.parseInt(buffer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public static List<Integer> readWinningNumbers() {
        String buffer = readInput();
        return Parse.winningNumbers(buffer);
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
