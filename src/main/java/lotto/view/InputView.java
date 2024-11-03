package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Amount;
import lotto.model.Number;
import lotto.model.WinningNumbers;

import static lotto.console.ConsoleManager.*;
import static lotto.validate.Validator.*;

public class InputView {
    public Amount getAmount(){
        println("구입금액을 입력해 주세요.");
        return new Amount(toNumeric(Console.readLine()));
    }
    public WinningNumbers getWinning(){
        println("당첨 번호를 입력해 주세요.");
        return new WinningNumbers(Console.readLine());
    }

    public Number getBonus(){
        println("보너스 번호를 입력해 주세요.");
        return new Number(toNumeric(Console.readLine()));
    }

}
