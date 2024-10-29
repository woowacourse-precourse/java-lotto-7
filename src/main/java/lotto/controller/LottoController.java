package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCompany;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.util.Validator;
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
        LottoCompany lottoCompany = new LottoCompany(winningLotto);

        // 당첨 여부를 파악하는 기능
    }

    private Money getMoney() {
        InputHandler inputHandler = new InputHandler(new Validator());
        int givenMoney = inputHandler.getInputForPurchaseMoney();
        return new Money(givenMoney);
    }

    private WinningLotto getWinningLotto() {
        InputHandler inputHandler = new InputHandler(new Validator());
        List<Integer> winningLottoNumbers = inputHandler.getInputForWinningNumber();
        Integer bonusNumber = inputHandler.getInputForBonusNumber();
        return new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
    }

    private Lottos getLottos(Money money) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.buyLottos(money.getTicket());
    }

    private void printLottoStatus(Lottos lottos) {
        new OutputHandler().printLottoStatus(lottos);
    }
}
