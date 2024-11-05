package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.InputMessage;
import lotto.model.Lotto;

public class InputViewImpl implements InputView {
    @Override
    public String inputMoney() {
        System.out.println(InputMessage.INPUT_MONEY_MESSAGE.getInputMessage());
        return Console.readLine();
    }

    @Override
    public String inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS_MESSAGE.getInputMessage());
        return Console.readLine();
    }

    @Override
    public String inputBonusNumber(Lotto lotto) {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getInputMessage());
        return Console.readLine();
    }
}
