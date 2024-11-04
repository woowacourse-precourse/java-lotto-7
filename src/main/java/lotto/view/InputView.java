package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.console.ConsoleManager;
import lotto.exception.InputException;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.WinningNumbers;

import static lotto.console.ConsoleManager.*;

public class InputView {
    public Amount getAmount(){
        println("구입금액을 입력해 주세요.");
        try{
            return new Amount(toNumeric(Console.readLine()));
        }catch(InputException e){
            return getAmount();
        }
    }
    public Lotto getWinning(){
        println("당첨 번호를 입력해 주세요.");
        try{
            return new Lotto(toNumberList(Console.readLine()));
        }catch(InputException e){
            return getWinning();
        }
    }

    public Number getBonus(){
        println("보너스 번호를 입력해 주세요.");
        try{
            return new Number(toNumeric(Console.readLine()));
        }catch(InputException e){
            return getBonus();
        }
    }

}
