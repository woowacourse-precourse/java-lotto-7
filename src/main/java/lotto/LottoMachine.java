package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoCenter;
import lotto.domain.LottoProcessor;
import lotto.domain.LottoResultPrinter;
import lotto.domain.lottoMatchChecker.LottoMatchChecker;

public class LottoMachine {
    private LottoProcessor lottoProcessor;
    private LottoBuyer lottoBuyer;
    private LottoCenter lottoCenter;
    private LottoMatchChecker lottoMatchChecker;
    private LottoResultPrinter lottoResultPrinter;

    public LottoMachine(LottoProcessor lottoProcessor, LottoBuyer lottoBuyer, LottoCenter lottoCenter,
                        LottoMatchChecker lottoMatchChecker, LottoResultPrinter lottoResultPrinter) {
        this.lottoProcessor = lottoProcessor;
        this.lottoBuyer = lottoBuyer;
        this.lottoCenter = lottoCenter;
        this.lottoMatchChecker = lottoMatchChecker;
        this.lottoResultPrinter = lottoResultPrinter;
    }

    public void run(){
        lottoProcessor.purchaseProcess(lottoBuyer.purchaseLotto());
        lottoBuyer.receiveResult(lottoProcessor.createLotto());
        lottoCenter.drawWinningNumbers(lottoBuyer.drawWinningNumbers());
        lottoResultPrinter.printResult(
                lottoMatchChecker.countMatchingNumbers(
                        lottoCenter.getWinningLotto(),
                        lottoBuyer.getPurchasedLottos()),
                lottoBuyer.getReceipt());
    }
}
