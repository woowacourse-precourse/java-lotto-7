package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.service.InputProcessService;
import lotto.service.LottoService;
import lotto.service.OutputProcessService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    public static final int LOTTO_RANGE_MIN = 1;
    public static final int LOTTO_RANGE_MAX = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final InputProcessService inputProcessService;
    private final OutputProcessService outputProcessService;
    private final LottoService lottoService;

    public LottoController(LottoInputView lottoInputView,
                           LottoOutputView lottoOutputView,
                           OutputProcessService outputProcessService){
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.outputProcessService = outputProcessService;
        this.inputProcessService = new InputProcessService(lottoInputView,
                LOTTO_RANGE_MIN,
                LOTTO_RANGE_MAX,
                LOTTO_PRICE,
                LOTTO_NUMBER_COUNT);
        this.lottoService = new LottoService(LOTTO_RANGE_MIN,
                LOTTO_RANGE_MAX,
                LOTTO_PRICE,
                LOTTO_NUMBER_COUNT);
    }

    public void start(){
        // 로또 구매
        Integer price = inputProcessService.getPurchaseRequest();
        Purchase purchase = lottoService.purchaseLotto(price);
        outputProcessService.printPurchaseLotto(purchase);

        // 당첨 로또
        List<Integer> lottoNumbers = inputProcessService.getLottoNumbersRequest();
        Integer bonusNumber = inputProcessService.getBonusNumberRequest();
        Lotto winningLotto = lottoService.registerWinningLotto(lottoNumbers);

        // 로또 당첨 계산
        purchase = lottoService.calculateLottoResult(purchase, winningLotto, bonusNumber);
        outputProcessService.printWinningResult(purchase);
        outputProcessService.printRateOfReturn(purchase);
    }
}
