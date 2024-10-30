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
        PurchasePrice purchasePrice = doPurchase();
        LottoQuantity lottoQuantity = LottoQuantity.findQuantity(purchasePrice.value());
        Lottos lottos = LottoApplication.buyLottos(lottoQuantity, makeNumbersStrategy, printer);
        WinNumbers winNumbers = LottoApplication.readAllWinNumbers(printer, reader);
        PrizeNumber prizeNumber = LottoApplication.findWinningLottos(winNumbers, lottos);
        calculateResult(purchasePrice, prizeNumber);
    }

    private PurchasePrice doPurchase() {
        printer.print("구입금액을 입력해 주세요.");
        PurchasePrice purchasePrice;
        String originPrice = reader.read();
        try {
            purchasePrice = PurchasePrice.validatePrice(originPrice); //가격 관련 throw해주는 부분
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return doPurchase();
        }
        return purchasePrice;
    }

    private void calculateResult(PurchasePrice purchasePrice, PrizeNumber prizeNumber) {
        int totalPrize = prizeNumber.calculateTotalPrize();
        double profit = calculator.calculateProfit(totalPrize, purchasePrice.value());
        printer.printPrizeResult(prizeNumber.sortByRank(), profit);
    }
}
