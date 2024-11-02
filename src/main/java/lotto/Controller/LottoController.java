package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.MyLottos;
import lotto.Service.EarningRateService;
import lotto.Service.IssueTicketService;
import lotto.Service.WinningTotalService;
import lotto.View.InputLottoView;
import lotto.View.OutputEarningRateView;
import lotto.View.OutputIssuedTicketView;
import lotto.View.OutputWinningTotalView;

import java.util.Map;


public class LottoController {
    private final InputLottoView inputLottoView;
    private final OutputIssuedTicketView outputIssuedTicketView;
    private final OutputWinningTotalView outputWinningTotalView;
    private final OutputEarningRateView outputEarningRateView;
    private final IssueTicketService issueTicketService;
    private final WinningTotalService winningTotalService;
    private final EarningRateService earningRateService;


    public LottoController(IssueTicketService issueTicketService, WinningTotalService winningTotalService, EarningRateService earningRateService, OutputWinningTotalView outputWinningTotalView, InputLottoView inputLottoView, OutputIssuedTicketView outputIssuedTicketView, OutputEarningRateView outputEarningRateView) {
        this.issueTicketService = issueTicketService;
        this.winningTotalService = winningTotalService;
        this.earningRateService = earningRateService;
        this.inputLottoView = inputLottoView;
        this.outputIssuedTicketView = outputIssuedTicketView;
        this.outputWinningTotalView = outputWinningTotalView;
        this.outputEarningRateView = outputEarningRateView;
    }

    public void startLottery() {
        int price = inputLottoView.inputPrice();
        final MyLottos issuedTickets = getMyIssuedLottos(price);
        final Lotto winningLotto = inputLottoView.inputWinningNumbers();
        final int bonusNumber = inputLottoView.inputBonusNumber();
        Map<String, Integer> resultMap = getWinningTotal(issuedTickets, winningLotto, bonusNumber);
        getEarningRate(price, resultMap);
    }

    private MyLottos getMyIssuedLottos(int price) {
        int numberOfTicket = issueTicketService.getNumberOfTickets(price);
        final MyLottos issuedTickets = issueTicketService.makeIssuedTickets(numberOfTicket);
        outputIssuedTicketView.printMylottos(issuedTickets);
        return issuedTickets;
    }

    private Map<String, Integer> getWinningTotal(MyLottos issuedTickets, Lotto winningLotto, int bonusNumber) {
        final Map<String, Integer> resultMap = winningTotalService.calculateWinningTotal(issuedTickets, winningLotto, bonusNumber);
        outputWinningTotalView.printWinningTotal(resultMap);
        return resultMap;
    }

    private void getEarningRate(int price, Map<String, Integer> resultMap) {
        double earningRate = earningRateService.calculateEarningRate(price, resultMap);
        outputEarningRateView.printEarningRate(earningRate);
    }
}
