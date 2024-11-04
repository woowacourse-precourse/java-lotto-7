package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.domain.Winning;

public class OutputView {
    public void askBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void responseNumberOfLotto(int lottoNum) {
        System.out.println();
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public void askWinningLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    private String formatLottoNumbers(List<Integer> numbers) {
        return numbers.toString()
                .replace("[", "[")
                .replace("]", "]");
    }

    public void printStatistics(LottoStatistics statistics) {
        System.out.println("---");
        printWinningResults(statistics.getWinningStats());
        System.out.printf("총 수익률은 %.1f%%입니다.%n", statistics.getProfitRate());
    }

    private void printWinningResults(Map<Winning, Integer> stats) {
        LottoResult[] results = {
                new LottoResult(Winning.FIFTH),
                new LottoResult(Winning.FOURTH),
                new LottoResult(Winning.THIRD),
                new LottoResult(Winning.SECOND),
                new LottoResult(Winning.FIRST)
        };

        for (LottoResult result : results) {
            Winning winning = result.getWinning();
            String message = result.toString();
            if (winning != Winning.NONE) {
                System.out.printf("%s - %d개%n", message, stats.get(winning));
            }
        }
    }

}
