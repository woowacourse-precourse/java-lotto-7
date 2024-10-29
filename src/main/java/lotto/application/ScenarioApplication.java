package lotto.application;

import lotto.config.AppConfig;
import lotto.domain.LottoQuantity;
import lotto.domain.PurchasePrice;
import lotto.domain.WinNumbers;

public class ScenarioApplication {

    private final MakeNumbersStrategy makeNumbersStrategy;
    private final Reader reader;

    public ScenarioApplication(AppConfig appConfig) {
        this.makeNumbersStrategy = appConfig.makeNumbersStrategy();
        this.reader = appConfig.reader();
    }

    public void run() {
        String originPrice = reader.read();
        PurchasePrice purchasePrice = PurchasePrice.validatePrice(originPrice);
        LottoQuantity.findQuantity(purchasePrice);

        String originWinNumbers = reader.read();
        WinNumbers winNumbersWithOutBonusNumber = WinNumbers.winNumbersFrom(originWinNumbers);
        String bonusNumber = reader.read();
        WinNumbers winNumbers = winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);
    }
}
