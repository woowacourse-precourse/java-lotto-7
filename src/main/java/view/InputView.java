package view;

import static exception.ErrorMessage.INPUT_ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String CHECK_NUMBER_REGEX = "\\d+";

    private InputView() {
    }

    public static int purchasePriceInput() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        String userInput = Console.readLine();
        validatePurchasePrice(userInput);
        return Integer.parseInt(userInput);
    }

    public static List<Integer> winningNumberInput() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        return splitAndConvertUserInput(userInput);
    }

    private static void validatePurchasePrice(String purchasePrice) {
        if (!purchasePrice.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
        }
    }

    private static List<Integer> splitAndConvertUserInput(String userInput) {
        try {
            return List.of(userInput.split(",")).stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
        }
    }

}
