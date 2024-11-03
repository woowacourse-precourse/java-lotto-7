package lotto.contoller;

import lotto.constant.LottoConstants;
import lotto.component.Lotto;
import lotto.component.Prize;
import lotto.domain.WinningLotto;
import lotto.service.ProfitCalculatorService;
import lotto.service.WinningStatisticsService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoService lottoService;
    private final WinningStatisticsService checkResultService;
    private final ProfitCalculatorService benefitService;

    private WinningLotto winningLotto;

    public LottoController(LottoService lottoService,
                           WinningStatisticsService checkResultService,
                           ProfitCalculatorService benefitService) {
        this.lottoService = lottoService;
        this.checkResultService = checkResultService;
        this.benefitService = benefitService;
    }

    public void start(){
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoTickets = createLottoTickets(purchaseAmount/ LottoConstants.LOTTO_PRICE);
        winningLotto = getWinningLotto();
        showGameResults(purchaseAmount, lottoTickets);
    }

    public int getPurchaseAmount(){
        OutputView.requestPurchaseAmount();
        int purchaseAmount = InputView.readPurchasePrice();
        //valid
        return purchaseAmount;
    }

    public List<Lotto> createLottoTickets(int numberOfTickets){
        List<Lotto> lottoTickets = lottoService.createRandomLottos(numberOfTickets);
        OutputView.printLottoTickets(numberOfTickets, lottoTickets);
        return lottoTickets;
    }

    public WinningLotto getWinningLotto(){
        OutputView.requestWinningNumbers();
        Lotto lotto = new Lotto(InputView.readWinningNumbers());
        OutputView.requestBonusNumber();
        int bonusNumber = InputView.readBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

    public void showGameResults(int purchasePrice, List<Lotto> purchasedLotto){
        OutputView.printResultTitle();
        Map<Prize, Integer> prizeResults = checkResultService.collectWinningStatistics(purchasedLotto, winningLotto);
        OutputView.printWinningResults(prizeResults);
        showBenefitRate(purchasePrice, prizeResults);
    }

    public void showBenefitRate(int purchaseAmount , Map<Prize, Integer> prizeResults){
        Long totalWinningAmount = benefitService.calculateWinningAmount(prizeResults);
        Double benefitRate = benefitService.calculateBenefitRate(purchaseAmount, totalWinningAmount);
        OutputView.printBenefitRate(String.valueOf(benefitRate));
    }



}
