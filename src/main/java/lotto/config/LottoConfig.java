package lotto.config;

import lotto.controller.LottoController;
import lotto.controller.ProfitRateController;
import lotto.controller.StatusController;
import lotto.controller.WinnerLottoController;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.repository.SingleRepository;
import lotto.repository.impl.LottoTicketsRepository;
import lotto.repository.impl.MoneyRepository;
import lotto.repository.impl.WinnerLottoRepository;
import lotto.repository.impl.WinnerStatusRepository;
import lotto.service.LottoService;
import lotto.service.ProfitRateService;
import lotto.service.StatusService;
import lotto.service.WinnerLottoService;
import lotto.service.impl.LottoServiceImpl;
import lotto.service.impl.ProfitRateServiceImpl;
import lotto.service.impl.StatusServiceImpl;
import lotto.service.impl.WinnerLottoServiceImpl;
import lotto.viewer.Viewer;
import lotto.viewer.impl.ViewerImpl;

public class LottoConfig {

    private static final Viewer VIEWER = new ViewerImpl();

    private static final SingleRepository<Money> MONEY_REPOSITORY = new MoneyRepository();
    private static final SingleRepository<LottoTickets> LOTTO_LIST_REPOSITORY = new LottoTicketsRepository();
    private static final SingleRepository<WinnerStatus> WINNER_STATUS_REPOSITORY = new WinnerStatusRepository();
    private static final SingleRepository<WinnerLotto> WINNER_LOTTO_REPOSITORY = new WinnerLottoRepository();

    private static final LottoService LOTTO_BUY_SERVICE = new LottoServiceImpl(MONEY_REPOSITORY,
            LOTTO_LIST_REPOSITORY);
    private static final LottoController LOTTO_BUY_CONTROLLER = new LottoController(LOTTO_BUY_SERVICE, VIEWER);

    private static final WinnerLottoService WINNER_LOTTO_SERVICE = new WinnerLottoServiceImpl(
            WINNER_LOTTO_REPOSITORY);
    private static final WinnerLottoController WINNER_LOTTO_CONTROLLER = new WinnerLottoController(WINNER_LOTTO_SERVICE,
            VIEWER);

    private static final StatusService STATUS_SERVICE = new StatusServiceImpl(
            WINNER_LOTTO_REPOSITORY, LOTTO_LIST_REPOSITORY, WINNER_STATUS_REPOSITORY);
    private static final StatusController STATUS_CONTROLLER = new StatusController(STATUS_SERVICE, VIEWER);

    private static final ProfitRateService PROFIT_RATE_SERVICE = new ProfitRateServiceImpl(MONEY_REPOSITORY,
            WINNER_STATUS_REPOSITORY);
    private static final ProfitRateController PROFIT_RATE_CONTROLLER = new ProfitRateController(PROFIT_RATE_SERVICE,
            VIEWER);

    public static WinnerLottoController getWinnerLottoController() {
        return WINNER_LOTTO_CONTROLLER;
    }

    public static LottoController getLottoBuyController() {
        return LOTTO_BUY_CONTROLLER;
    }

    public static StatusController getStatusController() {
        return STATUS_CONTROLLER;
    }

    public static ProfitRateController getProfitRateController() {
        return PROFIT_RATE_CONTROLLER;
    }

    public static Viewer viewer() {
        return VIEWER;
    }

    private LottoConfig() {
    }
}
