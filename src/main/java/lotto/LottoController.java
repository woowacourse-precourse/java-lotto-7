package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.service.Input;
import lotto.service.LottoService;
import lotto.service.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    Input inputMethod = new Input();
    Output outputMethod = new Output();
    LottoService lottoService = new LottoService();

    public void start(){
        try {
            outputMethod.buyMoney();
            int money = inputMethod.convertToMoney(Console.readLine());
            outputMethod.buyLotto(money/1000);
            Map<Integer,Lotto> lottoNumList = lottoService.makeLottoNum(money/1000);
            outputMethod.getWinningNumber();
            Lotto winningNum = inputMethod.inputLottoNum(Console.readLine());
            outputMethod.getBounsNumber();
            int bounsNum = inputMethod.cehckBonusNum(Console.readLine(),winningNum);
            outputMethod.line();
            lottoService.checkRank(lottoNumList,winningNum,bounsNum,money);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
