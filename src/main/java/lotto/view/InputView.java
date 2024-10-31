package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getAmount(){
        return Validator.validateAmount(Console.readLine());
    }
    private static class Validator{
        static String validateAmount(String input){

            return input;
        }
    }
}
