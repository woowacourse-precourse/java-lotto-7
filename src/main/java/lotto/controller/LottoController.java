package lotto.controller;

import lotto.domain.*;
import lotto.utils.Calculator;
import lotto.utils.LottoMatcher;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Money money = getValidPurchasePrice();

        Person person = new Person(money);
        LottoMachine lottoMachine = new LottoMachine();
        Seller seller = new Seller(lottoMachine);
        seller.sellLottoTo(person);

        OutputView.printLottos(person.getLottos());

        WinningNumber winningNumber = getValidWinningNumber();
        BonusNumber bonusNumber = getValidBonusNumber();

        Lottos lottos = person.getLottos();
        Long totalPrizeMoney = lottos.getTotalPrizeMoney(winningNumber, bonusNumber);

        OutputView.printTotalResult();

        double yield = Calculator.calculateYield(totalPrizeMoney, money);
        OutputView.printYield(yield);
    }

    private Money getValidPurchasePrice() {
        while (true) {
            try {
                return InputView.readPurchasePrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumber getValidWinningNumber() {
        while (true) {
            try {
                return InputView.readWinningNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber getValidBonusNumber() {
        while (true) {
            try {
                return InputView.readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
