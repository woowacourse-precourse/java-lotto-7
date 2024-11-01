package io;

import camp.nextstep.edu.missionutils.Console;
import domain.error.ErrorMessage;
import domain.error.InputErrorMessage;
import domain.lotto.Lotto;
import domain.lotto.LottoPrice;
import java.util.Arrays;

public class Input {

    public static int getMoneyFoPurchaseLotto() {
        System.out.println(OutputMessage.ENTER_PURCHASE_AMOUNT.getOutputMessage());
        while (true) {
            try {
                return parseAndValidatePurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumbers(String input) {
        Output.println(OutputMessage.ENTER_WINNER_NUMBERS.getOutputMessage());
        return new Lotto(
                Arrays.stream(input.split(InputMessage.DELIMITER.getInputMessage()))
                        .map(Input::parseStringToInt)
                        .toList()
        );
    }

    public static int inputBonusNumber(String input) {
        Output.println(OutputMessage.ENTER_BONUS_NUMBER.getOutputMessage());
        return parseStringToInt(input);
    }

    private static int parseAndValidatePurchaseAmount(String input) {
        validateInputStringIsEmpty(input);
        int amount = parseStringToInt(input);
        validateAmountForPurchaseConditions(amount);
        return amount;
    }

    private static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.ONLY_NUMBERS_ALLOWED.getErrorMessage());
        }
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
}
