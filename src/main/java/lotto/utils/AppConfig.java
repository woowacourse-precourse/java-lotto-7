package lotto.utils;

import lotto.LottoMachine;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoDrawer;
import lotto.domain.LottoProcessor;
import lotto.domain.calculator.Calculator;
import lotto.domain.calculator.PurchaseCalculator;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.domain.lottoGeneratir.RandomLottoGenerator;

public class AppConfig {
    public LottoProcessor lottoProcessor(){
        return new LottoProcessor(calculator(), lottoDrawer(), lottoGenerator(), lottoBuyer());
    }
    public LottoBuyer lottoBuyer(){
        return new LottoBuyer();
    }
    public Calculator calculator(){
        return new PurchaseCalculator();
    }
    public LottoGenerator lottoGenerator(){
        return new RandomLottoGenerator();
    }
    public LottoDrawer lottoDrawer(){
        return new LottoDrawer();
    }
    public LottoMachine lottoMachine(){
        return new LottoMachine(lottoProcessor(), lottoBuyer(), calculator(), lottoGenerator(), lottoDrawer());
    }
}
