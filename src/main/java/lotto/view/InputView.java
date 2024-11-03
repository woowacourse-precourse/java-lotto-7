package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getLottoBuyMoney(){
        String msg = Console.readLine();
        InputValidator.validateInput(msg);
        return Integer.parseInt(msg);
    }

    public List<Integer> getWinningLottoNum(){
        String msg = Console.readLine();
        InputValidator.validateInput(msg);
        return Arrays.stream(msg.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer getBonnusLottoNum(){
        String msg = Console.readLine();
        InputValidator.validateInput(msg);
        return Integer.parseInt(msg);
    }
}
