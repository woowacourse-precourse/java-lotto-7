package lotto.controller;

import lotto.model.InputAmount;
import lotto.model.PurchasedLottos;
import lotto.model.TicketCount;
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
        InputAmount inputAmount = repeatGetAmountUntilValid();
        PurchasedLottos purchasedLottos = purchaseLotto(inputAmount);

        // 당첨 번호 입력받기
        // 보너스 번호 입력받기

        // 수익률 구하기
    }

    private InputAmount repeatGetAmountUntilValid() {
        while (true) {
            try {
                outputView.printInputAmount();
                return new InputAmount(inputView.getAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PurchasedLottos purchaseLotto(InputAmount inputAmount) {
        TicketCount ticketCount = new TicketCount(inputAmount);
        PickLottoService pickLottoService = new PickLottoService();
        PurchasedLottos purchasedLottos = pickLottoService.auto(ticketCount);

        outputView.printPurchasedLottos(ticketCount, purchasedLottos);
        return purchasedLottos;
    }
}
