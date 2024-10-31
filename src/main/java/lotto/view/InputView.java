package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import lotto.utils.Utils;
import net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation;

public class InputView {
    private static final String NOT_NUMBER = "숫자가 아닙니다";
    private static final String INVALID_RANGE = "범위가 유효하지 않습니다";
    private static final String NOT_DIVISIBLE_BY_THOUSAND = "천원단위로 나누어 지지 않습니다";
    private static final String EMPTY_INPUT = "빈 입력입니다";

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
    public static void validatePurchase(String userInput) {
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
        String userInput = Console.readLine();
        String[] numbers = userInput.split(",");

        List<Integer> winningNumber = Arrays.stream(numbers).map(number -> Integer.parseInt(number)).toList();
        return winningNumber;
    }

    //inputBonusNumber 구현
}