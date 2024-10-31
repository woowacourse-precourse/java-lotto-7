package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.ValidChecker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public String validateEmptyAndReturnInput(){
        String input = Console.readLine();
            if (input.isEmpty()) {
                System.out.println("[ERROR] 빈 입력은 허용되지 않습니다.");
                throw new IllegalArgumentException();
            }

        return input;
    }

    public BigInteger validateMoney(String money){
        ValidChecker checker = new ValidChecker();
        checker.notInt(money);
        return new BigInteger(money);
    }

    public int validateBonusNumber(String number){
        ValidChecker checker = new ValidChecker();
        checker.notInt(number);
        checker.checkUnderMaximum(Integer.parseInt(number));
        return Integer.parseInt(number);
    }

    public List<Integer> validateAndReturnNumbers(String input) {
        ValidChecker checker = new ValidChecker();
        checker.notContainComma(input);
        checker.notSixNumbers(input);
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String part : parts){
            checker.notInt(part);
            checker.checkUnderMaximum(Integer.parseInt(part));
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }
}
