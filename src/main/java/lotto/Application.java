package lotto;

import global.config.AppDIConfig;
import lotto.controller.LottoController;
import store.controller.StoreController;

public class Application {

    public static void main(String[] args) {
        AppDIConfig appDIConfig = new AppDIConfig();
        LottoController lottoController = appDIConfig.getLottoController();
        StoreController storeController = appDIConfig.getStoreController();

        lottoController.payingForLotto();
        storeController.setUpWeeklyNumbers();
        storeController.setUpBonusNumber();
        lottoController.checkLottoResult();
    }
}
