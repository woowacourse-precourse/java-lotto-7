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
        return new Amount(Console.readLine());
    }
    public Lotto getWinning(){
        println("당첨 번호를 입력해 주세요.");
        return new Lotto(Console.readLine());
    }

}
