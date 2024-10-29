package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.service.Input;
import lotto.service.Output;

import java.util.List;

public class LottoController {

    Input inputMethod = new Input();
    Output outputMethod = new Output();

    public void start(){
        outputMethod.buyMoney();
        int money = inputMethod.convertToMoney(Console.readLine());


        //List<Integer> lottoNum = inputMethod.inputLottoNum(Console.readLine());
    }
}
