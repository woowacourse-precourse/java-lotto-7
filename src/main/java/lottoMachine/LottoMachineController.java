package lottoMachine;

import calculate.LotteryResultCalculator;
import calculate.LottoTotalReturnCalculator;
import java.util.List;
import lotto.Lotties;
import lottoBonusNumber.LottoBonusNumberController;
import lottoPurchaseAmount.LottoPurchaseAmountController;
import lottoRank.LottoRankResultProcessor;
import lottoWinningNumber.LottoWinningNumberController;
import calculate.LottoQuantityCalculator;

public class LottoMachineController {
    private final LottoPurchaseAmountController lottoPurchaseAmountController;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final Lotties lotties;
    private final LottoWinningNumberController lottoWinningNumberController;
    private final LottoNumberPrinter LottoNumberPrinter;
    private final LottoRankResultProcessor lottoRankResultProcessor;

    public LottoMachineController() {
        lottoPurchaseAmountController = new LottoPurchaseAmountController();
        lottoNumberGenerator = new LottoNumberGenerator();
        lotties = new Lotties();
        lottoWinningNumberController = new LottoWinningNumberController();
        LottoNumberPrinter = new LottoNumberPrinter();
        lottoRankResultProcessor = new LottoRankResultProcessor();
    }

    public void run() {
        int lottoPurchaseAmount = lottoPurchaseAmountController.getPurchaseAmount();
        issueLottoTickets(lottoPurchaseAmount);

        List<Integer> lottoWinningNumber = lottoWinningNumberController.getWinningNumbers();
        LottoBonusNumberController lottoBonusNumberController = new LottoBonusNumberController(lottoWinningNumber);
        int lottoBonusNumber = lottoBonusNumberController.getBonusNumber();

        issueLotteryResult(lottoPurchaseAmount, lottoWinningNumber, lottoBonusNumber);
    }

    private void issueLottoTickets(int lottoPurchaseAmount) {
        LottoQuantityCalculator lottoQuantityCalculator = new LottoQuantityCalculator(lottoPurchaseAmount);
        int lottoQuantity = lottoQuantityCalculator.runAndBringLottoQuantity();

        processLottoTickets(lottoQuantity);
    }

    private void processLottoTickets(int lottoQuantity) {
        for (int amountOfLottoNumbersIssued = 1; amountOfLottoNumbersIssued <= lottoQuantity;
             amountOfLottoNumbersIssued++) {
            List<Integer> generatedLottoNumbers = lottoNumberGenerator.generateLottoNumbers();

            LottoNumberPrinter.printThisLottoNumber(generatedLottoNumbers);
            lotties.addLotto(generatedLottoNumbers);
        }
    }

    private void issueLotteryResult(int lottoPurchaseAmount, List<Integer> lottoWinningNumber, int lottoBonusNumber) {
        LotteryResultCalculator lotteryResultCalculater = new LotteryResultCalculator(lottoWinningNumber,
                lottoBonusNumber, lottoRankResultProcessor, lotties);
        lotteryResultCalculater.calculateLotteryResult();

        lottoRankResultProcessor.printStatistics();

        long totalWinningAmount = lottoRankResultProcessor.calculateTotalPrize();

        LottoTotalReturnCalculator lottoTotalReturnCalculator = new LottoTotalReturnCalculator(totalWinningAmount,
                lottoPurchaseAmount);
        lottoTotalReturnCalculator.run();
    }
}
