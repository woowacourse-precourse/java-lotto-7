package lotto;

import lotto.domain.common.Price;
import lotto.domain.lotto.Lottos;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;
import lotto.domain.winner.WinningStatistic;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoController {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void play() {
        Price price = getPriceFromUser();
        Lottos lottos = purchaseLottos(price);
        WinningNumbers winningNumbers = getWinningNumbersFromUser();
        BonusNumber bonusNumber = getBonusNumberFromUser();

        LotteryMachine lotteryMachine = new LotteryMachine(winningNumbers, bonusNumber);
        WinningStatistic winningStatistic = generateWinningStatistic(lotteryMachine, lottos, price);
        showWinningStatistic(winningStatistic);
    }

    private Price getPriceFromUser() {
        outputHandler.showPriceInputNavigateMessage();
        return inputHandler.getPriceFromUser();
    }

    private Lottos purchaseLottos(Price price) {
        LotteryCashier lotteryCashier = new LotteryCashier();
        Lottos lottos = lotteryCashier.purchaseBy(price);
        outputHandler.showPurchasedLottos(lottos);
        return lottos;
    }

    private WinningNumbers getWinningNumbersFromUser() {
        outputHandler.showWinningNumbersNavigateMessage();
        return inputHandler.getWinningNumbersFromUser();
    }

    private BonusNumber getBonusNumberFromUser() {
        outputHandler.showBonusNumberNavigateMessage();
        return inputHandler.getBonusNumberFromUser();
    }

    private WinningStatistic generateWinningStatistic(LotteryMachine lotteryMachine, Lottos lottos, Price price) {
        lotteryMachine.draw(lottos);
        return lotteryMachine.generateWinningStatisticBy(price);
    }

    private void showWinningStatistic(WinningStatistic winningStatistic) {
        outputHandler.showWinningStatistic(winningStatistic);
    }
}