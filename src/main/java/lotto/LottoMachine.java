package lotto;

import static java.lang.Math.floorDiv;

import lotto.buying.BuyingAmount;
import lotto.config.AppConfig;
import lotto.io.input.BonusNumberInputConsoleHandler;
import lotto.io.input.BuyingAmountInputConsoleHandler;
import lotto.io.input.WinningNumbersInputConsoleHandler;
import lotto.io.output.WinningResultStatisticsOutputConsoleHandler;
import lotto.lotto.BonusNumber;
import lotto.lotto.Lottos;
import lotto.lotto.WinningNumbers;
import lotto.lotto.providable.NumbersProvidable;
import lotto.winningResult.RevenueRate;
import lotto.winningResult.TotalWinningResult;

public class LottoMachine {
    private final NumbersProvidable numbersProvider;
    private final BuyingAmountInputConsoleHandler buyingAmountInputConsoleHandler;
    private final WinningNumbersInputConsoleHandler winningNumbersInputConsoleHandler;
    private final BonusNumberInputConsoleHandler bonusNumberInputConsoleHandler;
    private final WinningResultStatisticsOutputConsoleHandler winningResultStatisticsOutputConsoleHandler;

    public LottoMachine(AppConfig config) {
        this.numbersProvider = config.getNumbersProvidable();
        this.buyingAmountInputConsoleHandler = config.getBuyingAmountInputConsoleHandler();
        this.winningNumbersInputConsoleHandler = config.getWinningNumbersInputConsoleHandler();
        this.bonusNumberInputConsoleHandler = config.getBonusNumberInputConsoleHandler();
        this.winningResultStatisticsOutputConsoleHandler = config.getWinningResultStatisticsOutputConsoleHandler();
    }

    public void run() {
        BuyingAmount buyingAmount = tryReadBuyingAmount();
        Lottos lottos = tryMakeLottos(buyingAmount);
        WinningNumbers winningNumbers = tryReadWinningNumber();
        BonusNumber bonusNumber = tryReadBonusNumber();

        TotalWinningResult totalWinningResult = TotalWinningResult.from(
                winningNumbers.matchWinningNumbersTo(lottos, bonusNumber));

        RevenueRate revenueRate = RevenueRate.of(buyingAmount, totalWinningResult.getWinningResultMap());

        winningResultStatisticsOutputConsoleHandler.showWinningResultStatistics(
                totalWinningResult.getPrintableWinningResultMap()
        );
        winningResultStatisticsOutputConsoleHandler.showTotalRevenue(revenueRate.getRevenueRate());

    }

    private BuyingAmount tryReadBuyingAmount() {
        while (true) {
            try {
                buyingAmountInputConsoleHandler.showBuyingAmountGuideMessage();
                return BuyingAmount.from(buyingAmountInputConsoleHandler.askBuyingAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos tryMakeLottos(BuyingAmount buyingAmount) {
        int numOfLottos = floorDiv(buyingAmount.getBuyingAmount(), 1000);

        buyingAmountInputConsoleHandler.showLottoPurchasingResult(numOfLottos);

        Lottos lottos = Lottos.of(numOfLottos, numbersProvider);
        System.out.println(lottos);

        return lottos;
    }


    private WinningNumbers tryReadWinningNumber() {
        while (true) {
            try {
                winningNumbersInputConsoleHandler.showWinningNumberGuideMessage();
                return WinningNumbers.of(winningNumbersInputConsoleHandler.askWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber tryReadBonusNumber() {
        while (true) {
            try {
                bonusNumberInputConsoleHandler.showBonusNumberGuideMessage();
                return BonusNumber.from(bonusNumberInputConsoleHandler.askBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
