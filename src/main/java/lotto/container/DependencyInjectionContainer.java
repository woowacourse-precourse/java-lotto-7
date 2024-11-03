package lotto.container;

import java.util.HashMap;
import java.util.Map;
import lotto.command.view.validate.PurchaseAmountCommand;
import lotto.command.view.validate.LottoCommand;
import lotto.command.view.validate.BonusCommand;
import lotto.view.ConsoleView;
import lotto.controller.LottoController;
import lotto.service.amount.AmountService;
import lotto.service.lotto.LottoService;
import lotto.view.View;


/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 2.
 */
public class DependencyInjectionContainer {
  private final Map<Class<?>, Object> container;

  public DependencyInjectionContainer() {
    this.container = new HashMap<>();
    createLottoController();
  }

  private void createLottoController () {
    ConsoleView consoleView = new ConsoleView();
    container.put(View.class, consoleView);

    PurchaseAmountCommand purchaseAmountCommand = new PurchaseAmountCommand();
    AmountService amountService = new AmountService(purchaseAmountCommand);
    container.put(AmountService.class, amountService);

    LottoCommand lottoCommand = new LottoCommand();
    LottoService lottoService = new LottoService(lottoCommand);
    container.put(LottoService.class, lottoService);

    LottoController lottoController = new LottoController(consoleView, lottoService, amountService);
    container.put(LottoController.class, lottoController);
  }

  public <T> T get (Class<T> type) {
    Object instance = container.get(type);
    return type.cast(instance);
  }
}
