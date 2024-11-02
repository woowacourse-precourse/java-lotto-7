package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoEnum;
import lotto.enums.OutputViewEnum;
import lotto.utils.Utils;

public class InputView {

    //inputPurchasePrice 구현
    public static BigDecimal inputPurchaseAmount() {
        OutputView.printPrompt(OutputViewEnum.PURCHASE_AMOUNT_INPUT.getMessage());
        String userInput = Console.readLine();
        validateInput(userInput);
        return new BigDecimal(userInput);
    }

    //금액 valiadate
    private static void validateInput(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        if (!Utils.isDigitOnly(userInput)) {
            throw new NumberFormatException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    //inputWinningNumber 구현
    public static List<Integer> inputWinningNumber() {
        OutputView.printPrompt(OutputViewEnum.WINNING_NUMBER_INPUT.getMessage());
        String userInput = Console.readLine();
        validateWinningNumber(userInput);
        String[] numbers = userInput.split(",");
        List<Integer> winningNumber = Arrays.stream(numbers).map(number -> Integer.parseInt(number)).toList();
        return winningNumber;
    }

    private static void validateWinningNumber(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        String[] numbers = userInput.split(",");
        if (!Utils.allElementsAreDigits(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
        if (!Utils.checkSizeEqual(numbers, LottoEnum.WINNING_NUMBER_COUNT.getNumber())) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
        List<BigDecimal> winningNumber = Arrays.stream(numbers).map(number -> new BigDecimal(number)).toList();
        if (!Utils.areAllNumbersValidRange(new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getNumber()),
                new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getNumber()), winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
        if (!Utils.isDuplicateNumber(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    //inputBonusNumber 구현
    public static int inputBonusNumber(List<Integer> winningNumberData) {
        OutputView.printPrompt(OutputViewEnum.BONUS_NUMBER_INPUT.getMessage());
        String userInput = Console.readLine();
        validateBonusNumberInput(userInput, winningNumberData);
        return Integer.parseInt(userInput);
    }

    private static void validateBonusNumberInput(String userInput, List<Integer> winningNumberData) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        if (!Utils.isDigitOnly(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
        BigDecimal count = Utils.stringToNumber(userInput);
        if (Utils.isNumberInList(winningNumberData, count.intValue())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
        if (!Utils.isInRange(new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getNumber()),
                new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getNumber()), count)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }
}