package lotto.view;

import lotto.utils.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.message.LottoMessage.*;

public class InputView {
    private static final String DELIMITER = ",";

    public static int inputBuyAmount(){
        print(INPUT_BUY_AMOUNT.getMessage());
        return Utils.stringToInteger(readLine());
    }

    public static List<Integer> inputWinningNumbers(){
        print(INPUT_WINNING_NUMBERS.getMessage());
        return Utils.parseAndconvertToIntegerList(readLine(), DELIMITER);
    }

    private static void print(String message){
        System.out.println(message);
    }
}
