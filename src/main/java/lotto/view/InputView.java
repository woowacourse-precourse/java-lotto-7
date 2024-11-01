package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;
import lotto.model.Amount;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.console.ConsoleManager.*;

public class InputView {
    public Amount getAmount(){
        println("구입금액을 입력해 주세요.");
        String amount = Validator.validateAmount(Console.readLine());
        return new Amount(Integer.parseInt(amount));
    }
    public Lotto getWinning(){
        println("당첨 번호를 입력해 주세요.");
        String line = Validator.validateWinning(Console.readLine());
        List<Integer> numbers = lineToNumbers(line);
        return new Lotto(numbers);
    }

    private static List<Integer> lineToNumbers(String line) {
        String[] splitLine = line.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : splitLine) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    private static class Validator{
        static String validateWinning(String input){
            String[] splitNumber = input.split(",");
            for (String number : splitNumber) {
                isNotNumeric(number);
            }
            return input;
        }
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
