package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputHandler {
    private InputHandler() {
        // Prevent instantiation
    }

    public static int getPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.parsePurchaseAmount(input);
    }

    public static Lotto getWinningNumberFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return new Lotto(Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList()));
    }

    public static Integer getBonusNumberFromUser() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.parseBonusNumber(input);
    }
}
