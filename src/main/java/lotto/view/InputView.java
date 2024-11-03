package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.common.PrintMessage;
import lotto.util.StringParsingUtil;
import lotto.validator.LottoValidator;
import lotto.validator.NumberValidator;

public class InputView {

    private final NumberValidator purchaseValidator;
    private final NumberValidator basicNumberValidator;

    public InputView(NumberValidator purchaseValidator, NumberValidator basicNumberValidator) {
        this.purchaseValidator = purchaseValidator;
        this.basicNumberValidator = basicNumberValidator;
    }

    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PrintMessage.INPUT_PURCHASE_AMOUNT.getMessage());
                return purchaseValidator.validate(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println(PrintMessage.INPUT_WINNING_NUMBERS.getMessage());
                String input = Console.readLine();
                List<Integer> winningNumbers = StringParsingUtil.parseNumbers(input);
                LottoValidator.validateLottoNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(PrintMessage.INPUT_BONUS_NUMBER.getMessage());
                int bonusNumber = basicNumberValidator.validate(Console.readLine());
                LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

