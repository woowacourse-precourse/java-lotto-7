package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistic;
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