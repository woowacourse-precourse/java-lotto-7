package lotto.controller;

import java.util.List;
import lotto.model.Balance;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Rule;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Balance balance;
    private Bonus bonus;
    private Lotto lotto;
    private User user = new User();

    public void run() {
        insertMoney();
        buyLotto();
        setLottoNumbers();
        setBonusNumber();
        drawLotto();
        displayResult();
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
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printLottoNumbersGuide();
                lotto = new Lotto(LottoService.splitLottoNumbers(InputView.inputLottoNumbers()));
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void setBonusNumber() {
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printBonusNumber();
                bonus = new Bonus(InputView.inputBonusNumber(), lotto.getNumbers());
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void drawLotto() {
        for (List<Integer> userLotto : user.getLottos()) {
            int matchCount = LottoService.calculateMatchCount(lotto.getNumbers(), userLotto);
            boolean hasBonusMatch = LottoService.calculateBonusMatch(matchCount, bonus.getNumber(), userLotto);
            user.addResult(Rule.valueOf(matchCount, hasBonusMatch));
        }
    }

    public void displayResult() {
        OutputView.printResultMessage();
    }
}
