package lotto;

import lotto.service.LottoGenerator;
import lotto.service.LottoRank;
import lotto.service.LottoResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        // 구입 금액 입력 및 검증
        int purchaseAmount = InputView.getPurchaseAmount();

        // 로또 번호 생성
        List<List<Integer>> lottoTickets = LottoGenerator.generateLottoTickets(purchaseAmount);

        // 구매한 로또 번호 출력
        OutputView.printPurchasedLottoTickets(lottoTickets);

        // 당첨 번호 입력 및 검증
        List<Integer> winningNumbers = InputView.getWinningNumbers();

        // 보너스 번호 입력 및 검증
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        // 로또 당첨 결과 계산
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        for (List<Integer> ticket : lottoTickets) {
            Lotto lotto = new Lotto(ticket);
            int matchCount = lotto.matchCount(winningNumbers);
            boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);

            // 로또 등수 계산
            LottoRank rank = LottoRank.determineRank(matchCount, isBonusMatch);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        // 당첨 통계 출력
        OutputView.printLottoStatistics(rankCounts);

        // 총 당첨 금액 계산
        int totalPrize = LottoResultCalculator.calculateTotalPrize(rankCounts);

        // 수익률 계산 및 출력
        double revenueRate = LottoResultCalculator.calculateRevenueRate(totalPrize, purchaseAmount);
        OutputView.printRevenueRate(revenueRate);


    }
}
