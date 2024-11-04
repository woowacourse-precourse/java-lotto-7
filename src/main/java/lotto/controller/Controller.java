package lotto.controller;

import lotto.model.*;
import lotto.view.MoneyInputView;
import lotto.view.NumberInputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public void run() {
        Money money = getMoney();

        Lottos lottos = purchaseLottos(money);
        OutputView.printLottoNumbers(lottos);

        WinningLotto winningLotto = createWinningLotto();
        Result result = lottos.matchWinningLotto(winningLotto);
        OutputView.printResult(result);

        PrizeRate prizeRate = money.calculatePrizeRate(result);
        OutputView.printPrizeRate(prizeRate.getPrizeRate());
    }

    private Money getMoney() {
        int money = MoneyInputView.inputMoney();
        return new Money(money);
    }

    private Lottos purchaseLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money.getLottoTicket(); i++) {
            Lotto lotto = LottoGenerator.createLotto();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private WinningLotto createWinningLotto() {
        Lotto winningNumbers = LottoGenerator.createLotto(getWinningNumbers());
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        return NumberInputView.getWinningNumbers();
    }

    private BonusNumber getBonusNumber(Lotto winningNumbers) {
        int number = NumberInputView.getBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(number);

        try {
            bonusNumber.validate(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }
}
