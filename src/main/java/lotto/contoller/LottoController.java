package lotto.contoller;

import lotto.Lotto;
import lotto.constant.Prize;
import lotto.model.WinningLotto;
import lotto.service.BenefitService;
import lotto.service.CheckResultService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService lottoService = LottoService.getInstance();
    private CheckResultService checkResultService = CheckResultService.getInstance();
    private BenefitService benefitService = BenefitService.getInstance();

    private WinningLotto winningLotto;

    private static LottoController instance;
    private LottoController() {
    }
    public static LottoController getInstance(){
        if(instance == null){
            instance = new LottoController();
        }
        return instance;
    }

    public void start(){
        int purchasePrice = promptPurchaseCount();
        List<Lotto> purchasedLottos = generateRandomLottos(purchasePrice/ 1000);
        winningLotto = promptWinningLotto();
        printResult(purchasePrice, purchasedLottos);
    }

    public int promptPurchaseCount(){
        OutputView.requestPurchaseAmount();
        int purchasePrice = InputView.readPurchasePrice();
        //valid
        return purchasePrice;
    }

    public List<Lotto> generateRandomLottos(int count){
        List<Lotto> randomLottos = lottoService.generateRandomLottos(count);
        OutputView.printLottoTickets(count, randomLottos);
        return randomLottos;
    }

    public WinningLotto promptWinningLotto(){
        OutputView.requestWinningNumbers();
        Lotto lotto = new Lotto(InputView.readWinningNumbers());
        OutputView.requestBonusNumber();
        int bonusNumber = InputView.readBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

    public void printResult(int purchasePrice, List<Lotto> purchasedLotto){
        OutputView.printResultTitle();
        Map<Prize, Integer> results = checkResultService.collectWinningStatistics(
                purchasedLotto, winningLotto.getLotto(),
                winningLotto.getBonusNumber());
        OutputView.printWinningResults(results);
        printBenefitRate(purchasePrice, results);
    }

    public void printBenefitRate(int purchasePrice , Map<Prize, Integer> results){
        Long totalPrize = benefitService.calculateTotalPrize(results);
        Double benefitRate = benefitService.calculateBenefit(purchasePrice, totalPrize);
        OutputView.printBenefitRate(String.valueOf(benefitRate));
    }



}
