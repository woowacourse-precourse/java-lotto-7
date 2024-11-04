package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import store.controller.StoreController;
import store.repository.StoreRepositoryImpl;
import store.service.StoreService;

public class Application {

    private static final StoreRepositoryImpl storeRepository = new StoreRepositoryImpl();
    private static final StoreService storeService = new StoreService(storeRepository);
    private static final StoreController storeController = new StoreController(storeService);

    private static final LottoRepositoryImpl lottoRepository = new LottoRepositoryImpl();
    private static final LottoService lottoService = new LottoService(storeService, lottoRepository);
    private static final LottoController lottoController = new LottoController(lottoService);

    public static void main(String[] args) {
        lottoController.payingForLotto();
        storeController.setWeeklyNumbers();
        storeController.setBonusNumber();
        lottoController.checkLottoResult();
    }
}
