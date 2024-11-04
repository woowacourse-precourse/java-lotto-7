package lotto;

import global.view.InputView;
import global.view.OutputView;
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

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final StoreSingleRepositoryImpl storeRepository = new StoreSingleRepositoryImpl();
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
