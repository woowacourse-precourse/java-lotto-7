package lotto.view;

import lotto.utils.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.message.InputMessage.*;
import static lotto.utils.Utils.*;
import static lotto.Constants.*;
public class InputView {

    public static int inputBuyAmount(){
        print(INPUT_BUY_AMOUNT.getMessage());
        return Utils.stringToInteger(readLine());
    }

    public static List<Integer> inputWinningNumbers(){
        print(NEW_LINE + INPUT_WINNING_NUMBERS.getMessage());
        return Utils.parseAndconvertToIntegerList(readLine(), DELIMITER);
    }

    public static int inputBonusNumber(){
        print(NEW_LINE + INPUT_BONUS_NUMBER.getMessage());
        return Utils.stringToInteger(readLine());
    }

}
