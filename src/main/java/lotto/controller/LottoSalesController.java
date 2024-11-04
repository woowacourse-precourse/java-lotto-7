package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Amount;
import lotto.model.InputWinningNumbers;
import lotto.model.PurchasedLottos;
import lotto.model.TicketCount;
import lotto.service.CheckContainsBonusService;
import lotto.service.ParseNumbersService;
import lotto.service.PickLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSalesController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoSalesController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Amount amount = repeatGetAmountUntilValid();
        PurchasedLottos purchasedLottos = purchaseLotto(amount);

        Lotto winningLotto = repeatGetWinningNumbersUntilValid();
        BonusNumber bonusNumber = repeatGetBonusNumberUntilValid(winningLotto);

        // 수익률 구하기
    }

    private Amount repeatGetAmountUntilValid() {
        while (true) {
            try {
                outputView.printInputAmount();
                return new Amount(inputView.getAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PurchasedLottos purchaseLotto(Amount amount) {
        TicketCount ticketCount = new TicketCount(amount);
        PickLottoService pickLottoService = new PickLottoService();
        PurchasedLottos purchasedLottos = pickLottoService.auto(ticketCount);

        outputView.printPurchasedLottos(ticketCount, purchasedLottos);
        return purchasedLottos;
    }

    private Lotto repeatGetWinningNumbersUntilValid() {
        while (true) {
            try {
                outputView.printInputWinningNumbers();
                InputWinningNumbers winningNumbers = new InputWinningNumbers(inputView.getWinningNumbers());
                ParseNumbersService parseNumbersService = new ParseNumbersService();
                return new Lotto(parseNumbersService.getWinningLotto(winningNumbers));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber repeatGetBonusNumberUntilValid(Lotto winningLotto) {
        while (true) {
            try {
                outputView.printInputBonusNumbers();
                BonusNumber bonusNumber = new BonusNumber(inputView.getBonusNumber());
                CheckContainsBonusService checkContainsBonusService = new CheckContainsBonusService();
                checkContainsBonusService.validateWinningContainsBonus(winningLotto, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
