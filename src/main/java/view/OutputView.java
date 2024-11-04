package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Lotto;

public class OutputView {

    private final List<String> statisticsMessages = List.of(
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    );

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.print('[');

            String numbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println(numbers + ']');
        }
    }

    public void showStatistics(List<Integer> matchNumberCount) {
        for (int i = 3; i < matchNumberCount.size(); i++) {
            System.out.println(statisticsMessages.get(i - 3) + matchNumberCount.get(i) + "개");
        }
    }

    public void showProfitMargin(String profitMargin) {
        System.out.println("총 수익률은 " + profitMargin + "입니다.");
    }
}
