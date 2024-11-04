package lotto;

public class AppConfig {
    private LottoMachineImpl getLottoMachine(){
        return new LottoMachineImpl();
    }

    public LottoShop getLottoShop(){
        return new LottoShopImpl(getLottoMachine());
    }
}
