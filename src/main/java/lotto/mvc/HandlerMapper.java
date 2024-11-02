package lotto.mvc;

import static lotto.constant.RequestUrl.CALCULATE_RESULT;
import static lotto.constant.RequestUrl.INIT_WINNING_LOTTO;
import static lotto.constant.RequestUrl.PURCHASE_RANDOM_LOTTO;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.RequestUrl;
import lotto.controller.Controller;
import lotto.controller.LottoResultController;
import lotto.controller.RandomLottoPurchaseController;
import lotto.controller.WinningLottoController;
import lotto.service.RandomLottoIssueService;
import lotto.service.WinningLottoIssueService;

public class HandlerMapper {

    private final static Map<RequestUrl, Controller> CONTROLLER_MAP = new HashMap<>();

    static {
        CONTROLLER_MAP.put(PURCHASE_RANDOM_LOTTO, new RandomLottoPurchaseController(new RandomLottoIssueService()));
        CONTROLLER_MAP.put(INIT_WINNING_LOTTO, new WinningLottoController(new WinningLottoIssueService()));
        CONTROLLER_MAP.put(CALCULATE_RESULT, new LottoResultController());
    }

    public Controller getController(RequestUrl url) {
        return CONTROLLER_MAP.get(url);
    }
}
