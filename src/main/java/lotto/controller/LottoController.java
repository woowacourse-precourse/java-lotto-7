package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.service.LottoMachineService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run(){
        LottoTickets lottoTickets = buyLottoAndPrintTickets();
    }
    private LottoTickets buyLottoAndPrintTickets(){
        String inputPurchaseAmount = InputView.inputPurchaseAmount();
        LottoMachineService lottoMachineService = new LottoMachineService();
        try {
            LottoTickets lottoTickets = lottoMachineService.createLottoTickets(inputPurchaseAmount);
            OutputView.LottoTicketsOutCome(lottoTickets);
            return lottoTickets;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return buyLottoAndPrintTickets();
        }

    }

}
