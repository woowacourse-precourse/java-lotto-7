package lotto.controller;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.service.LottoNumberGenerator;
import lotto.validator.AmountValidator;
import lotto.view.View;

public class LottoController {
    View view;

    public LottoController(View view) {
        this.view = view;
    }


    public void run(User user, LottoNumberGenerator numberGenerator) {
        int amount = AmountValidator.isNumber(view.getUserInput());
        int tickets = amount / 1000;
        view.printPurchaseMessage(tickets);
        for (int i = 0; i < tickets; i++) {
            user.addLottoTicket(new Lotto(numberGenerator.generateNumbers()));
        }
        for (Lotto ticket : user.getLottoTickets()) {
            view.printLottoNumbers(ticket.getNumbers());
        }

    }
}
