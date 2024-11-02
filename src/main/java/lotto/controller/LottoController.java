package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(LottoService lottoService,
                           InputView inputView,
                           OutputView outputView){
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        int lottoCount = readLottoCount();
        Lottos lottos = IssueLottos(lottoCount);

    }

    public int readLottoCount(){
        outputView.amountMessage();
        int amount = inputView.readLottoAmount();
        return amount/1000;
    }

    public Lottos IssueLottos(int lottoCount){
        Lottos lottos = lottoService.issueLottos(lottoCount);
        outputView.purchaseLottoMessage(lottoCount, lottos);
        return lottos;
    }
}
