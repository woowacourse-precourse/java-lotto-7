package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Set;

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
        WinningNumbers winningNumbers = readWinningNumbers();
        readBonusNumber(winningNumbers);
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

    public WinningNumbers readWinningNumbers(){
        outputView.winningNumberMessage();
        return new WinningNumbers(inputView.readWinningNumbers());
    }

    public void readBonusNumber(WinningNumbers winningNumbers){
        outputView.bonusNumberMessage();
        inputView.readBonusNumber(winningNumbers);
    }
}
