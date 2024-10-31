package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import lotto.utils.Utils;
import net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation;

public class InputView {

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
                throw new NumberFormatException("[ERROR] 숫자가 아닙니다 : " + userInput);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] Value가 범위안에 없습니다.");
            }
        }
    }

    //금액 valiadate
    public static void validatePurchase(String userInput) {
        if (!Utils.isDigitOnly(userInput)) {
            throw new NumberFormatException("숫자가 아닙니다 : " + userInput);
        }
        BigDecimal count = Utils.stringToNumber(userInput);
        if (!Utils.isInRange(new BigDecimal("1000"), new BigDecimal("100000"), count)) {
            throw new IllegalArgumentException("Value가 범위안에 없습니다.");
        }

    }

    //inputWinningNumber 구현

    //inputBonusNumber 구현
}