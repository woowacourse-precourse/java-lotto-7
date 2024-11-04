package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Message;
import lotto.util.Validator;

public class InputView {
    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public int scanPurchasePrice() {
        while (true) {
            System.out.println(Message.PURCHASE_PRICE_PROMPT.getMessage());
            try {
                String purchasePriceInput = Console.readLine();
                return validator.validatePurchasePrice(purchasePriceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto scanWinningNumbers() {
        while (true) {
            System.out.println("\n" + Message.WINNING_NUMBERS_PROMPT.getMessage());
            try{
                String[] winningNumbersInput = Console.readLine().split(",");
                validator.validateWinningNumber(winningNumbersInput);
                List<Integer> winningNumbers = getWinningNumbers(winningNumbersInput);

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers(String[] winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbersInput) {
            int number = validator.validateNumber(winningNumber);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    public int scanBonusNumber(Lotto winningNumbers) {
        while (true) {
            System.out.println("\n" + Message.BONUS_NUMBER_PROMPT.getMessage());
            try{
                String bonusNumberInput = Console.readLine();
                return validator.validateBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
