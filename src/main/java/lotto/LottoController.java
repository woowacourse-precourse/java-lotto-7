package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoBuyer lottoBuyer = createLottoBuyerWithLottos(purchaseAmount);
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);

        Output.printWinningResultsHeader();
        Output.printLine();

        List<LottoWinningRanks> lottoWinningRanks = getLottoWinningRanks(lottoBuyer, winningNumber, bonusNumber);
        Map<LottoWinningRanks, Integer> rankCounts = aggregateLottoRanks(lottoWinningRanks);

        printLottoRankResults(rankCounts);
        printRateOfReturn(lottoWinningRanks, lottoBuyer);
    }

    private PurchaseAmount getPurchaseAmount() {
        Output.printPurchaseAmountRequestMessage();
        return Input.getPurchaseAmount();
    }

    private LottoBuyer createLottoBuyerWithLottos(PurchaseAmount purchaseAmount) {
        LottoBuyer lottoBuyer = lottoService.getLottoBuyer(purchaseAmount);
        Output.printNumberRequestMessage(lottoBuyer.getLottoCount());
        Output.printLottos(lottoBuyer.getLottos());
        return lottoBuyer;
    }

    private WinningNumber getWinningNumber() {
        Output.printWinningNumberRequestMessage();
        return Input.getWinningNumber();
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        Output.printBonusNumberRequestMessage();
        return Input.getBonusNumber(winningNumber);
    }

    private List<LottoWinningRanks> getLottoWinningRanks(LottoBuyer lottoBuyer, WinningNumber winningNumber, BonusNumber bonusNumber) {
        return lottoService.summarizeLottoRanks(lottoBuyer.getLottos(), winningNumber, bonusNumber);
    }

    private Map<LottoWinningRanks, Integer> aggregateLottoRanks(List<LottoWinningRanks> lottoWinningRanks) {
        return lottoService.summarizeRanksToCounts(lottoWinningRanks);
    }

    private void printLottoRankResults(Map<LottoWinningRanks, Integer> rankCounts) {
        Output.printLottoRankResult(rankCounts);
    }

    private void printRateOfReturn(List<LottoWinningRanks> lottoWinningRanks, LottoBuyer lottoBuyer) {
        Output.printRateOfReturn(lottoService.calculateRateOfReturn(lottoWinningRanks, lottoBuyer));
    }
}
