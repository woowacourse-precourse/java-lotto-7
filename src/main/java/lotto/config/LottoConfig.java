package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.repository.SingleRepository;
import lotto.repository.impl.LottoListRepository;
import lotto.repository.impl.MoneyRepository;
import lotto.repository.impl.WinnerLottoRepository;
import lotto.repository.impl.WinnerStatusRepository;
import lotto.service.LottoService;
import lotto.service.impl.LottoServiceImpl;
import lotto.viewer.Viewer;

public class LottoConfig {

    private static final Viewer VIEWER = new Viewer();

    private static final SingleRepository<Money> MONEY_REPOSITORY = new MoneyRepository();
    private static final SingleRepository<LottoList> LOTTO_LIST_REPOSITORY = new LottoListRepository();
    private static final SingleRepository<WinnerStatus> WINNER_STATUS_REPOSITORY = new WinnerStatusRepository();
    private static final SingleRepository<WinnerLotto> WINNER_LOTTO_SINGLE_REPOSITORY = new WinnerLottoRepository();

    private static final LottoService LOTTO_SERVICE = new LottoServiceImpl(MONEY_REPOSITORY, LOTTO_LIST_REPOSITORY,
            WINNER_STATUS_REPOSITORY, WINNER_LOTTO_SINGLE_REPOSITORY);

    private static final LottoController LOTTO_CONTROLLER = new LottoController(LOTTO_SERVICE, VIEWER);

    private LottoConfig() {
    }

    public static LottoController getLottoController() {
        return LOTTO_CONTROLLER;
    }

    public static LottoService lottoService() {
        return LOTTO_SERVICE;
    }
}
