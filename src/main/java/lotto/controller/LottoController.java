package lotto.controller;

import lotto.service.InputMessageService;
import lotto.service.LottoService;

public class LottoController {

  private final InputMessageService inputMessageService;
  public LottoController(InputMessageService inputMessageService) {
    this.inputMessageService=inputMessageService;
  }

  public void run(){
    int purchaseAmount= inputMessageService.purchaseAmountAndValidation();
  }

}
