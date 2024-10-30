package lotto.controller;

import lotto.service.LottoMachineService;
import lotto.view.InputView;

public class LottoController {
    public void run(){
     InputView inputView = new InputView();
     String inputPurchaseAmount = inputView.inputPurchaseAmount();
     LottoMachineService lottoMachineService = new LottoMachineService();
     lottoMachineService.createLottoTickets(inputPurchaseAmount);
     
    }

}
