package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.impl.LottoServiceImpl;
import lotto.viewer.Viewer;

public class LottoConfig {

    private static final Viewer VIEWER = new Viewer();
    private static final LottoService LOTTO_SERVICE = new LottoServiceImpl();
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
