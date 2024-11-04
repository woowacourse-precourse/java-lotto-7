package lotto;

import java.util.List;
import java.util.Map;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance(1, 45, 1000L);
        InputView inputView = appConfig.inputView();
        OutputView outputView = appConfig.outputView();
        LottoController lottoController = appConfig.lottoController();

        //구매 가격 입력 및 로또 출력
        String purchasePrice;
        List<Lotto> lottos;
        while (true) {
            try {
                purchasePrice = inputView.promptPurchasePrice();
                lottos = lottoController.purchaseLotto(purchasePrice);
                outputView.displayPurchases(lottos);
                break;
            } catch (Exception e) {
                outputView.displayError(e.getMessage());
            }
        }

        //당첨 번호 및 보너스 번호 입력
        LottoMachine lottoMachine;
        while (true) {
            try {
                String winningNumbers = inputView.promptWinningNumbers();
                String bonusNumbers = inputView.promptBonusNumber();
                lottoMachine = lottoController.registerWinningNumber(winningNumbers, bonusNumbers);
                break;
            } catch (Exception e) {
                outputView.displayError(e.getMessage());
            }
        }

        //당첨 통계 출력
        Map<Prize, Integer> results = lottoController.getWinningResults(lottoMachine, lottos);
        outputView.displayWinningStatistic(results);

        //수익률 출력
        Double rateOfReturn = lottoController.getRateOfReturn(results, purchasePrice);
        outputView.displayRateOfReturn(rateOfReturn);
    }
}
