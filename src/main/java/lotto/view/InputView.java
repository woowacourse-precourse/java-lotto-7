package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {

    public int getLottoBuyMoney(){
        String msg = Console.readLine();
        InputValidator.validateInput(msg);
        return Integer.parseInt(msg);
    }
}
