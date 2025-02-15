package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.validator.InputValidator;
import lotto.validator.LottoValidator;
import lotto.validator.PurchaseAmountValidator;

public class InputView {
    static private final String PURCHASE_AMOUNT_GUIDE = "\n구입금액을 입력해 주세요.";
    static private final String WINNING_NUMBERS_GUIDE = "\n당첨 번호를 입력해 주세요";
    static private final String BONUS_NUMBER_GUIDE = "\n보너스 번호를 입력해 주세요";
    private static final String COMMA = ",";

    static private void printInputMessage(String message) {
        System.out.println(message);
    }

    public int requestPurchaseAmount() {
        while (true) {
            printInputMessage(PURCHASE_AMOUNT_GUIDE);
            try {
                String input = Console.readLine();
                InputValidator.validatePurchaseAmount(input);
                PurchaseAmountValidator.validate(Integer.parseInt(input));

                return Integer.parseInt(input);

            } catch (IllegalArgumentException e) {
                printInputMessage(e.getMessage());
            }
        }
    }

    public List<Integer> requestWinningNumbers() {
        while (true) {
            printInputMessage(WINNING_NUMBERS_GUIDE);
            try {
                String input = Console.readLine();
                InputValidator.validateInputWinningNumbers(input);

                return splitWinningNumber(input);

            } catch (IllegalArgumentException e) {
                printInputMessage(e.getMessage());
            }
        }
    }

    public int requestBonusNumber(List<Integer> numbers) {
        while (true) {
            printInputMessage(BONUS_NUMBER_GUIDE);
            try {
                String input = Console.readLine();
                InputValidator.validateInputBonusNumber(input);
                InputValidator.findBonusOnWinningNumbers(Integer.parseInt(input), numbers);

                return Integer.parseInt(input);

            } catch (IllegalArgumentException e) {
                printInputMessage(e.getMessage());
            }
        }
    }


    private List<Integer> splitWinningNumber(String winningNumber) {
        List<Integer> numbers = new ArrayList<>();

        String[] inputNumbers = winningNumber.split(COMMA);

        for (String inputNumber : inputNumbers) {
            numbers.add(Integer.parseInt(inputNumber.trim()));
        }
        LottoValidator.validate(numbers);

        return numbers;
    }
}
