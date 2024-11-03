package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoIssueCount;
import lotto.model.LottoIssuer;
import lotto.model.LottoResultChecker;
import lotto.model.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        List<Lotto> issuedLotto = null;
        int purchaseCount = 0;

        while (true) {
            try {
                // 구입 금액 입력
                int purchaseAmount = InputView.getPurchaseAmount();
                // 로또 구매 개수 계산
                purchaseCount = LottoIssueCount.calculateNumberOfLottoIssue(purchaseAmount);
                // 로또 구매 개수 출력
                OutputView.printLottoPurchaseCount(purchaseCount);
                // 로또 구매 개수만큼 로또 발권
                issuedLotto = LottoIssuer.issueLotto(purchaseCount);
                // 발권된 로또 번호 출력
                OutputView.printLottoNumbers(issuedLotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Set<Integer> inputWinningLottoNumber;
        while (true) {
            try {
                //당첨 번호 입력
                inputWinningLottoNumber = InputView.getWinningNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                //보너스 번호 입력
                bonusNumber = InputView.getBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //당첨 번호와 발권된 로또 번호 비교, 계산
        Map<Ranking, Integer> rankingCountMap = LottoResultChecker.calculateRankingCount(
                inputWinningLottoNumber, issuedLotto, bonusNumber);
        //당첨 통계 출력
        OutputView.printLottoResult(rankingCountMap);
        //총 수익률 출력
        int winningPrize = LottoResultChecker.calculateWinningPrize(rankingCountMap);
        double profitRate = LottoResultChecker.calculateProfit(purchaseCount, winningPrize);
        OutputView.printProfitRate(profitRate);
    }
}