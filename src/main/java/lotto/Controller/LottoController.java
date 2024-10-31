package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.MyLottos;
import lotto.View.InputLottoView;

import java.util.Map;


public class LottoController {
    static final InputLottoView inputLottoView = new InputLottoView();
    static final IssueTicketController issueTicketController = new IssueTicketController();
    static final WinningTotalController winningTotalController = new WinningTotalController();
    static final EarningRateController earningRateController = new EarningRateController();

    public void init() {
        int price = inputLottoView.inputPrice();
        MyLottos issuedTickets = issueTicketController.issueTickets(getNumberOfTickets(price));
        Lotto winningLotto = inputLottoView.inputWinningNumbers();
        int bonusNumber = inputLottoView.inputBonusNumber();

        Map<String, Integer> resultMap = winningTotalController.winningTotal(issuedTickets, winningLotto, bonusNumber);

        earningRateController.earningRate(price, resultMap);
    }

    public int getNumberOfTickets(int price) {
        return price / 1000;
    }
}
