package lotto.config;

import lotto.controller.LottoController;
import lotto.service.InputMessageService;
import lotto.service.LottoService;
import lotto.validation.PurchaseAmountValidation;
import lotto.view.InputMessageView;

public class AppConfig {
  public LottoController lottoController(){
    return new LottoController(inputMessageService());
  }
  public LottoService lottoService(){
    return new LottoService();
  }
  public InputMessageService inputMessageService(){
    return new InputMessageService(inputMessageView(),purchaseAmountValidation());
  }
  public InputMessageView inputMessageView(){
    return new InputMessageView();
  }

  public PurchaseAmountValidation purchaseAmountValidation(){
    return new PurchaseAmountValidation();
  }
}
