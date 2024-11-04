package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.OutputView.printErrorMessage;

public class PurchaseService {
    private final InputView inputView = new InputView();

    public Integer purchaseLotto() {
        Integer ticketCount = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                String rawPurchaseAmount = inputView.getPurchaseAmount();
                PurchaseAmount purchaseAmount = new PurchaseAmount(rawPurchaseAmount);

                ticketCount = purchaseAmount.calculateTicketCount();

                validInput = true;

            } catch (IllegalArgumentException e) {
                // 예외 발생 시 오류 메시지 출력 및 다시 입력 요청
                printErrorMessage(e.getMessage());
            }
        }

        return ticketCount;
    }
}
