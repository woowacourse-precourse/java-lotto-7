package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.enums.LottoEnum;
import lotto.enums.OutputViewEnum;
import lotto.utils.Utils;
import lotto.validation.Validator;

public class InputView {

    //inputPurchasePrice 구현
    public static BigDecimal inputPurchaseAmount() {
        OutputView.printPrompt(OutputViewEnum.PURCHASE_AMOUNT_INPUT.getMessage());
        String userInput = Console.readLine();
        validatePurchaseAmountInput(userInput);
        return new BigDecimal(userInput);
    }

    //금액 valiadate
    private static void validatePurchaseAmountInput(String userInput) {
        Validator.isEmpty(userInput);
        Validator.isDigitOnly(userInput);
    }

    //inputWinningNumber 구현
    public static List<Integer> inputWinningNumber() {
        OutputView.printPrompt(OutputViewEnum.WINNING_NUMBER_INPUT.getMessage());
        String userInput = Console.readLine();
        String[] numbers = userInput.split(",");
        validateWinningNumber(userInput);
        return Arrays.stream(numbers).map(number -> Integer.parseInt(number)).toList();
    }

    private static void validateWinningNumber(String userInput) {
        String[] numbers = userInput.split(",");
        List<BigDecimal> winningNumber = Arrays.stream(numbers).map(number -> new BigDecimal(number)).toList();

        Validator.isEmpty(userInput);
        Validator.allDigits(numbers);
        Validator.sizeEqual(numbers, LottoEnum.LOTTO_NUMBER_COUNT.getNumber());
        Validator.allNumberRange(
                new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getNumber()),
                new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getNumber()),
                winningNumber);
        Validator.DuplicateNumber(winningNumber);
    }

    //inputBonusNumber 구현
    public static int inputBonusNumber(List<Integer> winningNumberData) {
        OutputView.printPrompt(OutputViewEnum.BONUS_NUMBER_INPUT.getMessage());
        String userInput = Console.readLine();
        validateBonusNumberInput(userInput, winningNumberData);
        return Integer.parseInt(userInput);
    }

    private static void validateBonusNumberInput(String userInput, List<Integer> winningNumberData) {
        BigDecimal bonusNumber = Utils.stringToNumber(userInput);

        Validator.isEmpty(userInput);
        Validator.isDigitOnly(userInput);
        Validator.oneNumberRange(
                new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getNumber()),
                new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getNumber()),
                bonusNumber);
        Validator.isDuplicateBonusNumber(winningNumberData, bonusNumber.intValue());
    }
}