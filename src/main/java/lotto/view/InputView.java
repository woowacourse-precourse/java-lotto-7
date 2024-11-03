package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ErrorMessage;
import lotto.enums.InputMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String PRIZE_NUMBERS_SPLIT_STRING = ",";
    private final static int LOTTO_PRIZE = 1000;

    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_INPUT.getMessage());
        String purchaseAmount = Console.readLine();
        while (!isInteger(purchaseAmount)
                || !validatePurchaseAmountPositive(Integer.parseInt(purchaseAmount))
                || !validatePurchaseAmountUnit(Integer.parseInt(purchaseAmount))) {
            purchaseAmount = Console.readLine();
        }

        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputLottoPrizeNumbers() {
        System.out.println(InputMessage.PRIZE_NUMBERS_INPUT.getMessage());
        return Arrays.stream(Console.readLine().split(PRIZE_NUMBERS_SPLIT_STRING))
                .map(Integer::parseInt)
                .toList();
    }

    public static int inputLottoBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    private static boolean isInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.CHARACTER_INPUT_ERROR.getMessage());
            return false;
        }

        return true;
    }

    private static boolean validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRIZE != 0) {
            System.out.println(ErrorMessage.WRONG_LOTTO_PRIZE_ERROR.getMessage());
            return false;
        }

        return true;
    }

    private static boolean validatePurchaseAmountPositive(int purchaseAmount) {
        if (purchaseAmount < 0) {
            System.out.println(ErrorMessage.NEGATIVE_LOTTO_PRIZE_ERROR.getMessage());
            return false;
        }

        return true;
    }
}
