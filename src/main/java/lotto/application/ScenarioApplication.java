package lotto.application;

import lotto.config.AppConfig;
import lotto.domain.LottoQuantity;
import lotto.domain.Price;
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
        Price price = Price.validatePrice(originPrice);
        LottoQuantity.findQuantity(price);

        String originWinNumbers = reader.read();
        WinNumbers winNumbersWithOutBonusNumber = WinNumbers.winNumbersFrom(originWinNumbers);
        String bonusNumber = reader.read();
        WinNumbers winNumbers = winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);
    }
}
