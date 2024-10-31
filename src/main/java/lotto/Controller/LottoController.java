package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.MyLottos;
import lotto.View.InputLottoView;


public class LottoController {
    static final InputLottoView inputLottoView = new InputLottoView();
    static final IssueTicketController issueTicketController = new IssueTicketController();
    static final WinningTotalController winningTotalController = new WinningTotalController();

    public void init() {
        int price = inputLottoView.inputPrice();
        MyLottos issuedTickets = issueTicketController.issueTickets(getNumberOfTickets(price));
        Lotto winningLotto = inputLottoView.inputWinningNumbers();
        int bonusNumber = inputLottoView.inputBonusNumber();

        winningTotalController.winningTotal(issuedTickets,winningLotto,bonusNumber);

    }

    public int getNumberOfTickets(int price) {
        return price / 1000;
    }
}
