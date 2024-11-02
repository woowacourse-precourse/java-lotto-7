package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoCenter;
import lotto.domain.LottoDrawer;
import lotto.domain.LottoProcessor;
import lotto.domain.calculator.Calculator;
import lotto.domain.lottoGeneratir.LottoGenerator;

public class LottoMachine {
    private LottoProcessor lottoProcessor;
    private LottoBuyer lottoBuyer;
    private Calculator calculator;
    private LottoGenerator lottoGenerator;
    private LottoDrawer lottoDrawer;
    private LottoCenter lottoCenter;

    public LottoMachine(LottoProcessor lottoProcessor, LottoBuyer lottoBuyer, Calculator calculator,
                        LottoGenerator lottoGenerator, LottoDrawer lottoDrawer) {
        this.lottoProcessor = lottoProcessor;
        this.lottoBuyer = lottoBuyer;
        this.calculator = calculator;
        this.lottoGenerator = lottoGenerator;
        this.lottoDrawer = lottoDrawer;
    }
    public void run(){
        lottoProcessor.purchaseProcess(lottoBuyer.purchaseLotto());
        lottoProcessor.createLotto();
        lottoCenter.drawWinningNumbers(lottoBuyer.drawWinningNumbers());
    }
}
