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
        printer.print("구입금액을 입력해 주세요.");
        String originPrice = reader.read();
        PurchasePrice purchasePrice = PurchasePrice.validatePrice(originPrice);
        LottoQuantity lottoQuantity = LottoQuantity.findQuantity(purchasePrice);
        Lottos lottos = Lottos.of(lottoQuantity, makeNumbersStrategy);
        printer.printPurchaseResult(lottoQuantity.value(), lottos);

        printer.print("\n당첨 번호를 입력해 주세요.");
        String originWinNumbers = reader.read();
        WinNumbers winNumbersWithOutBonusNumber = WinNumbers.winNumbersFrom(originWinNumbers);

        printer.print("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = reader.read();
        WinNumbers winNumbers = winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);

        PrizeNumber prizeNumber = lottoApplication.run(lottoQuantity, winNumbers, lottos);
        calculateResult(purchasePrice, prizeNumber);
    }

    private void calculateResult(PurchasePrice purchasePrice, PrizeNumber prizeNumber) {
        int totalPrize = calculator.calculateTotalPrize(prizeNumber);
        double profit = calculator.calculateProfit(totalPrize, purchasePrice.value());

        printer.printPrizeResult(prizeNumber, profit);
    }
}
