package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.utils.LottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        LottoStore lottoStore = new LottoStore(new LottoNumbersGenerator());
        buyLotto(lottoStore);

    }

    private LottoTicket buyLotto(LottoStore lottoStore){
        int amount =  InputView.inputPurchaseAmount();
        LottoTicket lottoTicket = lottoStore.buyLottoTicket(amount);
        OutputView.printLottoTicketInformation(lottoTicket.getAllLottoNumbers(), lottoTicket.getLottoCount());
        return lottoTicket;
    }
}
