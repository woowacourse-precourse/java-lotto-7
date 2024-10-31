package lotto;

import static lotto.MoneyUtil.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;


    public LottoController(LottoService lottoService, OutputView outputView, InputView inputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        long userInputMoney = inputView.getUserInputMoney();
        MoneyValidator.validateInputMoney(userInputMoney);
        Lottos lottos = lottoService.buyLottos(userInputMoney);
        outputView.displayBuyResult(lottos);
    }
}
