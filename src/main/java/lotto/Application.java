package lotto;

import lotto.input.UserMoney;
import lotto.input.WinningNumbers;
import lotto.item.LottoMachine;
import lotto.item.LottoResult;
import lotto.item.ReturnCalculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserMoney userMoney = new UserMoney();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buy(userMoney.getMoney());
        lottoMachine.showLottos();

        WinningNumbers winningNumbers = new WinningNumbers();

        LottoResult lottoResult = new LottoResult(winningNumbers.getWinningNumbers(),
                winningNumbers.getBonusNumber(), lottos);
        lottoResult.printWinningResult();

        ReturnCalculator returnCalculator = new ReturnCalculator();
        returnCalculator.printReturnRate(userMoney.getMoney(), lottoResult.getTotalWinningAmounts());
    }
}