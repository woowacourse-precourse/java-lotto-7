package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.utils.LottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void run(){
        LottoStore lottoStore = new LottoStore(new LottoNumbersGenerator());
        LottoTicket lottoTicket = buyLotto(lottoStore);
        WinningLotto winningLotto = createWinningLotto();
    }

    private LottoTicket buyLotto(LottoStore lottoStore){
        int amount =  InputView.inputPurchaseAmount();
        LottoTicket lottoTicket = lottoStore.buyLottoTicket(amount);
        OutputView.printLottoTicketInformation(lottoTicket.getAllLottoNumbers(), lottoTicket.getLottoCount());
        return lottoTicket;
    }

    private WinningLotto createWinningLotto(){
        List<Integer> winNumbers = InputView.inputWinNumbers();
        Integer bonusNumber = InputView.inputBonusNumber();
        return WinningLotto.of(winNumbers, bonusNumber);
    }
}
