package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constants;

public class InputView {
    public static String inputAmountOfLotto(){
        System.out.println(Constants.LOTTO_AMOUNT_INPUT);
        return Console.readLine();
    }
}
