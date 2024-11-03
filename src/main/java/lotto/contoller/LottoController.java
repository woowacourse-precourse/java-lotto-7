package lotto.contoller;

import lotto.constant.GameConfig;
import lotto.model.RandomLotto;
import lotto.model.Lotto;
import lotto.constant.Rank;
import lotto.model.WinningLotto;
import lotto.service.ProfitCalculatorService;
import lotto.service.ResultStatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final ResultStatisticsService resultStatisticsService;
    private final ProfitCalculatorService benefitService;


    public LottoController(ResultStatisticsService resultStatisticsService,
                           ProfitCalculatorService benefitService) {
        this.resultStatisticsService = resultStatisticsService;
        this.benefitService = benefitService;
    }

    public void start(){
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoTickets = createLottoTickets(purchaseAmount/ GameConfig.LOTTO_PRICE);
        WinningLotto winningLotto = getWinningLotto();
        winningLotto = getBonusNumber(winningLotto);
        showGameResults(purchaseAmount, lottoTickets, winningLotto);
    }

    public int getPurchaseAmount(){
        while(true) {
            try {
                OutputView.requestPurchaseAmount();
                return InputView.readPurchasePrice();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> createLottoTickets(int numberOfTickets){
        List<Lotto> lottoTickets = Stream.generate(RandomLotto::new)
                .limit(numberOfTickets)
                .collect(Collectors.toList());
        OutputView.printLottoTickets(numberOfTickets, lottoTickets);
        return lottoTickets;
    }

    public WinningLotto getWinningLotto(){
        while(true) {
            try {
                OutputView.requestWinningNumbers();
                return new WinningLotto(InputView.readWinningNumbers());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLotto getBonusNumber(WinningLotto winningLotto){
        while(true) {
            try {
                OutputView.requestBonusNumber();
                winningLotto.setBonusNumber(InputView.readBonusNumber());
                return winningLotto;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void showGameResults(int purchaseAmount, List<Lotto> purchasedLotto, WinningLotto winningLotto){
        OutputView.printResultTitle();
        Map<Rank, Integer> prizeResults = resultStatisticsService.collectWinningStatistics(purchasedLotto, winningLotto);
        OutputView.printWinningResults(prizeResults);
        showBenefitRate(purchaseAmount, prizeResults);
    }

    public void showBenefitRate(int purchaseAmount , Map<Rank, Integer> prizeResults){
        Long totalWinningAmount = benefitService.calculateWinningAmount(prizeResults);
        Double benefitRate = benefitService.calculateBenefitRate(purchaseAmount, totalWinningAmount);
        OutputView.printBenefitRate(String.valueOf(benefitRate));
    }



}
