package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ERROR_NOT_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_NOT_WINNING_NUMBER = "[ERROR] 올바른 형식의 당첨 번호를 입력해주세요.";

    public int inputPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        try {
            return Arrays.stream(input.split(","))
                    .map((String::trim))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_WINNING_NUMBER);
        }
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_WINNING_NUMBER);
        }
    }

}
