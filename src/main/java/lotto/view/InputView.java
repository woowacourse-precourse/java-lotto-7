package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.message.InputMessage;
import lotto.validator.InputValidator;

import java.util.List;

public class InputView {

//  기능 담당을 분리하는 것도 중요하지만,
//  너무 작은 단위로 모듈화하면,
//  오히려 복잡성이 증가한다고 생각한다.


    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_MESSAGE.getMessage());
        String cost = Console.readLine();

        return InputValidator.validateInteger(cost);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(InputMessage.WINNER_NUMBERS_MESSAGE.getMessage());
        String winningNums = Console.readLine();

        return InputValidator.validateWinningNumbers(winningNums);
    }

    public static int inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String bonusNum = Console.readLine();

        return InputValidator.validateInteger(bonusNum);
    }
}
