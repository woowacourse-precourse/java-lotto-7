package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputUtil;
import lotto.valid.ValidInput;

public class InputView {
    public static int inputMoney() {
        System.out.println(InputViewMessage.INPUT_MONEY_VIEW);
        String inputMoney = Console.readLine();

        ValidInput.checkInputMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(InputViewMessage.INPUT_WINNING_NUMBER_VIEW);
        String inputLottoNumbers = Console.readLine();

        ValidInput.checkInputLottoNumbers(inputLottoNumbers);
        return InputUtil.splitNumbers(inputLottoNumbers);
    }

    public static int inputBonusNumber() {
        System.out.println(InputViewMessage.INPUT_BONUS_NUMBER_VIEW);
        String inputBonusNumber = Console.readLine();

        ValidInput.checkInputBonusNumber(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }
}
