package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private Money money;

    public void run() {
        gameStart();
        gameResult();
    }

    private void gameStart() {
        // 기능 추가 예정
    }

    private void gameResult() {
        // 기능 추가 예정
    }
}
    private void createMoney() {
        while (true) {
            try {
                money = new Money(inputView.inputMoney());
                break;
            } catch (IllegalArgumentException e) {
                outputView.println(e.getMessage());
            }
        }
    }

    private int getTicket(Money money) {
        int ticket = money.calculateNumberOfTickets();
        outputView.moneyInputResultMessage(ticket);
        return ticket;
    }
}