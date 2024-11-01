package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.Validator;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public long enterPaymentForLottery() {
        System.out.println(SystemMessage.ENTER_PAYMENT_FOR_LOTTERY);
        return Validator.inputValid(Console.readLine());
    }

    public List<Integer> enterWinningLottery() {
        return null;
    }

    public int enterBonusLottery() {
        return 0;
    }

    public void close() {
        Console.close();
    }
}
