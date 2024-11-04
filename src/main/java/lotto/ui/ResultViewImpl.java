package lotto.ui;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

import static lotto.validation.ValidatorImpl.ZERO;

public class ResultViewImpl implements ResultView {
    @Override
    public void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void printResult(LottoGame lottoGame) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printLottoResult(lottoGame.getLottoResult());
        printReturnRate(lottoGame);
    }

    private void printLottoResult(LottoResult lottoResult) {
        StringBuilder result = new StringBuilder();
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();
        appendRank(result, rankCount, Rank.FIFTH, "3개 일치 (5,000원)");
        appendRank(result, rankCount, Rank.FOURTH, "4개 일치 (50,000원)");
        appendRank(result, rankCount, Rank.THIRD, "5개 일치 (1,500,000원)");
        appendRank(result, rankCount, Rank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        appendRank(result, rankCount, Rank.FIRST, "6개 일치 (2,000,000,000원)");
        System.out.println(result.toString());
    }

    private void appendRank(StringBuilder result, Map<Rank, Integer> rankCount, Rank rank, String description) {
        result.append(description)
                .append(" - ")
                .append(rankCount.getOrDefault(rank, ZERO))
                .append("개\n");
    }

    private void printReturnRate(LottoGame lottoGame) {
        System.out.println("총 수익률은 " + lottoGame.calculateReturnRate() + "%입니다.");
    }
}
