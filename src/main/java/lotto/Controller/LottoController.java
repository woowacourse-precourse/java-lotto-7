package lotto.Controller;

import lotto.Model.MyLottos;
import lotto.View.InputLottoView;
import lotto.View.OutputLottoView;


public class LottoController {
    static final InputLottoView inputLottoView = new InputLottoView();
    static final IssueTicketController issueTicketController = new IssueTicketController();
    static final OutputLottoView outputLottoView = new OutputLottoView();

    public void init() {
        int price = inputLottoView.inputPrice();
        MyLottos issuedTickets = issueTicketController.issueTickets(getNumberOfTickets(price));
        outputLottoView.printMylottos(issuedTickets);
    }

    public int getNumberOfTickets(int price) {
        return price / 1000;
    }
}
