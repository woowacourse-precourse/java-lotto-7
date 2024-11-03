package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCompany;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.WinningLotto;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {

    public void run() {
        // 금액 입력 및 구매
        Money money = getMoney();
        Lottos lottos = getLottos(money);
        printLottoStatus(lottos);

        // 당첨 번호 입력
        WinningLotto winningLotto = getWinningLotto();
        LottoCompany lottoCompany = new LottoCompany(winningLotto, money);

        // 당첨 결과 파악 및 수익률 출력
        PrizeResult prizeResult = lottoCompany.getWinningResults(lottos.getLottos());
        printResult(prizeResult);
        printRateOfReturn(money.getRateOfReturn());
    }

    private Money getMoney() {
        InputHandler inputHandler = new InputHandler();
        long givenMoney = inputHandler.getInputForPurchaseMoney();
        return new Money(givenMoney);
    }

    private Lottos getLottos(Money money) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.buyLottos(money.getTicket());
    }

    private WinningLotto getWinningLotto() {
        InputHandler inputHandler = new InputHandler();
        List<Integer> winningLottoNumbers = inputHandler.getInputForWinningNumber();
        Integer bonusNumber = inputHandler.getInputForBonusNumber();
        return new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
    }

    private void printLottoStatus(Lottos lottos) {
        new OutputHandler().printLottoStatus(lottos);
    }

    private void printResult(PrizeResult prizeResult) {
        new OutputHandler().printLottoResults(prizeResult.getPrizeResult());
    }

    private void printRateOfReturn(double rateOfReturn) {
        new OutputHandler().printRateOfReturn(rateOfReturn);
    }
}
