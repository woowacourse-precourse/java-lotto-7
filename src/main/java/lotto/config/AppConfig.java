package lotto.config;

import lotto.service.LottoMachineImpl;
import lotto.service.LottoShop;
import lotto.service.LottoShopImpl;

public class AppConfig {
    private LottoMachineImpl getLottoMachine(){
        return new LottoMachineImpl();
    }

    public LottoShop getLottoShop(){
        return new LottoShopImpl(getLottoMachine());
    }
}
