package lotto.application;

import lotto.config.AppConfig;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.PrizeNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinNumbers;

public class ScenarioApplication {

    private final MakingNumbersStrategy makingNumbersStrategy;
    private final Reader reader;
    private final Calculator calculator;
    private final Printer printer;
    private final PrizeNumber prizeNumber;

    public ScenarioApplication(AppConfig appConfig) {
        this.makingNumbersStrategy = appConfig.makeNumbersStrategy();
        this.reader = appConfig.reader();
        this.calculator = appConfig.calculator();
        this.printer = appConfig.printer();
        this.prizeNumber = appConfig.prizeNumber();
    }

    public void run() {
        PurchasePrice purchasePrice = doPurchase();
        LottoQuantity lottoQuantity = LottoQuantity.findQuantity(purchasePrice.value());
        Lottos lottos = buyLottos(lottoQuantity);
        WinNumbers winNumbers = readAllWinNumbers();
        prizeNumber.countWinningLottos(winNumbers, lottos);
        calculateResult(purchasePrice, prizeNumber);
    }

    private Lottos buyLottos(LottoQuantity lottoQuantity) {
        Lottos lottos = Lottos.from(lottoQuantity, makingNumbersStrategy);
        printer.printPurchaseResult(lottoQuantity.value(), lottos);
        return lottos;
    }

    private WinNumbers readAllWinNumbers() {
        WinNumbers winNumbersWithoutBonusNumber = readWinNumbers();
        return readBonusNumber(winNumbersWithoutBonusNumber);
    }

    private PurchasePrice doPurchase() {
        printer.print("구입금액을 입력해 주세요.");
        String originPrice = reader.read();
        try {
            return PurchasePrice.validatePrice(originPrice);
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return doPurchase();
        }
    }

    private void calculateResult(PurchasePrice purchasePrice, PrizeNumber prizeNumber) {
        int totalPrize = prizeNumber.calculateTotalPrize();
        double profit = calculator.calculateProfit(totalPrize, purchasePrice.value());
        printer.printPrizeResult(prizeNumber.sortByRank(), profit);
    }

    private WinNumbers readWinNumbers() {
        printer.printNewLine();
        printer.print("당첨 번호를 입력해 주세요.");
        String originWinNumbers = reader.read();
        try {
            return WinNumbers.winNumbersFrom(originWinNumbers);
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readWinNumbers();
        }
    }

    private WinNumbers readBonusNumber(WinNumbers winNumbersWithOutBonusNumber) {
        printer.printNewLine();
        printer.print("보너스 번호를 입력해 주세요.");
        String bonusNumber = reader.read();
        try {
            return winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readBonusNumber(winNumbersWithOutBonusNumber);
        }
    }
}
