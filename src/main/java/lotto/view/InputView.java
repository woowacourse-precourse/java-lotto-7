package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.ErrorMessage;
import java.util.List;

public class InputView {

    private static Integer buyAmount;

    private static List<String> winNumbers;

    public static void InputView(){
        buyAmount = inputBuyAmount();
    }

    public static Integer inputBuyAmount(){

        String inputBuyAmount = Console.readLine();

        //정수타입인지 확인
        if (validateBuyAmountNotNumber(inputBuyAmount)){
            throw new IllegalArgumentException(ErrorMessage.NOTNUMBERBUYAMOUNT.getMessage());
        }

        Integer buyAmount = Integer.parseInt(inputBuyAmount);

        //1000원 단위인지 확인
        if (validateBuyAmountNotPer1000(buyAmount)){
            throw new IllegalArgumentException(ErrorMessage.NOTPER1000BUYAMOUNT.getMessage());
        }


        return buyAmount;
    }

    private static boolean validateBuyAmountNotNumber(String buyAmountStr){
        try{
            Integer buyAmount =  Integer.parseInt(buyAmountStr);

            if (buyAmount <= 0){
                return true;
            }
        }catch (NumberFormatException e){
            return true;
        }
        return false;
    }

    private static boolean validateBuyAmountNotPer1000(Integer buyAmount){
        if (buyAmount % 1000 == 0){
            return false;
        }
        return true;
    }

}
