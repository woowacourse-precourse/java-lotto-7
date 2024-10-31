package lotto.view;

import lotto.utils.Utils;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.message.LottoMessage.*;

public class InputView {

    public static int inputBuyAmount(){
        print(INPUT_BUY_AMOUNT.getMessage());
        return Utils.stringToInteger(readLine());
    }

    private static void print(String message){
        System.out.println(message);
    }
}
