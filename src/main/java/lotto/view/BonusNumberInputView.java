package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.ConsoleMessage;

public class BonusNumberInputView extends View {

    @Override
    protected void printMessage() {
        System.out.println(ConsoleMessage.BONUS_INPUT);
    }

    @Override
    protected String doRendering() {
        return Console.readLine();
    }
}
