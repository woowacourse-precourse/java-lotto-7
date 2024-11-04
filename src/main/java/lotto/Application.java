package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;
import store.controller.StoreController;
import store.repository.StoreSingleRepositoryImpl;
import store.service.StoreService;
import store.view.StoreInputView;
import store.view.StoreOutputView;

public class Application {

    private static final StoreInputView storeInputView = new StoreInputView();
    private static final StoreOutputView storeOutputView = new StoreOutputView();
    private static final StoreSingleRepositoryImpl storeRepository = new StoreSingleRepositoryImpl();
    private static final StoreService storeService = new StoreService(storeRepository);
    private static final StoreController storeController =
            new StoreController(storeInputView, storeOutputView, storeService);

    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LottoOutputView lottoOutputView = new LottoOutputView();
    private static final LottoRepositoryImpl lottoRepository = new LottoRepositoryImpl();
    private static final LottoService lottoService = new LottoService(storeService, lottoRepository);
    private static final LottoController lottoController = new LottoController(lottoInputView, lottoOutputView,
            lottoService);


    public static void main(String[] args) {
        lottoController.payingForLotto();
        storeController.setWeeklyNumbers();
        storeController.setBonusNumber();
        lottoController.checkLottoResult();
    }
}
