package lotto.application;

import lotto.config.AppConfig;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.PrizeNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinNumbers;

public class ScenarioApplication {

    private final MakeNumbersStrategy makeNumbersStrategy;
    private final Reader reader;
    private final Calculator calculator;
    private final Printer printer;

    public ScenarioApplication(AppConfig appConfig) {
        this.makeNumbersStrategy = appConfig.makeNumbersStrategy();
        this.reader = appConfig.reader();
        this.calculator = appConfig.calculator();
        this.printer = appConfig.printer();
    }

    public void run() {
        LottoApplication lottoApplication = new LottoApplication(makeNumbersStrategy, calculator);
        String originPrice = reader.read();
        PurchasePrice purchasePrice = PurchasePrice.validatePrice(originPrice);
        LottoQuantity lottoQuantity = LottoQuantity.findQuantity(purchasePrice);

        String originWinNumbers = reader.read();
        WinNumbers winNumbersWithOutBonusNumber = WinNumbers.winNumbersFrom(originWinNumbers);
        String bonusNumber = reader.read();
        WinNumbers winNumbers = winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);

        Lottos lottos = Lottos.of(lottoQuantity, makeNumbersStrategy);
        PrizeNumber prizeNumber = lottoApplication.run(lottoQuantity, winNumbers, lottos);
        calculateResult(purchasePrice, prizeNumber);

        printResult(lottoQuantity, lottos);
    }

    private void calculateResult(PurchasePrice purchasePrice, PrizeNumber prizeNumber) {
        int totalPrize = calculator.calculateTotalPrize(prizeNumber);
        calculator.calculateProfit(totalPrize, purchasePrice.value());
    }

    private void printResult(LottoQuantity lottoQuantity, Lottos lottos) {
        printer.printPurchaseResult(lottoQuantity.value(), lottos);
    }
}
