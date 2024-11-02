package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.validate.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.console.ConsoleManager.*;
import static lotto.validate.Validator.*;

public class InputView {
    public Amount getAmount(){
        println("구입금액을 입력해 주세요.");
        String amount = validateAmount(Console.readLine());
        return new Amount(Integer.parseInt(amount));
    }
    public Lotto getWinning(){
        println("당첨 번호를 입력해 주세요.");
        String line = validateWinning(Console.readLine());
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

}
