package lotto.contoller;

import lotto.constant.GameConfig;
import lotto.domain.RandomLotto;
import lotto.model.Lotto;
import lotto.constant.Rank;
import lotto.domain.WinningLotto;
import lotto.service.ProfitCalculatorService;
import lotto.service.WinningStatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final WinningStatisticsService checkResultService;
    private final ProfitCalculatorService benefitService;


    public LottoController(WinningStatisticsService checkResultService,
                           ProfitCalculatorService benefitService) {
        this.checkResultService = checkResultService;
        this.benefitService = benefitService;
    }

    public void start(){
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoTickets = createLottoTickets(purchaseAmount/ GameConfig.LOTTO_PRICE);
        WinningLotto winningLotto = getWinningLotto();
        showGameResults(purchaseAmount, lottoTickets, winningLotto);
    }

    public int getPurchaseAmount(){
        OutputView.requestPurchaseAmount();
        int purchaseAmount = InputView.readPurchasePrice();
        //valid
        return purchaseAmount;
    }

    public List<Lotto> createLottoTickets(int numberOfTickets){
        List<Lotto> lottoTickets = Stream.generate(RandomLotto::new)
                .limit(numberOfTickets)
                .collect(Collectors.toList());
        OutputView.printLottoTickets(numberOfTickets, lottoTickets);
        return lottoTickets;
    }

    public WinningLotto getWinningLotto(){
        OutputView.requestWinningNumbers();
        List<Integer> winningNumbers = InputView.readWinningNumbers();
        OutputView.requestBonusNumber();
        int bonusNumber = InputView.readBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public void showGameResults(int purchaseAmount, List<Lotto> purchasedLotto, WinningLotto winningLotto){
        OutputView.printResultTitle();
        Map<Rank, Integer> prizeResults = checkResultService.collectWinningStatistics(purchasedLotto, winningLotto);
        OutputView.printWinningResults(prizeResults);
        showBenefitRate(purchaseAmount, prizeResults);
    }

    public void showBenefitRate(int purchaseAmount , Map<Rank, Integer> prizeResults){
        Long totalWinningAmount = benefitService.calculateWinningAmount(prizeResults);
        Double benefitRate = benefitService.calculateBenefitRate(purchaseAmount, totalWinningAmount);
        OutputView.printBenefitRate(String.valueOf(benefitRate));
    }



}
