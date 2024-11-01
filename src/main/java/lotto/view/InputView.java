package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestTotalAmount(){
        return Console.readLine();
    }

    public static String requestWinningNumber(){
        return Console.readLine();
    }

    public static String requestBonusNumber(){
        return Console.readLine();
    }
}
