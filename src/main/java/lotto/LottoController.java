package lotto;

import lotto.domain.common.Price;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.winner.WinningNumbers;
import lotto.domain.winner.WinningStatistic;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoController {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();
    private final LotteryCashier lotteryCashier = new LotteryCashier();

    public void play() {
        outputHandler.showPriceInputNavigateMessage();
        Price price = inputHandler.getPriceFromUser();

        Lottos lottos = lotteryCashier.purchaseBy(price);
        outputHandler.showPurchasedLottos(lottos);

        outputHandler.showWinningNumbersNavigateMessage();
        WinningNumbers winningNumbers = inputHandler.getWinningNumbersFromUser();

        outputHandler.showBonusNumberNavigateMessage();
        BonusNumber bonusNumber = inputHandler.getBonusNumberFromUser();

        LotteryMachine lotteryMachine = new LotteryMachine(winningNumbers, bonusNumber);
        lotteryMachine.draw(lottos);
        WinningStatistic winningStatistic = lotteryMachine.generateWinningStatisticBy(price);
        outputHandler.showWinningStatistic(winningStatistic);
    }
}