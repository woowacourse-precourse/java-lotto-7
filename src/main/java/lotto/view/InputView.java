package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;
import lotto.utils.Utils;
import net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation;

public class InputView {
    private static final String NOT_NUMBER = "숫자가 아닙니다.";
    private static final String INVALID_RANGE = "범위가 유효하지 않습니다.";
    private static final String NOT_DIVISIBLE_BY_THOUSAND = "천원단위로 나누어 지지 않습니다.";
    private static final String EMPTY_INPUT = "빈 입력입니다.";
    private static final String INVALID_WINNING_NUMBER_COUNT = "당첨 번호 개수가 맞지 않습니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
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
            throw new IllegalArgumentException(EMPTY_INPUT + " : " + userInput);
        }
        if (!Utils.isDigitOnly(userInput)) {
            throw new NumberFormatException(NOT_NUMBER + " : " + userInput);
        }
        BigDecimal count = Utils.stringToNumber(userInput);
        if (!Utils.isInRange(new BigDecimal("1000"), new BigDecimal("100000"), count)) {
            throw new IllegalArgumentException(INVALID_RANGE + " : " + userInput);
        }
        if (!Utils.isDivisibleByThousand(count.intValue())) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND + " : " + userInput);
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
            throw new IllegalArgumentException(EMPTY_INPUT + " : " + userInput);
        }
        String[] numbers = userInput.split(",");
        if (!Utils.allElementsAreDigits(numbers)) {
            throw new IllegalArgumentException(NOT_NUMBER + " : " + userInput);
        }
        if (!Utils.checkSizeEqual(numbers, WINNING_NUMBER_COUNT)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT + " : " + userInput);
        }
        List<BigDecimal> winningNumber = Arrays.stream(numbers).map(number -> new BigDecimal(number)).toList();
        if (!Utils.areAllNumbersValidRange(new BigDecimal(MIN_LOTTO_RANGE), new BigDecimal(MAX_LOTTO_RANGE), winningNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE + " : " + userInput);
        }
    }

    //inputBonusNumber 구현
}