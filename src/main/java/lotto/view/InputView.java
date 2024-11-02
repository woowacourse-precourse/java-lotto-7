package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import static lotto.console.ConsoleManager.*;

public class InputView {
    public Amount getAmount(){
        println("구입금액을 입력해 주세요.");
        return new Amount(Console.readLine());
    }
    public WinningNumbers getWinning(){
        println("당첨 번호를 입력해 주세요.");
        return new WinningNumbers(new Lotto(Console.readLine()));
    }

}
