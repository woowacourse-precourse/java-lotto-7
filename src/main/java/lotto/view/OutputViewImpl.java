package lotto.view;

import lotto.checker.domain.Lottos;
import lotto.purchase.domain.Money;
import lotto.results.domain.Result;
import lotto.results.domain.Results;

import java.util.stream.IntStream;

import static lotto.common.NumberConstants.SECOND_RANK;
import static lotto.common.NumberConstants.TOTAL_RANK_TYPES;

public class OutputViewImpl implements OutputView {

    public void showMoneyPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottos(Lottos lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.print(lotto.toString() + "\n");
        });
    }

    public void showWinningNumbersPrompt() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void showBonusNumberPrompt() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void showResults(Results results, Money money) {
        System.out.println("\n당첨 통계\n" + "---");

        int[] count = results.getCountOfRank();
        IntStream.range(1, TOTAL_RANK_TYPES)
                .map(n -> TOTAL_RANK_TYPES - n)
                .forEach(rank -> {
                    Result result = Result.findByRank(rank);
                    String matchCount = result.getWinningNumberCount() + "개 일치";
                    String secondPlace = isSecond(result);
                    String prizeInfo = String.format("(" + result.getPrize() + "원)");
                    String countInfo = String.format(" - %d개", count[rank]);

                    System.out.println(String.join("", matchCount, secondPlace, prizeInfo, countInfo));
                });

        System.out.println("총 수익률은 " + results.getSumOfROI(money) + "%입니다.");
    }

    public String isSecond(Result result) {
        if (result.rank() == SECOND_RANK) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }
}
