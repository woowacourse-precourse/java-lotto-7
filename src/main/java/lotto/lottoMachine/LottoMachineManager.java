package lotto.lottoMachine;

import lotto.lottoMachine.calculateManager.LotteryResultManager;
import lotto.lottoMachine.calculateManager.LottoTotalReturnManager;
import java.util.List;
import lotto.Lotties;
import lotto.lottoMachine.lottoBonusNumber.LottoBonusNumberManager;
import lotto.lottoMachine.lottoPurchaseAmount.LottoPurchaseAmountManager;
import lotto.lottoMachine.lottoTotalResult.LottoTotalResultManager;
import lotto.lottoMachine.lottoWinningNumber.LottoWinningNumberManager;
import lotto.lottoMachine.calculateManager.LottoQuantityManager;

public class LottoMachineManager {
    private final LottoPurchaseAmountManager lottoPurchaseAmountManager;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final Lotties lotties;
    private final LottoWinningNumberManager lottoWinningNumberManager;
    private final LottoNumberPrinter LottoNumberPrinter;
    private final LottoTotalResultManager LottoTotalResultManager;

    public LottoMachineManager() {
        lottoPurchaseAmountManager = new LottoPurchaseAmountManager();
        lottoNumberGenerator = new LottoNumberGenerator();
        lotties = new Lotties();
        lottoWinningNumberManager = new LottoWinningNumberManager();
        LottoNumberPrinter = new LottoNumberPrinter();
        LottoTotalResultManager = new LottoTotalResultManager();
    }

    public void run() {
        int lottoPurchaseAmount = lottoPurchaseAmountManager.getPurchaseAmount();
        issueLottoTickets(lottoPurchaseAmount);

        List<Integer> lottoWinningNumber = lottoWinningNumberManager.getWinningNumbers();
        LottoBonusNumberManager lottoBonusNumberManager = new LottoBonusNumberManager(lottoWinningNumber);
        int lottoBonusNumber = lottoBonusNumberManager.getBonusNumber();

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
                lottoBonusNumber, LottoTotalResultManager, lotties);
        lotteryResultManager.manageLotteryResults();

        LottoTotalResultManager.printStatistics();

        long totalWinningAmount = LottoTotalResultManager.calculateTotalPrize();

        LottoTotalReturnManager lottoTotalReturnManager = new LottoTotalReturnManager(totalWinningAmount,
                lottoPurchaseAmount);
        lottoTotalReturnManager.calculate();
    }
}
