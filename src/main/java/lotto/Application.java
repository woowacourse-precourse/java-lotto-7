package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.handler.MoneyInputHandler;

import static lotto.view.RequestView.getMoney;

public class Application {
    public static void main(String[] args) {
        MoneyInputHandler moneyInputHandler = new MoneyInputHandler();
        long lottoCount = moneyInputHandler.getLottoCount(getMoney());

        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.issue(lottoCount);
    }
}
