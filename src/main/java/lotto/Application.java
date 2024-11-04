package lotto;

import lotto.command.validate.LottoCommand;
import lotto.command.validate.PurchaseAmountCommand;
import lotto.dto.PurchaseAmountUserInput;
import lotto.dto.WinningLottoUserInput;
import lotto.service.amount.AmountService;
import lotto.service.lotto.LottoService;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmountCommand purchaseAmountCommand = new PurchaseAmountCommand();
        AmountService amountService = new AmountService(purchaseAmountCommand);
        ConsoleView view = new ConsoleView();
        PurchaseAmountUserInput userInput = (PurchaseAmountUserInput) view.promptInput(amountService.getValidateCommand());

        LottoCommand lottoCommand = new LottoCommand();
        LottoService lottoService = new LottoService(lottoCommand);
        WinningLottoUserInput winningLottoUserInput = (WinningLottoUserInput) view.promptInput(lottoService.getLottoCommand());

        int a = 0;

    }
}
