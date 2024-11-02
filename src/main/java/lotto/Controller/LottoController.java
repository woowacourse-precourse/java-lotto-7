package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.MyLottos;
import lotto.Service.EarningRateService;
import lotto.Service.IssueMyLottoService;
import lotto.Service.WinningTotalService;
import lotto.View.InputLottoView;
import lotto.View.OutputEarningRateView;
import lotto.View.OutputMyLottosView;
import lotto.View.OutputWinningTotalView;

import java.util.Map;


public class LottoController {
    private final InputLottoView inputLottoView;
    private final OutputMyLottosView outputMyLottosView;
    private final OutputWinningTotalView outputWinningTotalView;
    private final OutputEarningRateView outputEarningRateView;
    private final IssueMyLottoService issueMyLottoService;
    private final WinningTotalService winningTotalService;
    private final EarningRateService earningRateService;


    public LottoController(IssueMyLottoService issueMyLottoService, WinningTotalService winningTotalService, EarningRateService earningRateService, OutputWinningTotalView outputWinningTotalView, InputLottoView inputLottoView, OutputMyLottosView outputMyLottosView, OutputEarningRateView outputEarningRateView) {
        this.issueMyLottoService = issueMyLottoService;
        this.winningTotalService = winningTotalService;
        this.earningRateService = earningRateService;
        this.inputLottoView = inputLottoView;
        this.outputMyLottosView = outputMyLottosView;
        this.outputWinningTotalView = outputWinningTotalView;
        this.outputEarningRateView = outputEarningRateView;
    }

    public void startLottery() {
        int price = inputLottoView.inputPrice();
        final MyLottos myLottos = getMyLottos(price);
        final Lotto winningLotto = inputLottoView.inputWinningNumbers();
        final int bonusNumber = inputLottoView.inputBonusNumber();
        Map<String, Integer> resultMap = getWinningTotal(myLottos, winningLotto, bonusNumber);
        getEarningRate(price, resultMap);
    }

    private MyLottos getMyLottos(int price) {
        int numberOfTicket = issueMyLottoService.getNumberOfTickets(price);
        final MyLottos myLottos = issueMyLottoService.issueMyLottos(numberOfTicket);
        outputMyLottosView.printMylottos(myLottos);
        return myLottos;
    }

    private Map<String, Integer> getWinningTotal(MyLottos myLottos, Lotto winningLotto, int bonusNumber) {
        final Map<String, Integer> resultMap = winningTotalService.calculateWinningTotal(myLottos, winningLotto, bonusNumber);
        outputWinningTotalView.printWinningTotal(resultMap);
        return resultMap;
    }

    private void getEarningRate(int price, Map<String, Integer> resultMap) {
        double earningRate = earningRateService.calculateEarningRate(price, resultMap);
        outputEarningRateView.printEarningRate(earningRate);
    }
}
