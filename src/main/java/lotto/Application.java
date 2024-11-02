package lotto;

import lotto.command.output.LottoProfitCommand;
import lotto.command.validate.BonusCommand;
import lotto.command.validate.LottoCommand;
import lotto.command.validate.PurchaseAmountCommand;
import lotto.container.DependencyInjectionContainer;
import lotto.controller.LottoController;
import lotto.dto.BonusUserInput;
import lotto.dto.MatchResults;
import lotto.dto.PurchaseAmountUserInput;
import lotto.dto.WinningLottoUserInput;
import lotto.model.amount.ProfitRate;
import lotto.model.amount.PurchaseAmount;
import lotto.model.lotto.PurchasedLottos;
import lotto.model.lotto.WinningLotto;
import lotto.service.amount.AmountService;
import lotto.service.lotto.LottoService;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        DependencyInjectionContainer container = new DependencyInjectionContainer();
        LottoController lottoController = container.get(LottoController.class);
        lottoController.purchaseLotto();
    }
}
