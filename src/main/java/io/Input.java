package io;

import camp.nextstep.edu.missionutils.Console;
import domain.error.ErrorMessage;
import domain.error.InputErrorMessage;
import domain.lotto.Lotto;
import domain.lotto.LottoCondition;
import domain.lotto.LottoPrice;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public static int getMoneyForPurchaseLotto() {
        Output.println(OutputMessage.ENTER_PURCHASE_AMOUNT.getOutputMessage());
        while (true) {
            try {
                return parseAndValidatePurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                Output.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumbers(String input) {
        validateInputStringIsEmpty(input);
        List<Integer> inputNumbers =
                Arrays.stream(input.split(InputMessage.DELIMITER.getInputMessage()))
                        .map(String::trim)
                        .map(Input::parseStringToInt)
                        .collect(Collectors.toList());
        return new Lotto(inputNumbers);
    }

    public static int inputBonusNumber(String input) {
        validateInputStringIsEmpty(input);
        int bonusNumber = parseStringToInt(input);
        validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.ONLY_NUMBERS_ALLOWED.getErrorMessage());
        }
    }

    private static int parseAndValidatePurchaseAmount(String input) {
        validateInputStringIsEmpty(input);
        int amount = parseStringToInt(input);
        validateAmountForPurchaseConditions(amount);
        return amount;
    }

    private static void validateAmountForPurchaseConditions(int amount) {
        if (amount < LottoPrice.LOTTO_PRICE.getPrice() || amount % LottoPrice.LOTTO_PRICE.getPrice() != 0) {
            throw new IllegalArgumentException(InputErrorMessage.PURCHASE_LOTTO_CONDITION.getErrorMessage());
        }
    }

    private static void validateInputStringIsEmpty(String input) {
        if (input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MESSAGE.getErrorMessage());
        }
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoCondition.START_INCLUSIVE.getConditionNumber()
                || bonusNumber > LottoCondition.END_INCLUSIVE.getConditionNumber()) {
            throw new IllegalArgumentException(InputErrorMessage.WINNING_NUMBER_VALIDATION.getErrorMessage());
        }
    }
}
