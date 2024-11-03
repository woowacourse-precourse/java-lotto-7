package lotto.controller;

import lotto.service.InputMessageService;
import lotto.service.LottoService;
import lotto.service.OutputMessageService;
import lotto.view.OutputMessageView;

public class LottoController {

  private final InputMessageService inputMessageService;
  private final OutputMessageService outputMessageService;
  private final OutputMessageView outputMessageView;
  public LottoController(InputMessageService inputMessageService,
      OutputMessageService outputMessageService,OutputMessageView outputMessageView) {
    this.inputMessageService=inputMessageService;
    this.outputMessageService=outputMessageService;
    this.outputMessageView=outputMessageView;
  }

  public void run(){
    long purchaseAmount= inputMessageService.purchaseAmountAndValidation();
    long numberOfPurchases=outputMessageService.numberOfPurchases(purchaseAmount);
    outputMessageView.numberOfPurchases(numberOfPurchases);
  }

}
