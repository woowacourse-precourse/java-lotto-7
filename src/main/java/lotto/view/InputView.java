package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constants;

import static lotto.Constants.*;

public class InputView {


    public static String getMoney(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String getWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
