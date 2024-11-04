package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;
import java.util.List;

public class InputView {

    public static int promptPurchaseAmount() {
        return promptValidInput("구입금액을 입력해 주세요: ", InputValidator::parsePurchaseAmount);
    }

    public static List<Integer> promptWinningNumbers() {
        return promptValidInput("당첨 번호를 입력해 주세요 (쉼표로 구분): ", InputValidator::parseWinningNumbers);
    }

    public static int promptBonusNumber(List<Integer> winningNumbers) {
        return promptValidInput("보너스 번호를 입력해 주세요: ", input -> InputValidator.parseBonusNumber(input, winningNumbers));
    }

    private static <T> T promptValidInput(String message, InputParser<T> parser) {
        while (true) {
            System.out.print(message);
            String input = Console.readLine();
            try {
                return parser.parse(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    interface InputParser<T> {
        T parse(String input) throws IllegalArgumentException;
    }
}
