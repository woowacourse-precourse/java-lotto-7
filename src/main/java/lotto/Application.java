package lotto;

import lotto.controller.ApplicationController;
import lotto.service.ApplicationService;
import lotto.util.Input;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationController appController = new ApplicationController(new ApplicationService());

        int tickets = Input.moneyTicket();
        appController.createLottoTickets(tickets);

        List<Integer> winningNumbers = Input.winningNumbers();
        int bonusNumber = Input.bonusNumber(winningNumbers);

        appController.start(winningNumbers, bonusNumber);
    }
}
