package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static int inputTotalPrice() {
        System.out.println("\n구입금액을 입력해 주세요.");
        return inputNumber();
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return inputNumbers();
    }

    private static int inputNumber() {
        return parseInt(Console.readLine());
    }

    private static List<Integer> inputNumbers() {
        return Arrays.stream(Console.readLine().split(NUMBER_DELIMITER))
                .map(InputView::parseInt)
                .toList();
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("범위에 맞는 숫자를 입력해야 합니다");
        }
    }
}
