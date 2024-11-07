package lotto.view;

import lotto.utils.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.message.InputMessage.*;
import static lotto.utils.Utils.*;
import static lotto.Constants.*;
public class InputView {

    public static int inputBuyAmount(){
        while (true){
            try{
                print(INPUT_BUY_AMOUNT.getMessage());
                return Utils.stringToInteger(readLine());
            }catch (IllegalArgumentException e){
                print(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers(){
        while(true){
            try{
                print(NEW_LINE + INPUT_WINNING_NUMBERS.getMessage());
                return Utils.parseAndconvertToIntegerList(readLine(), DELIMITER);
            }catch (IllegalArgumentException e){
                print(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber(){
        while(true){
            try{
                print(NEW_LINE + INPUT_BONUS_NUMBER.getMessage());
                return Utils.stringToInteger(readLine());
            }catch (IllegalArgumentException e){
                print(e.getMessage());
            }
        }
    }

}
