package lotto.config;

import lotto.controller.LottoController;
import lotto.service.InputMessageService;
import lotto.service.LottoService;
import lotto.service.OutputMessageService;
import lotto.validation.EnterWinningNumberValidation;
import lotto.validation.PurchaseAmountValidation;
import lotto.view.InputMessageView;
import lotto.view.OutputMessageView;

public class AppConfig {
  public LottoController lottoController(){
    return new LottoController(inputMessageService(),outputMessageService(),outputMessageView(),lottoService());
  }
  public LottoService lottoService(){
    return new LottoService();
  }
  public InputMessageService inputMessageService(){
    return new InputMessageService(inputMessageView(),purchaseAmountValidation(),enterWinningNumberValidation());
  }
  public InputMessageView inputMessageView(){
    return new InputMessageView();
  }

  public PurchaseAmountValidation purchaseAmountValidation(){
    return new PurchaseAmountValidation();
  }
  public OutputMessageView outputMessageView(){
    return new OutputMessageView();
  }
  public OutputMessageService outputMessageService(){
    return new OutputMessageService();
  }

  public EnterWinningNumberValidation enterWinningNumberValidation(){
    return new EnterWinningNumberValidation();
  }
}
