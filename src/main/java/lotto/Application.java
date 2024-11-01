package lotto;

import lotto.domain.LottoTicketCalculator;
import lotto.domain.PurchaseAmount;
import lotto.dto.PurchaseAmountDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printPurchaseAmountMessage();

        InputView inputView = new InputView();

        PurchaseAmountDto purchaseAmountDto = inputView.readPurchaseAmount();

        PurchaseAmount purchaseAmount = PurchaseAmount.from(purchaseAmountDto.amount());

        LottoTicketCalculator lottoTicketCalculator = new LottoTicketCalculator();
        int ticketCount = lottoTicketCalculator.getTicketCount(purchaseAmount);

        outputView.printPurchasedTicketCount(ticketCount);

    }
}
