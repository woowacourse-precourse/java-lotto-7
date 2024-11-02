package lotto.utils;

import lotto.LottoMachine;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoCenter;
import lotto.domain.LottoDrawer;
import lotto.domain.LottoProcessor;
import lotto.domain.LottoResultPrinter;
import lotto.domain.RandomLottoResult;
import lotto.domain.calculator.Calculator;
import lotto.domain.calculator.PurchaseCalculator;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.domain.lottoGeneratir.RandomLottoGenerator;
import lotto.domain.lottoMatchChecker.DefaultLottoMatchChecker;
import lotto.domain.lottoMatchChecker.LottoMatchChecker;

public class AppConfig {
    public LottoProcessor lottoProcessor(){
        return new LottoProcessor(calculator(), lottoDrawer(), lottoGenerator(), randomLottoResult());
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
    public RandomLottoResult randomLottoResult(){
        return new RandomLottoResult();
    }
    public LottoCenter lottoCenter() {
        return new LottoCenter(lottoGenerator());
    }
    public LottoMatchChecker lottoMatchChecker(){return new DefaultLottoMatchChecker();}
    public LottoResultPrinter lottoResultPrinter() {return new LottoResultPrinter();}
    public LottoMachine lottoMachine(){
        return new LottoMachine(lottoProcessor(), lottoBuyer(),lottoCenter(), lottoMatchChecker(), lottoResultPrinter());
    }
}
