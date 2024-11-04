package lotto.lottoMachine;

import lotto.calculateManager.LotteryResultManager;
import lotto.calculateManager.LottoTotalReturnManager;
import java.util.List;
import lotto.Lotties;
import lotto.lottoMachine.lottoBonusNumber.LottoBonusNumberController;
import lotto.lottoMachine.lottoPurchaseAmount.LottoPurchaseAmountController;
import lotto.lottoMachine.lottoRank.LottoRankResultProcessor;
import lotto.lottoMachine.lottoWinningNumber.LottoWinningNumberController;
import lotto.calculateManager.LottoQuantityManager;

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
        LottoQuantityManager lottoQuantityManager = new LottoQuantityManager(lottoPurchaseAmount);
        int lottoQuantity = lottoQuantityManager.getLottoQuantity();

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
        LotteryResultManager lotteryResultManager = new LotteryResultManager(lottoWinningNumber,
                lottoBonusNumber, lottoRankResultProcessor, lotties);
        lotteryResultManager.manageLotteryResults();

        lottoRankResultProcessor.printStatistics();

        long totalWinningAmount = lottoRankResultProcessor.calculateTotalPrize();

        LottoTotalReturnManager lottoTotalReturnManager = new LottoTotalReturnManager(totalWinningAmount,
                lottoPurchaseAmount);
        lottoTotalReturnManager.calculate();
    }
}
