package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.console.ConsoleManager;
import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;
import lotto.model.Amount;

import java.util.regex.Pattern;

import static lotto.console.ConsoleManager.*;

public class InputView {
    public Amount getAmount(){
        println("구입금액을 입력해 주세요.");
        return new Amount(
                Validator.validateAmount(Console.readLine()));
    }
    private static class Validator{
        static String validateAmount(String input){
            isNotNumeric(input);
            isMinus(input);
            isBlank(input);
            return input;
        }

        private static void isBlank(String input){
            if(input.isEmpty()){
                throw new InputException(ExceptionMessage.BLANK_INPUT_ERROR);
            }
        }

        private static void isNotNumeric(String input) {
            String regex = "^[0-9]*$";
            if(!Pattern.matches(regex, input)){
                throw new InputException(ExceptionMessage.INVALID_INPUT_ERROR);
            }
        }
        private static void isMinus(String input){
            int num = Integer.parseInt(input);
            if(num < 0){
                throw new InputException(ExceptionMessage.MINUS_PRICE_ERROR);
            }
        }
    }
}
