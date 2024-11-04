package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public long InputPayment(){
        String payment = Console.readLine();
        validateIsNumber(payment);
        return Long.parseLong(payment);
    }
    private static void validateIsNumber(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
    }

}
