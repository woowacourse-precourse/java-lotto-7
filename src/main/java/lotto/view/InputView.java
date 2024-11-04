package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.validate.InputValidator;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(ASK_PURCHASE_AMOUNT);
                int amount = Integer.parseInt(readLine());
                InputValidator.validatePurchaseAmount(amount);
                System.out.println();
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println(ASK_WINNING_NUMBERS);
                List<Integer> winningNumbers = parseWinningNumber(readLine());
                InputValidator.validateWinningNumbers(winningNumbers);
                System.out.println();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNubmers) {
        while (true) {
            try {
                System.out.println(ASK_BONUS_NUMBER);
                int bonusNumber = Integer.parseInt(readLine());
                InputValidator.validateBonusNumber(bonusNumber, winningNubmers);
                System.out.println();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumber(String input) {
        List<String> splitInput = List.of(input.split(","));
        List<Integer> result = new ArrayList<>();
        for (String str : splitInput) {
            result.add(Integer.parseInt(str.trim()));
        }

        return result;
    }
}
