package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;

public class LottoValueUtil {
    public static int toLottoAmount(String input) {
        try{
            int amount = Integer.parseInt(input);
            if(amount >= 1000 && amount % 1000 == 0){
                return amount;
            }
            throw new IllegalArgumentException();
        } catch (NumberFormatException e){
            ExceptionHandler.inputException(ErrorMessage.INVALID_AMOUNT);
        } catch (IllegalArgumentException e){
            ExceptionHandler.inputException(ErrorMessage.INVALID_AMOUNT);
        }
        return -1;
    }
}
