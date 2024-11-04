package global.config;

import lotto.controller.LottoController;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import store.controller.StoreController;
import store.repository.StoreRepositoryImpl;
import store.service.StoreService;

public class AppDIConfig {

    private final StoreRepositoryImpl storeRepository;
    private final StoreService storeService;
    private final StoreController storeController;
    private final LottoRepositoryImpl lottoRepository;
    private final LottoService lottoService;
    private final LottoController lottoController;

    public AppDIConfig() {
        this.storeRepository = new StoreRepositoryImpl();
        this.storeService = new StoreService(storeRepository);
        this.storeController = new StoreController(storeService);
        this.lottoRepository = new LottoRepositoryImpl();
        this.lottoService = new LottoService(storeService, lottoRepository);
        this.lottoController = new LottoController(lottoService);
    }

    public StoreController getStoreController() {
        return storeController;
    }

    public LottoController getLottoController() {
        return lottoController;
    }
}
