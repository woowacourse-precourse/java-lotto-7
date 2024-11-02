package lotto.controller;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        Money money = getMoney();
        outputView.showTicket(money.getTicket());

        List<Lotto> lottos = getLottos(money);
        outputView.showLottos(lottos);
    }

    private Money getMoney() {
        while (true) {
            try {
                int moneyInput = inputView.inputMoney();
                return new Money(moneyInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        while (true) {
            try {
                return lottoGenerator.generateLottoGroup(money.getTicket());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
