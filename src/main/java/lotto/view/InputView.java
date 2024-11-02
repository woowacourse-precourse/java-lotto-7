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
    private static final int WINNING_NUMBER_COUNT = 6;

    //inputPurchasePrice 구현
    public static BigDecimal inputPurchasePrice() {
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
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage() + " : " + userInput);
        }
        String[] numbers = userInput.split(",");
        if (!Utils.allElementsAreDigits(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage() + " : " + userInput);
        }
        if (!Utils.checkSizeEqual(numbers, WINNING_NUMBER_COUNT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage() + " : " + userInput);
        }
        List<BigDecimal> winningNumber = Arrays.stream(numbers).map(number -> new BigDecimal(number)).toList();
        if (!Utils.areAllNumbersValidRange(new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getRange()), new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getRange()), winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage() + " : " + userInput);
        }
        if (!Utils.isDuplicateNumber(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage() + " : " + userInput);
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
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage() + " : " + userInput);
        }
        if (!Utils.isDigitOnly(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage() + " : " + userInput);
        }
        BigDecimal count = Utils.stringToNumber(userInput);
        if (Utils.isNumberInList(winningNumberData, count.intValue())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage() + " : " + userInput);
        }
    }
}