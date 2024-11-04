package lotto.controller;

import lotto.domain.buyer.Buyer;
import lotto.domain.buyer.BuyerFactory;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;
import lotto.domain.winning.LottoMatcher;
import lotto.domain.winning.WinningInfo;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputHandler;
import lotto.view.InputView;

public class Controller {
    private final InputHandler inputHandler;
    private final InputView inputView;

    public Controller(final InputHandler inputHandler, final InputView inputView) {
        this.inputHandler = inputHandler;
        this.inputView = inputView;
    }

    public void run() {
        String inputMoney = inputView.inputMoney();
        int money = inputHandler.stringToNumber(inputMoney);

        Buyer buyer = BuyerFactory.createBuyer(money);
        System.out.print(buyer.getbuyLottos().toString());

        String inputWinningNumbers = inputView.inputWinningNumbers();
        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = inputHandler.stringToNumber(inputBonusNumber);

        Numbers lottoNumbers = inputHandler.splitLottoNumbers(inputWinningNumbers);
        Number bonus = Number.from(bonusNumber);

        WinningInfo winningInfo = WinningInfo.of(lottoNumbers, bonus);
        LottoMatcher lottoMatcher = new LottoMatcher();
        WinningStatistics winningStatistics = WinningStatistics.of(lottoMatcher, buyer);
        winningStatistics.calculateWinningStatistics(buyer, winningInfo);

        System.out.print(winningStatistics.toString());
    }
}
