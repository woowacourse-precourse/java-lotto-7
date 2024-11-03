package lotto.purchase.config;

import lotto.common.util.random.LottoRandomGenerator;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.infrastructure.LottoRepositoryImpl;
import lotto.lotto.service.LottoFactory;
import lotto.lotto.service.LottoServiceImpl;
import lotto.lotto.service.port.LottoRepository;
import lotto.purchase.controller.PurchaseController;
import lotto.purchase.controller.port.PurchaseService;
import lotto.purchase.infrastructure.PurchaseRepositoryImpl;
import lotto.purchase.service.PurchaseServiceImpl;
import lotto.purchase.service.port.PurchaseRepository;

public class PurchaseConfig {

    private static PurchaseConfig instance;

    private PurchaseConfig() {
    }

    public static PurchaseConfig getInstance() {
        if (instance == null) {
            instance = new PurchaseConfig();
        }
        return instance;
    }

    public PurchaseController purchaseController() {
        return new PurchaseController(purchaseService());
    }

    private PurchaseService purchaseService() {
        return new PurchaseServiceImpl(lottoService(), purchaseRepository(), lottoRepository());
    }

    private LottoRepository lottoRepository() {
        return LottoRepositoryImpl.getInstance();
    }

    private PurchaseRepository purchaseRepository() {
        return PurchaseRepositoryImpl.getInstance();
    }

    private LottoService lottoService() {
        return new LottoServiceImpl(LottoRepositoryImpl.getInstance(), lottoFactory());
    }

    private LottoFactory lottoFactory() {
        return new LottoFactory(new LottoRandomGenerator());
    }

}
