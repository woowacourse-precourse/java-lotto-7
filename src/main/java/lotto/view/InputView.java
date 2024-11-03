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
        System.out.println(PrintMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        return purchaseValidator.validate(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println(PrintMessage.INPUT_WINNING_NUMBERS.getMessage());
        String input = Console.readLine();
        List<Integer> winningNumbers = StringParsingUtil.parseNumbers(input);
        LottoValidator.validateLottoNumbers(winningNumbers);
        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        System.out.println(PrintMessage.INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = basicNumberValidator.validate(Console.readLine());
        LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }
}
