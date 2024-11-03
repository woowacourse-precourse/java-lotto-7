package lotto.controller;

import lotto.model.Balance;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Balance balance;
    private User user = new User();

    public void run() {
        insertMoney();
        buyLotto();
        setLottoNumbers();
    }

    public void insertMoney() {
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printInsertMoney();
                balance = new Balance(InputView.inputMoney());
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void buyLotto() {
        OutputView.printLottoTicketMessage(balance.getTicket());
        for (int i = 0; i < balance.getTicket(); i++) {
            user.addLotto(LottoService.createLottoNumbers());
            OutputView.printLottoNumbers(user.getLottos().get(i));
        }
    }

    public void setLottoNumbers() {
        OutputView.printLottoNumbersGuide();
    }
}
