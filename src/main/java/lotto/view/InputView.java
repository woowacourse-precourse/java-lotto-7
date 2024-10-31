package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;
import java.util.SimpleTimeZone;
import lotto.utils.Utils;
import net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation;

public class InputView {
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;

    //inputPurchasePrice 구현
    public static int inputPurchasePrice() {
        String userInput;
        int count;

        while (true) {
            userInput = Console.readLine();
            try {
                validatePurchase(userInput);
                count = Utils.stringToInteger(userInput);
                return count;
            } catch (NumberFormatException e) {
                OutputView.errorPrint(e.getMessage());
            } catch (IllegalArgumentException e) {
                OutputView.errorPrint(e.getMessage());
            }
        }
    }

    //금액 valiadate
    private static void validatePurchase(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage() + " : " + userInput);
        }
        if (!Utils.isDigitOnly(userInput)) {
            throw new NumberFormatException(ErrorMessage.NOT_NUMBER.getMessage() + " : " + userInput);
        }
        BigDecimal count = Utils.stringToNumber(userInput);
        if (!Utils.isInRange(new BigDecimal("1000"), new BigDecimal("100000"), count)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage() + " : " + userInput);
        }
        if (!Utils.isDivisibleByThousand(count.intValue())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.getMessage() + " : " + userInput);
        }
    }

    //inputWinningNumber 구현
    public static List<Integer> inputWinningNumber() {

        while (true) {
            try {
                String userInput = Console.readLine();
                validateWinningNumber(userInput);
                String[] numbers = userInput.split(",");
                List<Integer> winningNumber = Arrays.stream(numbers).map(number -> Integer.parseInt(number)).toList();
                return winningNumber;
            } catch (IllegalArgumentException e) {
                OutputView.errorPrint(e.getMessage());
            }
        }
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
        if (!Utils.areAllNumbersValidRange(new BigDecimal(MIN_LOTTO_RANGE), new BigDecimal(MAX_LOTTO_RANGE), winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage() + " : " + userInput);
        }
        if (!Utils.isDuplicateNumber(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage() + " : " + userInput);
        }
    }

    //inputBonusNumber 구현
    public static int inputBonusNumber() {
        while (true) {
            try {
                String userInput = Console.readLine();
                validateBonusNumber(userInput);
                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
                OutputView.errorPrint(e.getMessage());
            }
        }
    }

    private static void validateBonusNumber(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage() + " : " + userInput);
        }
    }
}